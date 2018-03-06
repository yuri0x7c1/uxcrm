package org.apache.ofbiz.common.language.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Standard Language
 */
public class StandardLanguage implements Serializable {

	public static final long serialVersionUID = 6576304051550773248L;
	public static final String NAME = "StandardLanguage";
	/**
	 * Standard Language Id
	 */
	@Getter
	@Setter
	private String standardLanguageId;
	/**
	 * Lang Code 3 T
	 */
	@Getter
	@Setter
	private String langCode3t;
	/**
	 * Lang Code 3 B
	 */
	@Getter
	@Setter
	private String langCode3b;
	/**
	 * Lang Code 2
	 */
	@Getter
	@Setter
	private String langCode2;
	/**
	 * Lang Name
	 */
	@Getter
	@Setter
	private String langName;
	/**
	 * Lang Family
	 */
	@Getter
	@Setter
	private String langFamily;
	/**
	 * Lang Charset
	 */
	@Getter
	@Setter
	private String langCharset;

	public enum Fields {
		standardLanguageId, langCode3t, langCode3b, langCode2, langName, langFamily, langCharset
	}

	public StandardLanguage(GenericValue value) {
		standardLanguageId = (String) value.get(Fields.standardLanguageId
				.name());
		langCode3t = (String) value.get(Fields.langCode3t.name());
		langCode3b = (String) value.get(Fields.langCode3b.name());
		langCode2 = (String) value.get(Fields.langCode2.name());
		langName = (String) value.get(Fields.langName.name());
		langFamily = (String) value.get(Fields.langFamily.name());
		langCharset = (String) value.get(Fields.langCharset.name());
	}

	public static StandardLanguage fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new StandardLanguage(value);
	}

	public static List<StandardLanguage> fromValues(List<GenericValue> values) {
		List<StandardLanguage> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new StandardLanguage(value));
		}
		return entities;
	}
}