package kr.co.jiwon1004.app.member;

import kr.co.jiwon1004.app.member.dto.response.MemberSearchResponse;
import kr.co.jiwon1004.domain.member.repository.MemberRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.MalformedURLException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MemberSignUpTest {

    @Autowired
    MemberTestDataHelper memberTestDataHelper;

    @Autowired
    TestRestTemplate restTemplate;

    static URL base;

    static int port;

    static String memberId;

    @BeforeAll
    static void setUp(@LocalServerPort int instancePort) throws MalformedURLException {
        port = instancePort;
        base = new URL("http://localhost:" + port);
        memberId = "testMember";
    }

    @AfterAll
    static void destroy(@Autowired MemberRepository memberRepository) {
        memberRepository.findMemberByMemberId(memberId).ifPresent(memberRepository::delete);
    }

    @Test
    @DisplayName("1. 회원가입")
    @Order(1)
    void signUp() throws JSONException {
        //Given
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("memberId", memberId);
        jsonObject.put("userId", memberTestDataHelper.getUserId());
        jsonObject.put("password", memberTestDataHelper.getPassword());
        jsonObject.put("name", memberTestDataHelper.getName());
        jsonObject.put("birth", memberTestDataHelper.getBirth());
        jsonObject.put("gender", memberTestDataHelper.getGender());
        jsonObject.put("email", memberTestDataHelper.getEmail());
        jsonObject.put("phone", memberTestDataHelper.getPhone());

        //When
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(jsonObject.toString(), headers);
        ResponseEntity<String> response = restTemplate.exchange(base+"/open/signUp", HttpMethod.POST, entity, String.class);

        //Then
        assertThat(response.getBody()).isEqualTo("SUCCESS");
        System.out.println(response.getBody());

    }

    @Test
    @DisplayName("2. 회원찾기")
    @Order(2)
    void findMember() {
        //Given
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("memberId", memberId);

        UriComponents uri = UriComponentsBuilder
                .fromHttpUrl("http://localhost:" + port+"/members")
                .queryParams(params)
                .build();

        //When
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<MemberSearchResponse> response = restTemplate.exchange(uri.toUriString(), HttpMethod.GET, entity, MemberSearchResponse.class);

        //Then
        if(response.getBody() == null) {
            fail("restful 통신실패");
        } else {
            assertThat(memberTestDataHelper.getName()).isEqualTo(response.getBody().getMemberName());
        }

    }

    @Test
    @DisplayName("3. 회원수정")
    @Order(3)
    void saveMember() throws JSONException {
        //Given
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("memberId", memberId);
        jsonObject.put("email", "change@email.com");
        System.out.println(memberId);

        //When
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(jsonObject.toString(), headers);
        ResponseEntity<String> response = restTemplate.exchange(base+"/members", HttpMethod.PATCH, entity, String.class);

        //Then
        assertThat(response.getBody()).isEqualTo("SUCCESS");
    }

    @Test
    @DisplayName("4. 회원삭제")
    @Order(4)
    void deleteMember() throws JSONException {
        //Given
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("memberId", memberId);
        System.out.println(memberId);

        //When
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(jsonObject.toString(), headers);
        ResponseEntity<String> response = restTemplate.exchange(base+"/members", HttpMethod.DELETE, entity, String.class);

        //Then
        assertThat(response.getBody()).isEqualTo("SUCCESS");

    }

}
