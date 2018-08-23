package org.apache.ofbiz.workeffort.workeffort;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort Search Constraint
 */
@FieldNameConstants
public class WorkEffortSearchConstraint implements Serializable {

	public static final long serialVersionUID = 3037632509696391168L;
	public static final String NAME = "WorkEffortSearchConstraint";
	/**
	 * Work Effort Search Result Id
	 */
	@Getter
	@Setter
	private String workEffortSearchResultId;
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
	 * Include Sub Work Efforts
	 */
	@Getter
	@Setter
	private String includeSubWorkEfforts;
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

	public WorkEffortSearchConstraint(GenericValue value) {
		workEffortSearchResultId = (String) value
				.get(FIELD_WORK_EFFORT_SEARCH_RESULT_ID);
		constraintSeqId = (String) value.get(FIELD_CONSTRAINT_SEQ_ID);
		constraintName = (String) value.get(FIELD_CONSTRAINT_NAME);
		infoString = (String) value.get(FIELD_INFO_STRING);
		includeSubWorkEfforts = (String) value
				.get(FIELD_INCLUDE_SUB_WORK_EFFORTS);
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

	public static WorkEffortSearchConstraint fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortSearchConstraint(value);
	}

	public static List<WorkEffortSearchConstraint> fromValues(
			List<GenericValue> values) {
		List<WorkEffortSearchConstraint> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortSearchConstraint(value));
		}
		return entities;
	}
}