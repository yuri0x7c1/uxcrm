package org.apache.ofbiz.humanres.position.entity.view;

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

	public static final long serialVersionUID = 7925528995690129408L;
	public static final String NAME = "EmplPositionAndFulfillment";
	/**
	 * Empl Position Id
	 */
	@Getter
	@Setter
	private String emplPositionId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Budget Id
	 */
	@Getter
	@Setter
	private String budgetId;
	/**
	 * Budget Item Seq Id
	 */
	@Getter
	@Setter
	private String budgetItemSeqId;
	/**
	 * Empl Position Type Id
	 */
	@Getter
	@Setter
	private String emplPositionTypeId;
	/**
	 * Estimated From Date
	 */
	@Getter
	@Setter
	private Timestamp estimatedFromDate;
	/**
	 * Estimated Thru Date
	 */
	@Getter
	@Setter
	private Timestamp estimatedThruDate;
	/**
	 * Salary Flag
	 */
	@Getter
	@Setter
	private String salaryFlag;
	/**
	 * Exempt Flag
	 */
	@Getter
	@Setter
	private String exemptFlag;
	/**
	 * Fulltime Flag
	 */
	@Getter
	@Setter
	private String fulltimeFlag;
	/**
	 * Temporary Flag
	 */
	@Getter
	@Setter
	private String temporaryFlag;
	/**
	 * Actual From Date
	 */
	@Getter
	@Setter
	private Timestamp actualFromDate;
	/**
	 * Actual Thru Date
	 */
	@Getter
	@Setter
	private Timestamp actualThruDate;
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

	public enum Fields {
		emplPositionId, statusId, partyId, budgetId, budgetItemSeqId, emplPositionTypeId, estimatedFromDate, estimatedThruDate, salaryFlag, exemptFlag, fulltimeFlag, temporaryFlag, actualFromDate, actualThruDate, fromDate, thruDate
	}

	public EmplPositionAndFulfillment(GenericValue value) {
		emplPositionId = (String) value.get(Fields.emplPositionId.name());
		statusId = (String) value.get(Fields.statusId.name());
		partyId = (String) value.get(Fields.partyId.name());
		budgetId = (String) value.get(Fields.budgetId.name());
		budgetItemSeqId = (String) value.get(Fields.budgetItemSeqId.name());
		emplPositionTypeId = (String) value.get(Fields.emplPositionTypeId
				.name());
		estimatedFromDate = (Timestamp) value.get(Fields.estimatedFromDate
				.name());
		estimatedThruDate = (Timestamp) value.get(Fields.estimatedThruDate
				.name());
		salaryFlag = (String) value.get(Fields.salaryFlag.name());
		exemptFlag = (String) value.get(Fields.exemptFlag.name());
		fulltimeFlag = (String) value.get(Fields.fulltimeFlag.name());
		temporaryFlag = (String) value.get(Fields.temporaryFlag.name());
		actualFromDate = (Timestamp) value.get(Fields.actualFromDate.name());
		actualThruDate = (Timestamp) value.get(Fields.actualThruDate.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
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