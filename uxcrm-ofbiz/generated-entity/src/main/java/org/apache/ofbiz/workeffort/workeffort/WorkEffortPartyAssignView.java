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
 * Work Effort Party Assign View
 */
@FieldNameConstants
public class WorkEffortPartyAssignView implements Serializable {

	public static final long serialVersionUID = 4942814626488814592L;
	public static final String NAME = "WorkEffortPartyAssignView";
	/**
	 * Assignment Status Id
	 */
	@Getter
	@Setter
	private String assignmentStatusId;
	/**
	 * Last Name
	 */
	@Getter
	@Setter
	private String lastName;
	/**
	 * Last Name Local
	 */
	@Getter
	@Setter
	private String lastNameLocal;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Suffix
	 */
	@Getter
	@Setter
	private String suffix;
	/**
	 * Party Type Id
	 */
	@Getter
	@Setter
	private String partyTypeId;
	/**
	 * First Name
	 */
	@Getter
	@Setter
	private String firstName;
	/**
	 * Group Name
	 */
	@Getter
	@Setter
	private String groupName;
	/**
	 * Group Name Local
	 */
	@Getter
	@Setter
	private String groupNameLocal;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Middle Name
	 */
	@Getter
	@Setter
	private String middleName;
	/**
	 * First Name Local
	 */
	@Getter
	@Setter
	private String firstNameLocal;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Personal Title
	 */
	@Getter
	@Setter
	private String personalTitle;
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

	public WorkEffortPartyAssignView(GenericValue value) {
		assignmentStatusId = (String) value.get(FIELD_ASSIGNMENT_STATUS_ID);
		lastName = (String) value.get(FIELD_LAST_NAME);
		lastNameLocal = (String) value.get(FIELD_LAST_NAME_LOCAL);
		description = (String) value.get(FIELD_DESCRIPTION);
		suffix = (String) value.get(FIELD_SUFFIX);
		partyTypeId = (String) value.get(FIELD_PARTY_TYPE_ID);
		firstName = (String) value.get(FIELD_FIRST_NAME);
		groupName = (String) value.get(FIELD_GROUP_NAME);
		groupNameLocal = (String) value.get(FIELD_GROUP_NAME_LOCAL);
		statusId = (String) value.get(FIELD_STATUS_ID);
		middleName = (String) value.get(FIELD_MIDDLE_NAME);
		firstNameLocal = (String) value.get(FIELD_FIRST_NAME_LOCAL);
		partyId = (String) value.get(FIELD_PARTY_ID);
		personalTitle = (String) value.get(FIELD_PERSONAL_TITLE);
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
		statusDateTime = (Timestamp) value.get(FIELD_STATUS_DATE_TIME);
		expectationEnumId = (String) value.get(FIELD_EXPECTATION_ENUM_ID);
		availabilityStatusId = (String) value.get(FIELD_AVAILABILITY_STATUS_ID);
	}

	public static WorkEffortPartyAssignView fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortPartyAssignView(value);
	}

	public static List<WorkEffortPartyAssignView> fromValues(
			List<GenericValue> values) {
		List<WorkEffortPartyAssignView> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortPartyAssignView(value));
		}
		return entities;
	}
}