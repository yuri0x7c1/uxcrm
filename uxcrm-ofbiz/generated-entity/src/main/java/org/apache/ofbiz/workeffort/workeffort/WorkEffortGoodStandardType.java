package org.apache.ofbiz.workeffort.workeffort;

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
public class WorkEffortGoodStandardType implements Serializable {

	public static final long serialVersionUID = 2200400911053599744L;
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

	public enum Fields {
		workEffortGoodStdTypeId, parentTypeId, hasTable, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public WorkEffortGoodStandardType(GenericValue value) {
		workEffortGoodStdTypeId = (String) value
				.get(Fields.workEffortGoodStdTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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