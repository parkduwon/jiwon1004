package kr.co.jiwon1004.app.member;

import kr.co.jiwon1004.app.member.service.MemberSignUpService;
import kr.co.jiwon1004.domain.member.dto.request.MemberSignUpRequest;
import kr.co.jiwon1004.domain.member.entity.Member;
import kr.co.jiwon1004.domain.member.repository.MemberRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class MemberSignUpTest {

    @Autowired
    MemberSignUpService memberSignUpService;

    @Autowired
    MemberTestDataHelper memberTestDataHelper;

    @Autowired
    MemberRepository memberRepository;

    @Test
    void signUp() {
        //Given
        MemberSignUpRequest memberSignUpRequest = new MemberSignUpRequest();
        memberSignUpRequest.setUserId(memberTestDataHelper.getUserId());
        memberSignUpRequest.setPassword(memberTestDataHelper.getPassword());
        memberSignUpRequest.setName(memberTestDataHelper.getName());
        memberSignUpRequest.setBirth(memberTestDataHelper.getBirth());
        memberSignUpRequest.setGender(memberTestDataHelper.getGender());
        memberSignUpRequest.setEmail(memberTestDataHelper.getEmail());
        memberSignUpRequest.setPhone(memberTestDataHelper.getPhone());

        //When
        memberSignUpService.memberSignUp(memberSignUpRequest);

        //Then
        Member member = memberRepository.findMemberByMemberName(memberTestDataHelper.getName()).orElseThrow(NullPointerException::new);
        assertThat(member.getMemberName()).isEqualTo(memberTestDataHelper.getName());
        assertThat(member.getSignIn().getUserId()).isEqualTo(memberTestDataHelper.getUserId());
        System.out.println("유저아이디 : " + member.getSignIn().getUserId());
    }

}
