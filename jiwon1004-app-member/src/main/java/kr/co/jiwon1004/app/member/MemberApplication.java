package kr.co.jiwon1004.app.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(scanBasePackages = "kr.co.jiwon1004")
@EnableJpaAuditing
public class MemberApplication {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		SpringApplication.run(MemberApplication.class, args);
	}
}
