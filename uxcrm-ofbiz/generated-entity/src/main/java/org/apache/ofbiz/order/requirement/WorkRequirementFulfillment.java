package org.apache.ofbiz.order.requirement;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class WorkRequirementFulfillment implements Serializable {

	public static final long serialVersionUID = 5512581469778260992L;
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

	public WorkRequirementFulfillment(GenericValue value) {
		requirementId = (String) value.get(FIELD_REQUIREMENT_ID);
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		workReqFulfTypeId = (String) value.get(FIELD_WORK_REQ_FULF_TYPE_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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