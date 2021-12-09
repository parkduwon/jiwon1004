package kr.co.jiwon1004.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "kr.co.jiwon1004")
public class MemberApplication {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		SpringApplication.run(MemberApplication.class, args);
	}
}
