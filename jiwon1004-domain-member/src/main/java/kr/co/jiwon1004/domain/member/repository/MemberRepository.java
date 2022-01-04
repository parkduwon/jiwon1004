package kr.co.jiwon1004.domain.member.repository;

import kr.co.jiwon1004.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
	Optional<Member> findMemberByMemberId(String memberId);
	void deleteMemberByMemberId(String memberId);
}
