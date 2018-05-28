package org.apache.ofbiz.workeffort.workeffort;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort Content Type
 */
public class WorkEffortContentType implements Serializable {

	public static final long serialVersionUID = 6063762611336693760L;
	public static final String NAME = "WorkEffortContentType";
	/**
	 * Work Effort Content Type Id
	 */
	@Getter
	@Setter
	private String workEffortContentTypeId;
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
		workEffortContentTypeId, parentTypeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public WorkEffortContentType(GenericValue value) {
		workEffortContentTypeId = (String) value
				.get(Fields.workEffortContentTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static WorkEffortContentType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortContentType(value);
	}

	public static List<WorkEffortContentType> fromValues(
			List<GenericValue> values) {
		List<WorkEffortContentType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortContentType(value));
		}
		return entities;
	}
}