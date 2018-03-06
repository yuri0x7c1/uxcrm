package org.apache.ofbiz.specialpurpose.project.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Project Party And Phase
 */
public class ProjectPartyAndPhase implements Serializable {

	public static final long serialVersionUID = 4549976211891239936L;
	public static final String NAME = "ProjectPartyAndPhase";
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
	 * Work Effort Name
	 */
	@Getter
	@Setter
	private String workEffortName;

	public enum Fields {
		workEffortId, partyId, roleTypeId, fromDate, thruDate, assignedByUserLoginId, statusId, statusDateTime, expectationEnumId, delegateReasonEnumId, facilityId, comments, mustRsvp, availabilityStatusId, workEffortName
	}

	public ProjectPartyAndPhase(GenericValue value) {
		workEffortId = (String) value.get(Fields.workEffortId.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		assignedByUserLoginId = (String) value.get(Fields.assignedByUserLoginId
				.name());
		statusId = (String) value.get(Fields.statusId.name());
		statusDateTime = (Timestamp) value.get(Fields.statusDateTime.name());
		expectationEnumId = (String) value.get(Fields.expectationEnumId.name());
		delegateReasonEnumId = (String) value.get(Fields.delegateReasonEnumId
				.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		comments = (String) value.get(Fields.comments.name());
		mustRsvp = (String) value.get(Fields.mustRsvp.name());
		availabilityStatusId = (String) value.get(Fields.availabilityStatusId
				.name());
		workEffortName = (String) value.get(Fields.workEffortName.name());
	}

	public static ProjectPartyAndPhase fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProjectPartyAndPhase(value);
	}

	public static List<ProjectPartyAndPhase> fromValues(
			List<GenericValue> values) {
		List<ProjectPartyAndPhase> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProjectPartyAndPhase(value));
		}
		return entities;
	}
}