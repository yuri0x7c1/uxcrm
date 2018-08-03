package org.apache.ofbiz.workeffort.workeffort;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort Purpose Type
 */
public class WorkEffortPurposeType implements Serializable {

	public static final long serialVersionUID = 4091696628755074048L;
	public static final String NAME = "WorkEffortPurposeType";
	/**
	 * Work Effort Purpose Type Id
	 */
	@Getter
	@Setter
	private String workEffortPurposeTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
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
		workEffortPurposeTypeId, parentTypeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public WorkEffortPurposeType(GenericValue value) {
		workEffortPurposeTypeId = (String) value
				.get(Fields.workEffortPurposeTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static WorkEffortPurposeType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortPurposeType(value);
	}

	public static List<WorkEffortPurposeType> fromValues(
			List<GenericValue> values) {
		List<WorkEffortPurposeType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortPurposeType(value));
		}
		return entities;
	}
}