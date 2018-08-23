package org.apache.ofbiz.common.keyword;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class KeywordThesaurus implements Serializable {

	public static final long serialVersionUID = 6698787750738560000L;
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

	public KeywordThesaurus(GenericValue value) {
		enteredKeyword = (String) value.get(FIELD_ENTERED_KEYWORD);
		alternateKeyword = (String) value.get(FIELD_ALTERNATE_KEYWORD);
		relationshipEnumId = (String) value.get(FIELD_RELATIONSHIP_ENUM_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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