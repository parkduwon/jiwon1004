package kr.co.jiwon1004.common.codes;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

public enum Role {
	SUPER("ROLE_SUPER"), // 개발자권한
	ADMIN("ROLE_ADMIN"), // 관리자권한
	USER("ROLE_USER"), // 사용자권한
	NONE("ROLE_NONE"), // 업무용
	@JsonEnumDefaultValue
	UNKNOWN("UNKNOWN");

	private final String value;

	Role(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

}
