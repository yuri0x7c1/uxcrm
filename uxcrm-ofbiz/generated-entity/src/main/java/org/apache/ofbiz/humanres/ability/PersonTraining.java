package org.apache.ofbiz.humanres.ability;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Person Training
 */
@FieldNameConstants
public class PersonTraining implements Serializable {

	public static final long serialVersionUID = 1228150026161277952L;
	public static final String NAME = "PersonTraining";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Training Request Id
	 */
	@Getter
	@Setter
	private String trainingRequestId;
	/**
	 * Training Class Type Id
	 */
	@Getter
	@Setter
	private String trainingClassTypeId;
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
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
	 * Approver Id
	 */
	@Getter
	@Setter
	private String approverId;
	/**
	 * Approval Status
	 */
	@Getter
	@Setter
	private String approvalStatus;
	/**
	 * Reason
	 */
	@Getter
	@Setter
	private String reason;
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

	public PersonTraining(GenericValue value) {
		partyId = (String) value.get(FIELD_PARTY_ID);
		trainingRequestId = (String) value.get(FIELD_TRAINING_REQUEST_ID);
		trainingClassTypeId = (String) value.get(FIELD_TRAINING_CLASS_TYPE_ID);
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		approverId = (String) value.get(FIELD_APPROVER_ID);
		approvalStatus = (String) value.get(FIELD_APPROVAL_STATUS);
		reason = (String) value.get(FIELD_REASON);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PersonTraining fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PersonTraining(value);
	}

	public static List<PersonTraining> fromValues(List<GenericValue> values) {
		List<PersonTraining> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PersonTraining(value));
		}
		return entities;
	}
}