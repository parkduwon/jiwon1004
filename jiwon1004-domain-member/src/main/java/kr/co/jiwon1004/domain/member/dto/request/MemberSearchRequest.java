package kr.co.jiwon1004.domain.member.dto.request;

import kr.co.jiwon1004.common.codes.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
public class MemberSearchRequest {

	@Size(max = 50)
	private String memberId;

	@Size(max = 50)
	private String email;

	@Size(max = 100)
	private String name;

	@Size(max = 1)
	private Gender gender;

	@Size(max = 8)
	private String birth;

	@Size(max = 11)
	private String phone;
	
}
