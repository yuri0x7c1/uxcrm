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
 * Work Effort Party Assign And Role Type
 */
@FieldNameConstants
public class WorkEffortPartyAssignAndRoleType implements Serializable {

	public static final long serialVersionUID = 8489119005397280768L;
	public static final String NAME = "WorkEffortPartyAssignAndRoleType";
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
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
	 * Assigned By User Login Id
	 */
	@Getter
	@Setter
	private String assignedByUserLoginId;
	/**
	 * Delegate Reason Enum Id
	 */
	@Getter
	@Setter
	private String delegateReasonEnumId;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
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
	 * Availability Status Id
	 */
	@Getter
	@Setter
	private String availabilityStatusId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
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

	public WorkEffortPartyAssignAndRoleType(GenericValue value) {
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		facilityId = (String) value.get(FIELD_FACILITY_ID);
		comments = (String) value.get(FIELD_COMMENTS);
		mustRsvp = (String) value.get(FIELD_MUST_RSVP);
		assignedByUserLoginId = (String) value
				.get(FIELD_ASSIGNED_BY_USER_LOGIN_ID);
		delegateReasonEnumId = (String) value
				.get(FIELD_DELEGATE_REASON_ENUM_ID);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		statusId = (String) value.get(FIELD_STATUS_ID);
		statusDateTime = (Timestamp) value.get(FIELD_STATUS_DATE_TIME);
		expectationEnumId = (String) value.get(FIELD_EXPECTATION_ENUM_ID);
		availabilityStatusId = (String) value.get(FIELD_AVAILABILITY_STATUS_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		parentTypeId = (String) value.get(FIELD_PARENT_TYPE_ID);
		hasTable = (String) value.get(FIELD_HAS_TABLE);
		description = (String) value.get(FIELD_DESCRIPTION);
	}

	public static WorkEffortPartyAssignAndRoleType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortPartyAssignAndRoleType(value);
	}

	public static List<WorkEffortPartyAssignAndRoleType> fromValues(
			List<GenericValue> values) {
		List<WorkEffortPartyAssignAndRoleType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortPartyAssignAndRoleType(value));
		}
		return entities;
	}
}