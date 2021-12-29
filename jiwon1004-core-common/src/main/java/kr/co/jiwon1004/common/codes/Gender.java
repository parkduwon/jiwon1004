package kr.co.jiwon1004.common.codes;

import org.apache.commons.lang3.StringUtils;

public enum Gender {
	MAN,
	WOMEN;

	public static Gender getValue(String value) {
		for(Gender gender : values()) {
			if(StringUtils.equals(gender.name(), value)) {
				return gender;
			}
		}
		return null;
	}
}
