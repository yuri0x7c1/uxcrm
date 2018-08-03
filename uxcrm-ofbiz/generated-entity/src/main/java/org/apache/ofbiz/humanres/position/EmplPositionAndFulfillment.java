package org.apache.ofbiz.humanres.position;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Empl Position And Fulfillment
 */
public class EmplPositionAndFulfillment implements Serializable {

	public static final long serialVersionUID = 2159202801247083520L;
	public static final String NAME = "EmplPositionAndFulfillment";
	/**
	 * Employee Party Id
	 */
	@Getter
	@Setter
	private String employeePartyId;
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
	 * Estimated Thru Date
	 */
	@Getter
	@Setter
	private Timestamp estimatedThruDate;
	/**
	 * Actual Thru Date
	 */
	@Getter
	@Setter
	private Timestamp actualThruDate;
	/**
	 * Exempt Flag
	 */
	@Getter
	@Setter
	private String exemptFlag;
	/**
	 * Temporary Flag
	 */
	@Getter
	@Setter
	private String temporaryFlag;
	/**
	 * Fulltime Flag
	 */
	@Getter
	@Setter
	private String fulltimeFlag;
	/**
	 * Empl Position Id
	 */
	@Getter
	@Setter
	private String emplPositionId;
	/**
	 * Actual From Date
	 */
	@Getter
	@Setter
	private Timestamp actualFromDate;
	/**
	 * Budget Item Seq Id
	 */
	@Getter
	@Setter
	private String budgetItemSeqId;
	/**
	 * Budget Id
	 */
	@Getter
	@Setter
	private String budgetId;
	/**
	 * Salary Flag
	 */
	@Getter
	@Setter
	private String salaryFlag;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Estimated From Date
	 */
	@Getter
	@Setter
	private Timestamp estimatedFromDate;
	/**
	 * Empl Position Type Id
	 */
	@Getter
	@Setter
	private String emplPositionTypeId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;

	public enum Fields {
		employeePartyId, fromDate, thruDate, estimatedThruDate, actualThruDate, exemptFlag, temporaryFlag, fulltimeFlag, emplPositionId, actualFromDate, budgetItemSeqId, budgetId, salaryFlag, statusId, estimatedFromDate, emplPositionTypeId, partyId
	}

	public EmplPositionAndFulfillment(GenericValue value) {
		employeePartyId = (String) value.get(Fields.employeePartyId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		estimatedThruDate = (Timestamp) value.get(Fields.estimatedThruDate
				.name());
		actualThruDate = (Timestamp) value.get(Fields.actualThruDate.name());
		exemptFlag = (String) value.get(Fields.exemptFlag.name());
		temporaryFlag = (String) value.get(Fields.temporaryFlag.name());
		fulltimeFlag = (String) value.get(Fields.fulltimeFlag.name());
		emplPositionId = (String) value.get(Fields.emplPositionId.name());
		actualFromDate = (Timestamp) value.get(Fields.actualFromDate.name());
		budgetItemSeqId = (String) value.get(Fields.budgetItemSeqId.name());
		budgetId = (String) value.get(Fields.budgetId.name());
		salaryFlag = (String) value.get(Fields.salaryFlag.name());
		statusId = (String) value.get(Fields.statusId.name());
		estimatedFromDate = (Timestamp) value.get(Fields.estimatedFromDate
				.name());
		emplPositionTypeId = (String) value.get(Fields.emplPositionTypeId
				.name());
		partyId = (String) value.get(Fields.partyId.name());
	}

	public static EmplPositionAndFulfillment fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new EmplPositionAndFulfillment(value);
	}

	public static List<EmplPositionAndFulfillment> fromValues(
			List<GenericValue> values) {
		List<EmplPositionAndFulfillment> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new EmplPositionAndFulfillment(value));
		}
		return entities;
	}
}