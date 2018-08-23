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
 * Work Effort Party Assignment
 */
@FieldNameConstants
public class WorkEffortPartyAssignment implements Serializable {

	public static final long serialVersionUID = 2172978027530949632L;
	public static final String NAME = "WorkEffortPartyAssignment";
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Assigned By User Login Id
	 */
	@Getter
	@Setter
	private String assignedByUserLoginId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Status Date Time
	 */
	@Getter
	@Setter
	private Timestamp statusDateTime;
	/**
	 * Expectation Enum Id
	 */
	@Getter
	@Setter
	private String expectationEnumId;
	/**
	 * Delegate Reason Enum Id
	 */
	@Getter
	@Setter
	private String delegateReasonEnumId;
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Must Rsvp
	 */
	@Getter
	@Setter
	private String mustRsvp;
	/**
	 * Availability Status Id
	 */
	@Getter
	@Setter
	private String availabilityStatusId;
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

	public WorkEffortPartyAssignment(GenericValue value) {
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		assignedByUserLoginId = (String) value
				.get(FIELD_ASSIGNED_BY_USER_LOGIN_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		statusDateTime = (Timestamp) value.get(FIELD_STATUS_DATE_TIME);
		expectationEnumId = (String) value.get(FIELD_EXPECTATION_ENUM_ID);
		delegateReasonEnumId = (String) value
				.get(FIELD_DELEGATE_REASON_ENUM_ID);
		facilityId = (String) value.get(FIELD_FACILITY_ID);
		comments = (String) value.get(FIELD_COMMENTS);
		mustRsvp = (String) value.get(FIELD_MUST_RSVP);
		availabilityStatusId = (String) value.get(FIELD_AVAILABILITY_STATUS_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static WorkEffortPartyAssignment fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortPartyAssignment(value);
	}

	public static List<WorkEffortPartyAssignment> fromValues(
			List<GenericValue> values) {
		List<WorkEffortPartyAssignment> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortPartyAssignment(value));
		}
		return entities;
	}
}