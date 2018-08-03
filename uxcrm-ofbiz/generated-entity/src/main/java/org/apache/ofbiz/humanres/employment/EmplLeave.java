package org.apache.ofbiz.humanres.employment;

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

	public static final long serialVersionUID = 2366409506252687360L;
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
		partyId, leaveTypeId, emplLeaveReasonTypeId, fromDate, thruDate, approverPartyId, leaveStatus, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
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
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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