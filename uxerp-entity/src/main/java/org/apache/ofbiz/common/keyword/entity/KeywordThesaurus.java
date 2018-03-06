package org.apache.ofbiz.common.keyword.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Keyword Thesaurus
 */
public class KeywordThesaurus implements Serializable {

	public static final long serialVersionUID = 1898169156373300224L;
	public static final String NAME = "KeywordThesaurus";
	/**
	 * Entered Keyword
	 */
	@Getter
	@Setter
	private String enteredKeyword;
	/**
	 * Alternate Keyword
	 */
	@Getter
	@Setter
	private String alternateKeyword;
	/**
	 * Relationship Enum Id
	 */
	@Getter
	@Setter
	private String relationshipEnumId;

	public enum Fields {
		enteredKeyword, alternateKeyword, relationshipEnumId
	}

	public KeywordThesaurus(GenericValue value) {
		enteredKeyword = (String) value.get(Fields.enteredKeyword.name());
		alternateKeyword = (String) value.get(Fields.alternateKeyword.name());
		relationshipEnumId = (String) value.get(Fields.relationshipEnumId
				.name());
	}

	public static KeywordThesaurus fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new KeywordThesaurus(value);
	}

	public static List<KeywordThesaurus> fromValues(List<GenericValue> values) {
		List<KeywordThesaurus> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new KeywordThesaurus(value));
		}
		return entities;
	}
}