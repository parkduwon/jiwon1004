package kr.co.jiwon1004.domain.member.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kr.co.jiwon1004.common.codes.Gender;
import kr.co.jiwon1004.common.entity.BaseTimeEntity;
import kr.co.jiwon1004.domain.signIn.entity.SignIn;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "member",
		indexes = {
				@Index(name = "idx_member_member_name", columnList = "member_name"),
				@Index(name = "idx_member_email", columnList = "email"),
				@Index(name = "idx_member_phone", columnList = "phone")
		})
public class Member extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//멤버의 고유 id 외부노출 안한다.
	@Column(name = "member_id", length = 10, unique = true, nullable = false, updatable = false)
	@JsonIgnore
	private String memberId;

	@Column(length = 8)
	private String birth;

	@Column(length = 5)
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Column(length = 100)
	private String email;

	@Column(length = 11)
	private String phone;

	@Column(name = "member_name", length = 100)
	private String memberName;

	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="sign_in", nullable = false, unique = true, updatable = false)
	private SignIn signIn;

	@Builder
	public Member(String email, String memberId, String memberName, String phone, String birth, Gender gender, SignIn signIn) {
		this.email = email;
		this.memberId = memberId;
		this.memberName = memberName;
		this.phone = phone;
		this.birth = birth;
		this.gender = gender;
		this.signIn = signIn;
	}

}
