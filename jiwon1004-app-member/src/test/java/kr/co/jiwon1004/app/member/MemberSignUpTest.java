package kr.co.jiwon1004.app.member;

import kr.co.jiwon1004.app.member.service.MemberSignUpService;
import kr.co.jiwon1004.domain.member.dto.request.MemberSignUpRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MemberSignUpTest {

    @Autowired
    MemberSignUpService memberSignUpService;

    @Test
    void signUp() {
        MemberSignUpRequest memberSignUpRequest = new MemberSignUpRequest();
        memberSignUpRequest.setUserId("jiwon1004");
        memberSignUpRequest.setPassword("qwer1234");
        memberSignUpRequest.setName("박지원");
        memberSignUpRequest.setBirth("20191004");
        memberSignUpRequest.setGender("WOMEN");
        memberSignUpRequest.setEmail("jiwon1004@naver.com");
        memberSignUpRequest.setPhone("01099999999");
        String result = memberSignUpService.memberSignUp(memberSignUpRequest);
        //성공여부
        assertThat(result).isEqualTo("SUCCESS");
    }
}
