package kr.co.jiwon1004.app.member.service;

import kr.co.jiwon1004.app.member.dto.response.MemberSearchResponse;
import kr.co.jiwon1004.domain.member.dto.request.MemberRequest;
import kr.co.jiwon1004.domain.member.dto.request.MemberSearchRequest;
import kr.co.jiwon1004.domain.member.entity.Member;
import kr.co.jiwon1004.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

	private final MemberRepository memberRepository;

	@Transactional(readOnly = true)
	public MemberSearchResponse getMembers(MemberSearchRequest memberSearchRequest) {
		Member member = memberRepository.findMemberByMemberId(memberSearchRequest.getMemberId())
				.orElseThrow(()-> new UsernameNotFoundException("멤버를 찾을 수 없습니다."));
		return MemberSearchResponse.builder()
				.memberName(member.getMemberName())
				.birth(member.getBirth())
				.email(member.getEmail())
				.phone(member.getPhone())
				.gender(member.getGender())
				.userId(member.getSignIn().getUserId())
				.registerDt(member.getSignIn().getCreatedDate())
				.build();
	}

	@Transactional
	public void saveMember(String memberId, MemberRequest memberRequest) {
		memberRepository.findMemberByMemberId(memberId).ifPresentOrElse(
			member -> {
				member.setEmail(memberRequest.getEmail());
			},
			() -> {
				throw new UsernameNotFoundException("멤버를 찾을 수 없습니다.");
			}
		);
	}

	@Transactional
	public void deleteMember(String memberId) {
		memberRepository.findMemberByMemberId(memberId).ifPresentOrElse(
				memberRepository::delete,
				() -> {
					throw new UsernameNotFoundException("멤버를 찾을 수 없습니다.");
				}
		);
	}

}
