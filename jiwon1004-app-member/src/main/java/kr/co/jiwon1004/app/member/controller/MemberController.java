package kr.co.jiwon1004.app.member.controller;

import kr.co.jiwon1004.app.member.dto.response.MemberSearchResponse;
import kr.co.jiwon1004.app.member.service.MemberService;
import kr.co.jiwon1004.domain.member.dto.request.MemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;

	@GetMapping(path="/members")
	public MemberSearchResponse getMembers(MemberRequest memberRequest) {
		System.out.println("여기는 getMembers 콘트롤러인데 여기오나?");
		System.out.println(memberRequest.getMemberId());
		return memberService.getMembers(memberRequest);
	}

	@PutMapping(path="/members")
	public String saveMember(@RequestBody @Valid MemberRequest memberRequest) {
		System.out.println("여기는 saveMember 콘트롤러인데 여기오나?");
		memberService.saveMember(memberRequest);
		return "SUCCESS";
	}

	@DeleteMapping(path="/members")
	public String deleteMember(@RequestBody @Valid MemberRequest memberRequest) {
		System.out.println("여기는 deleteMember 콘트롤러인데 여기오나?");
		memberService.deleteMember(memberRequest);
		return "SUCCESS";
	}
}
