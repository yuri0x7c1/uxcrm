package org.apache.ofbiz.workeffort.workeffort;

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
public class WorkEffortPartyAssignView implements Serializable {

	public static final long serialVersionUID = 7903561283980691456L;
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

	public enum Fields {
		assignmentStatusId, lastName, lastNameLocal, description, suffix, partyTypeId, firstName, groupName, groupNameLocal, statusId, middleName, firstNameLocal, partyId, personalTitle, workEffortId, roleTypeId, facilityId, comments, mustRsvp, assignedByUserLoginId, delegateReasonEnumId, thruDate, fromDate, statusDateTime, expectationEnumId, availabilityStatusId
	}

	public WorkEffortPartyAssignView(GenericValue value) {
		assignmentStatusId = (String) value.get(Fields.assignmentStatusId
				.name());
		lastName = (String) value.get(Fields.lastName.name());
		lastNameLocal = (String) value.get(Fields.lastNameLocal.name());
		description = (String) value.get(Fields.description.name());
		suffix = (String) value.get(Fields.suffix.name());
		partyTypeId = (String) value.get(Fields.partyTypeId.name());
		firstName = (String) value.get(Fields.firstName.name());
		groupName = (String) value.get(Fields.groupName.name());
		groupNameLocal = (String) value.get(Fields.groupNameLocal.name());
		statusId = (String) value.get(Fields.statusId.name());
		middleName = (String) value.get(Fields.middleName.name());
		firstNameLocal = (String) value.get(Fields.firstNameLocal.name());
		partyId = (String) value.get(Fields.partyId.name());
		personalTitle = (String) value.get(Fields.personalTitle.name());
		workEffortId = (String) value.get(Fields.workEffortId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		comments = (String) value.get(Fields.comments.name());
		mustRsvp = (String) value.get(Fields.mustRsvp.name());
		assignedByUserLoginId = (String) value.get(Fields.assignedByUserLoginId
				.name());
		delegateReasonEnumId = (String) value.get(Fields.delegateReasonEnumId
				.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		statusDateTime = (Timestamp) value.get(Fields.statusDateTime.name());
		expectationEnumId = (String) value.get(Fields.expectationEnumId.name());
		availabilityStatusId = (String) value.get(Fields.availabilityStatusId
				.name());
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