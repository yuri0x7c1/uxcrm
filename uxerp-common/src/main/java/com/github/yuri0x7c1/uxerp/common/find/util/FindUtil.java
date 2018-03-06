package com.github.yuri0x7c1.uxerp.common.find.util;

import java.util.Map;

public class FindUtil {
	public static final String Y = "Y";
	public static final String N = "N";

	public static final String OPTION_EQUALS = "equals";
	public static final String OPTION_CONTAINS = "contains";

	public static final String SUFFIX_OPTION = "op";
	public static final String SUFFIX_IGNORE_CASE = "ic";

	/**
	 * Get field option key
	 * @param fieldName
	 * @return
	 */
	public static final String getFieldOptionKey(String fieldName) {
		return fieldName + "_" + SUFFIX_OPTION;
	}

	/**
	 * Get field ignore case key
	 * @param fieldName
	 * @return
	 */
	public static final String getFieldIgnoreCaseKey(String fieldName) {
		return fieldName + "_" + SUFFIX_IGNORE_CASE;
	}

	/**
	 * Add input field
	 * @param inputFields
	 * @param fieldName
	 * @param option
	 * @param ignoreCase
	 * @param fieldValue
	 */
	public static final void addInputField(Map<String, Object> inputFields, String fieldName, String option,
			boolean ignoreCase, String fieldValue) {
		inputFields.put(getFieldOptionKey(fieldName), option);
		inputFields.put(getFieldIgnoreCaseKey(fieldName), ignoreCase);
		inputFields.put(fieldName, fieldValue);
	}
}
