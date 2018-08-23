package org.apache.ofbiz.accounting.rate;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Rate Amount And Relations
 */
@FieldNameConstants
public class RateAmountAndRelations implements Serializable {

	public static final long serialVersionUID = 6929211965670432768L;
	public static final String NAME = "RateAmountAndRelations";
	/**
	 * Rate Description
	 */
	@Getter
	@Setter
	private String rateDescription;
	/**
	 * Period Description
	 */
	@Getter
	@Setter
	private String periodDescription;
	/**
	 * First Name
	 */
	@Getter
	@Setter
	private String firstName;
	/**
	 * Middle Name
	 */
	@Getter
	@Setter
	private String middleName;
	/**
	 * Last Name
	 */
	@Getter
	@Setter
	private String lastName;
	/**
	 * Group Name
	 */
	@Getter
	@Setter
	private String groupName;
	/**
	 * Employee Position Description
	 */
	@Getter
	@Setter
	private String employeePositionDescription;
	/**
	 * Work Effort Name
	 */
	@Getter
	@Setter
	private String workEffortName;
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Rate Type Id
	 */
	@Getter
	@Setter
	private String rateTypeId;
	/**
	 * Rate Amount
	 */
	@Getter
	@Setter
	private BigDecimal rateAmount;
	/**
	 * Period Type Id
	 */
	@Getter
	@Setter
	private String periodTypeId;
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
	 * Empl Position Type Id
	 */
	@Getter
	@Setter
	private String emplPositionTypeId;
	/**
	 * Rate Currency Uom Id
	 */
	@Getter
	@Setter
	private String rateCurrencyUomId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;

	public RateAmountAndRelations(GenericValue value) {
		rateDescription = (String) value.get(FIELD_RATE_DESCRIPTION);
		periodDescription = (String) value.get(FIELD_PERIOD_DESCRIPTION);
		firstName = (String) value.get(FIELD_FIRST_NAME);
		middleName = (String) value.get(FIELD_MIDDLE_NAME);
		lastName = (String) value.get(FIELD_LAST_NAME);
		groupName = (String) value.get(FIELD_GROUP_NAME);
		employeePositionDescription = (String) value
				.get(FIELD_EMPLOYEE_POSITION_DESCRIPTION);
		workEffortName = (String) value.get(FIELD_WORK_EFFORT_NAME);
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		rateTypeId = (String) value.get(FIELD_RATE_TYPE_ID);
		rateAmount = (BigDecimal) value.get(FIELD_RATE_AMOUNT);
		periodTypeId = (String) value.get(FIELD_PERIOD_TYPE_ID);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		emplPositionTypeId = (String) value.get(FIELD_EMPL_POSITION_TYPE_ID);
		rateCurrencyUomId = (String) value.get(FIELD_RATE_CURRENCY_UOM_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
	}

	public static RateAmountAndRelations fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new RateAmountAndRelations(value);
	}

	public static List<RateAmountAndRelations> fromValues(
			List<GenericValue> values) {
		List<RateAmountAndRelations> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new RateAmountAndRelations(value));
		}
		return entities;
	}
}