package kr.co.jiwon1004.app.member.controller;

import kr.co.jiwon1004.app.member.service.MemberSignUpService;
import kr.co.jiwon1004.domain.member.dto.request.MemberSignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberSignUpController {

	private final MemberSignUpService memberSignUpService;

	@PostMapping("/open/signUp")
	public String signUP(@RequestBody MemberSignUpRequest memberSignUpRequest) {
		memberSignUpService.memberSignUp(memberSignUpRequest);
		return "SUCCESS";
	}
}
