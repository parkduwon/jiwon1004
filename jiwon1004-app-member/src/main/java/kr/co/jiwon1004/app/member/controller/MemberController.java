package kr.co.jiwon1004.app.member.controller;

import kr.co.jiwon1004.app.member.dto.response.MemberSearchResponse;
import kr.co.jiwon1004.app.member.service.MemberService;
import kr.co.jiwon1004.domain.member.dto.request.MemberRequest;
import kr.co.jiwon1004.domain.member.dto.request.MemberSearchRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@RestController
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;

	@GetMapping(path="/members")
	public MemberSearchResponse getMembers(MemberSearchRequest memberSearchRequest) {
		return memberService.getMembers(memberSearchRequest);
	}

	@PatchMapping(path="/members/{memberId}")
	public String saveMember(@PathVariable(value = "memberId") @NotEmpty String memberId, @RequestBody @Valid MemberRequest memberRequest) {
		memberService.saveMember(memberId, memberRequest);
		return "SUCCESS";
	}

	@DeleteMapping(path="/members/{memberId}")
	public String deleteMember(@PathVariable(value = "memberId") @NotEmpty String memberId) {
		memberService.deleteMember(memberId);
		return "SUCCESS";
	}
}
