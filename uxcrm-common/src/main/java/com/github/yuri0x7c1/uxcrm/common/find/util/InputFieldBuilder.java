package com.github.yuri0x7c1.uxcrm.common.find.util;

import java.util.HashMap;
import java.util.Map;

public class InputFieldBuilder {
	private Map<String, String> inputFields;

	public InputFieldBuilder() {
		inputFields = new HashMap<>();
	}

	public InputFieldBuilder(Map<String, String> inputFields) {
		this.inputFields = inputFields;
	}

	public InputFieldBuilder addInputField(String fieldName, String option,
			boolean ignoreCase, String fieldValue) {
		inputFields.put(FindUtil.getFieldOptionKey(fieldName), option);
		inputFields.put(FindUtil.getFieldIgnoreCaseKey(fieldName), ignoreCase ? FindUtil.Y : FindUtil.N);
		inputFields.put(fieldName, fieldValue);

		return this;
	}

	public Map<String, String> build() {
		return inputFields;
	}
}
