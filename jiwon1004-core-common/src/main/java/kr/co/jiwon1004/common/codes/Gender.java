package kr.co.jiwon1004.common.codes;

public enum Gender {
	MAN("남자"),
	WOMEN("여자");

	private final String value;

	Gender(String value) {
		this.value = value;
	}
	public String getValue() {
		return this.value;
	}
}
