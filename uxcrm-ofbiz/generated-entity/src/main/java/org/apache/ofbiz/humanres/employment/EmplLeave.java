package org.apache.ofbiz.humanres.employment;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class EmplLeave implements Serializable {

	public static final long serialVersionUID = 5505837056318340096L;
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

	public EmplLeave(GenericValue value) {
		partyId = (String) value.get(FIELD_PARTY_ID);
		leaveTypeId = (String) value.get(FIELD_LEAVE_TYPE_ID);
		emplLeaveReasonTypeId = (String) value
				.get(FIELD_EMPL_LEAVE_REASON_TYPE_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		approverPartyId = (String) value.get(FIELD_APPROVER_PARTY_ID);
		leaveStatus = (String) value.get(FIELD_LEAVE_STATUS);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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