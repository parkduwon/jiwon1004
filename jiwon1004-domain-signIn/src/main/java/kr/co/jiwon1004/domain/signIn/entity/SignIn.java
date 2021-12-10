package kr.co.jiwon1004.domain.signIn.entity;

import kr.co.jiwon1004.common.entity.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sign_in",
		indexes = {
				@Index(name = "idx_sign_in_user_id", columnList = "user_id")
		})
public class SignIn extends BaseTimeEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "user_id", length = 100, unique = true)
	private String userId;

	@Column(length = 100)
	private String password;
	@Column(length = 10)
	private String salt;
	@Column(name = "member_roles", length = 50)
	private String roles;
	@Column(name = "member_name", length = 100)
	private String memberName;
	private boolean isTempPassword;				//임시비번여부
	private boolean isAccountNonExpired;		//계정만료여부
	private boolean isAccountNonLocked;			//계정잠김여부
	private boolean isCredentialsNonExpired;	//비밀번호만료여부
	private boolean isEnabled;					//활성화계정여부

	private int signInCnt;						//계정로그인횟수
	private int signInFailCnt;					//계정로그인실패횟수
	private LocalDateTime pwExpireDt;           //패스워드 만료기간

	// ENUM으로 안하고 ,로 해서 구분해서 ROLE을 입력 -> 그걸 파싱!!
	public List<String> getRoleList(){
		if(this.roles.length() > 0){
			return Arrays.asList(this.roles.split(","));
		}
		return new ArrayList<>();
	}

	@Builder
	public SignIn(
			String userId,
			String password,
			String salt,
			List<String> roles,
			String memberName,
			boolean isTempPassword,
			boolean isAccountNonExpired,
			boolean isAccountNonLocked,
			boolean isCredentialsNonExpired,
			boolean isEnabled) {
		this.userId = userId;
		this.password = password;
		this.salt = salt;
		this.roles = String.join(",", roles);
		this.memberName = memberName;
		this.isAccountNonExpired = isAccountNonExpired;
		this.isAccountNonLocked = isAccountNonLocked;
		this.isTempPassword = isTempPassword;
		this.isCredentialsNonExpired = isCredentialsNonExpired;
		this.isEnabled = isEnabled;
	}
}