package kr.co.jiwon1004.domain.member.dto.request;

import kr.co.jiwon1004.common.codes.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class MemberRequest {

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
