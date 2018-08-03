package org.apache.ofbiz.order.requirement;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Requirement Fulfillment
 */
public class WorkRequirementFulfillment implements Serializable {

	public static final long serialVersionUID = 5453517491391299584L;
	public static final String NAME = "WorkRequirementFulfillment";
	/**
	 * Requirement Id
	 */
	@Getter
	@Setter
	private String requirementId;
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Work Req Fulf Type Id
	 */
	@Getter
	@Setter
	private String workReqFulfTypeId;
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
		requirementId, workEffortId, workReqFulfTypeId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public WorkRequirementFulfillment(GenericValue value) {
		requirementId = (String) value.get(Fields.requirementId.name());
		workEffortId = (String) value.get(Fields.workEffortId.name());
		workReqFulfTypeId = (String) value.get(Fields.workReqFulfTypeId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static WorkRequirementFulfillment fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkRequirementFulfillment(value);
	}

	public static List<WorkRequirementFulfillment> fromValues(
			List<GenericValue> values) {
		List<WorkRequirementFulfillment> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkRequirementFulfillment(value));
		}
		return entities;
	}
}