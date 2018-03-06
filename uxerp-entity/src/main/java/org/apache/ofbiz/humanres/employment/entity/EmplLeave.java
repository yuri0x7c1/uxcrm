package org.apache.ofbiz.humanres.employment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Empl Leave
 */
public class EmplLeave implements Serializable {

	public static final long serialVersionUID = 4183748796617940992L;
	public static final String NAME = "EmplLeave";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Leave Type Id
	 */
	@Getter
	@Setter
	private String leaveTypeId;
	/**
	 * Empl Leave Reason Type Id
	 */
	@Getter
	@Setter
	private String emplLeaveReasonTypeId;
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
	 * Approver Party Id
	 */
	@Getter
	@Setter
	private String approverPartyId;
	/**
	 * Leave Status
	 */
	@Getter
	@Setter
	private String leaveStatus;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		partyId, leaveTypeId, emplLeaveReasonTypeId, fromDate, thruDate, approverPartyId, leaveStatus, description
	}

	public EmplLeave(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		leaveTypeId = (String) value.get(Fields.leaveTypeId.name());
		emplLeaveReasonTypeId = (String) value.get(Fields.emplLeaveReasonTypeId
				.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		approverPartyId = (String) value.get(Fields.approverPartyId.name());
		leaveStatus = (String) value.get(Fields.leaveStatus.name());
		description = (String) value.get(Fields.description.name());
	}

	public static EmplLeave fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new EmplLeave(value);
	}

	public static List<EmplLeave> fromValues(List<GenericValue> values) {
		List<EmplLeave> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new EmplLeave(value));
		}
		return entities;
	}
}