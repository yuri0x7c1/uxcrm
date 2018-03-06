package org.apache.ofbiz.humanres.ability.entity;

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
public class PersonTraining implements Serializable {

	public static final long serialVersionUID = 8818675087291537408L;
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

	public enum Fields {
		partyId, trainingRequestId, trainingClassTypeId, workEffortId, fromDate, thruDate, approverId, approvalStatus, reason
	}

	public PersonTraining(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		trainingRequestId = (String) value.get(Fields.trainingRequestId.name());
		trainingClassTypeId = (String) value.get(Fields.trainingClassTypeId
				.name());
		workEffortId = (String) value.get(Fields.workEffortId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		approverId = (String) value.get(Fields.approverId.name());
		approvalStatus = (String) value.get(Fields.approvalStatus.name());
		reason = (String) value.get(Fields.reason.name());
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