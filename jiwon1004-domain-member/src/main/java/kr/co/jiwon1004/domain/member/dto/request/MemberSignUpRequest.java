package kr.co.jiwon1004.domain.member.dto.request;

import com.sun.istack.NotNull;
import kr.co.jiwon1004.common.codes.Gender;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
public class MemberSignUpRequest {

	@Size(max = 50)
	private String userId;

	@Size(max = 50)
	private String memberId;

	@NotNull
	@Size(max = 40)
	private String password;

	@Size(max = 50)
	private String email;

	@NotBlank
	@Size(max = 100)
	private String name;

	@NotNull
	@Size(max = 1)
	private Gender gender;

	@NotNull
	@Size(max = 8)
	private String birth;

	@NotNull
	@Size(max = 11)
	private String phone;


	public void setGender(String gender){
		this.gender = Gender.getValue(gender);
	}

}
