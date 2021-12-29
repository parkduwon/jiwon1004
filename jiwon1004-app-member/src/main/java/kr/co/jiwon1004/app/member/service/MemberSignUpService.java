package kr.co.jiwon1004.app.member.service;

import kr.co.jiwon1004.common.codes.Role;
import kr.co.jiwon1004.domain.member.dto.request.MemberSignUpRequest;
import kr.co.jiwon1004.domain.member.entity.Member;
import kr.co.jiwon1004.domain.member.repository.MemberRepository;
import kr.co.jiwon1004.domain.signIn.entity.SignIn;
import kr.co.jiwon1004.domain.signIn.repository.SignInRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberSignUpService {

	private final MemberRepository memberRepository;
	private final SignInRepository signInRepository;

	@Transactional
	public void memberSignUp(MemberSignUpRequest memberSignUpRequest) {
		SignIn signIn = convertSignInWhenSignUP(memberSignUpRequest);
		Member member = Member.builder()
				.memberName(memberSignUpRequest.getName())
				.email(memberSignUpRequest.getEmail())
				.gender(memberSignUpRequest.getGender())
				.birth(memberSignUpRequest.getBirth())
				.signIn(signIn)
				.build();
		signInRepository.save(signIn);
		memberRepository.save(member);
	}

	public SignIn convertSignInWhenSignUP(MemberSignUpRequest memberSignUpRequest) {
		String salt = RandomStringUtils.randomAlphanumeric(10);
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return SignIn.builder()
				.userId(memberSignUpRequest.getUserId())
				.salt(salt)
				.password(passwordEncoder.encode(memberSignUpRequest.getPassword().concat(salt)))
				.isTempPassword(false)
				.isEnabled(true)
				.roles(List.of(Role.USER.getValue()))
				.build();
	}

}
