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
 * Work Effort Good Standard Type
 */
@FieldNameConstants
public class WorkEffortGoodStandardType implements Serializable {

	public static final long serialVersionUID = 8420627428420319232L;
	public static final String NAME = "WorkEffortGoodStandardType";
	/**
	 * Work Effort Good Std Type Id
	 */
	@Getter
	@Setter
	private String workEffortGoodStdTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Has Table
	 */
	@Getter
	@Setter
	private String hasTable;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
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

	public WorkEffortGoodStandardType(GenericValue value) {
		workEffortGoodStdTypeId = (String) value
				.get(FIELD_WORK_EFFORT_GOOD_STD_TYPE_ID);
		parentTypeId = (String) value.get(FIELD_PARENT_TYPE_ID);
		hasTable = (String) value.get(FIELD_HAS_TABLE);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static WorkEffortGoodStandardType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortGoodStandardType(value);
	}

	public static List<WorkEffortGoodStandardType> fromValues(
			List<GenericValue> values) {
		List<WorkEffortGoodStandardType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortGoodStandardType(value));
		}
		return entities;
	}
}