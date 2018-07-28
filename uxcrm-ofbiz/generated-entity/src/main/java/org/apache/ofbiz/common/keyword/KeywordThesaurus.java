package org.apache.ofbiz.common.keyword;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Keyword Thesaurus
 */
public class KeywordThesaurus implements Serializable {

	public static final long serialVersionUID = 7499856267728004096L;
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
	/**
	 * Last Updated Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedStamp;
	/**
	 * Last Updated Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedTxStamp;
	/**
	 * Created Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdStamp;
	/**
	 * Created Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdTxStamp;

	public enum Fields {
		enteredKeyword, alternateKeyword, relationshipEnumId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public KeywordThesaurus(GenericValue value) {
		enteredKeyword = (String) value.get(Fields.enteredKeyword.name());
		alternateKeyword = (String) value.get(Fields.alternateKeyword.name());
		relationshipEnumId = (String) value.get(Fields.relationshipEnumId
				.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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