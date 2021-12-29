package kr.co.jiwon1004.app.member;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "test.member")
@Getter
@Setter
public class MemberTestDataHelper {
	private String UserId;
	private String password;
	private String name;
	private String birth;
	private String gender;
	private String email;
	private String phone;
}
