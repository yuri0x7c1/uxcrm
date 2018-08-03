package org.apache.ofbiz.content.content;

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
public class ContentSearchConstraint implements Serializable {

	public static final long serialVersionUID = 2399036024923952128L;
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

	public enum Fields {
		contentSearchResultId, constraintSeqId, constraintName, infoString, includeSubCategories, isAnd, anyPrefix, anySuffix, removeStems, lowValue, highValue, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ContentSearchConstraint(GenericValue value) {
		contentSearchResultId = (String) value.get(Fields.contentSearchResultId
				.name());
		constraintSeqId = (String) value.get(Fields.constraintSeqId.name());
		constraintName = (String) value.get(Fields.constraintName.name());
		infoString = (String) value.get(Fields.infoString.name());
		includeSubCategories = (String) value.get(Fields.includeSubCategories
				.name());
		isAnd = (String) value.get(Fields.isAnd.name());
		anyPrefix = (String) value.get(Fields.anyPrefix.name());
		anySuffix = (String) value.get(Fields.anySuffix.name());
		removeStems = (String) value.get(Fields.removeStems.name());
		lowValue = (String) value.get(Fields.lowValue.name());
		highValue = (String) value.get(Fields.highValue.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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