package kr.co.jiwon1004.app.member.controller;

import kr.co.jiwon1004.app.member.dto.response.MemberSearchResponse;
import kr.co.jiwon1004.app.member.service.MemberService;
import kr.co.jiwon1004.domain.member.dto.request.MemberRequest;
import kr.co.jiwon1004.domain.member.dto.request.MemberSearchRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;

	@GetMapping(path="/members")
	public MemberSearchResponse getMembers(MemberSearchRequest memberSearchRequest) {
		return memberService.getMembers(memberSearchRequest);
	}

	@PutMapping(path="/members")
	public String saveMember(@RequestBody @Valid MemberRequest memberRequest) {
		memberService.saveMember(memberRequest);
		return "SUCCESS";
	}

	@DeleteMapping(path="/members")
	public String deleteMember(@RequestBody @Valid MemberRequest memberRequest) {
		memberService.deleteMember(memberRequest);
		return "SUCCESS";
	}
}
