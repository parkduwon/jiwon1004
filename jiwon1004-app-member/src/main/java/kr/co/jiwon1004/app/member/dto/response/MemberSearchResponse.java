package kr.co.jiwon1004.app.member.dto.response;


import com.fasterxml.jackson.annotation.JsonFormat;
import kr.co.jiwon1004.common.codes.Gender;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class MemberSearchResponse {
	private String memberName;
	private String birth;
	private String email;
	private Gender gender;
	private String userId;
	private String phone;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private LocalDateTime registerDt;

	@Builder
	public MemberSearchResponse(String memberName, String birth, String email, Gender gender, String userId, String phone, LocalDateTime registerDt) {
		this.memberName = memberName;
		this.birth = birth;
		this.email = email;
		this.gender = gender;
		this.userId = userId;
		this.phone = phone;
		this.registerDt = registerDt;
	}
}
