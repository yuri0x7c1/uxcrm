package org.apache.ofbiz.workeffort.workeffort;

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
public class WorkEffortPartyAssignAndRoleType implements Serializable {

	public static final long serialVersionUID = 2395765183396121600L;
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

	public enum Fields {
		workEffortId, roleTypeId, facilityId, comments, mustRsvp, assignedByUserLoginId, delegateReasonEnumId, thruDate, fromDate, statusId, statusDateTime, expectationEnumId, availabilityStatusId, partyId, parentTypeId, hasTable, description
	}

	public WorkEffortPartyAssignAndRoleType(GenericValue value) {
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
		statusId = (String) value.get(Fields.statusId.name());
		statusDateTime = (Timestamp) value.get(Fields.statusDateTime.name());
		expectationEnumId = (String) value.get(Fields.expectationEnumId.name());
		availabilityStatusId = (String) value.get(Fields.availabilityStatusId
				.name());
		partyId = (String) value.get(Fields.partyId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
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