package org.apache.ofbiz.content.content;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Content Search Constraint
 */
@FieldNameConstants
public class ContentSearchConstraint implements Serializable {

	public static final long serialVersionUID = 5868527233644782592L;
	public static final String NAME = "ContentSearchConstraint";
	/**
	 * Content Search Result Id
	 */
	@Getter
	@Setter
	private String contentSearchResultId;
	/**
	 * Constraint Seq Id
	 */
	@Getter
	@Setter
	private String constraintSeqId;
	/**
	 * Constraint Name
	 */
	@Getter
	@Setter
	private String constraintName;
	/**
	 * Info String
	 */
	@Getter
	@Setter
	private String infoString;
	/**
	 * Include Sub Categories
	 */
	@Getter
	@Setter
	private String includeSubCategories;
	/**
	 * Is And
	 */
	@Getter
	@Setter
	private String isAnd;
	/**
	 * Any Prefix
	 */
	@Getter
	@Setter
	private String anyPrefix;
	/**
	 * Any Suffix
	 */
	@Getter
	@Setter
	private String anySuffix;
	/**
	 * Remove Stems
	 */
	@Getter
	@Setter
	private String removeStems;
	/**
	 * Low Value
	 */
	@Getter
	@Setter
	private String lowValue;
	/**
	 * High Value
	 */
	@Getter
	@Setter
	private String highValue;
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

	public ContentSearchConstraint(GenericValue value) {
		contentSearchResultId = (String) value
				.get(FIELD_CONTENT_SEARCH_RESULT_ID);
		constraintSeqId = (String) value.get(FIELD_CONSTRAINT_SEQ_ID);
		constraintName = (String) value.get(FIELD_CONSTRAINT_NAME);
		infoString = (String) value.get(FIELD_INFO_STRING);
		includeSubCategories = (String) value.get(FIELD_INCLUDE_SUB_CATEGORIES);
		isAnd = (String) value.get(FIELD_IS_AND);
		anyPrefix = (String) value.get(FIELD_ANY_PREFIX);
		anySuffix = (String) value.get(FIELD_ANY_SUFFIX);
		removeStems = (String) value.get(FIELD_REMOVE_STEMS);
		lowValue = (String) value.get(FIELD_LOW_VALUE);
		highValue = (String) value.get(FIELD_HIGH_VALUE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ContentSearchConstraint fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContentSearchConstraint(value);
	}

	public static List<ContentSearchConstraint> fromValues(
			List<GenericValue> values) {
		List<ContentSearchConstraint> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContentSearchConstraint(value));
		}
		return entities;
	}
}