package org.apache.ofbiz.humanres.position;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class EmplPositionAndFulfillment implements Serializable {

	public static final long serialVersionUID = 8157264666910282752L;
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

	public EmplPositionAndFulfillment(GenericValue value) {
		employeePartyId = (String) value.get(FIELD_EMPLOYEE_PARTY_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		estimatedThruDate = (Timestamp) value.get(FIELD_ESTIMATED_THRU_DATE);
		actualThruDate = (Timestamp) value.get(FIELD_ACTUAL_THRU_DATE);
		exemptFlag = (String) value.get(FIELD_EXEMPT_FLAG);
		temporaryFlag = (String) value.get(FIELD_TEMPORARY_FLAG);
		fulltimeFlag = (String) value.get(FIELD_FULLTIME_FLAG);
		emplPositionId = (String) value.get(FIELD_EMPL_POSITION_ID);
		actualFromDate = (Timestamp) value.get(FIELD_ACTUAL_FROM_DATE);
		budgetItemSeqId = (String) value.get(FIELD_BUDGET_ITEM_SEQ_ID);
		budgetId = (String) value.get(FIELD_BUDGET_ID);
		salaryFlag = (String) value.get(FIELD_SALARY_FLAG);
		statusId = (String) value.get(FIELD_STATUS_ID);
		estimatedFromDate = (Timestamp) value.get(FIELD_ESTIMATED_FROM_DATE);
		emplPositionTypeId = (String) value.get(FIELD_EMPL_POSITION_TYPE_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
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