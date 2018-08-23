package org.apache.ofbiz.humanres.position;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Empl Position Type Rate And Amount
 */
@FieldNameConstants
public class EmplPositionTypeRateAndAmount implements Serializable {

	public static final long serialVersionUID = 4140969082352868352L;
	public static final String NAME = "EmplPositionTypeRateAndAmount";
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
	 * Rate Currency Uom Id
	 */
	@Getter
	@Setter
	private String rateCurrencyUomId;
	/**
	 * Rate Amount From Date
	 */
	@Getter
	@Setter
	private Timestamp rateAmountFromDate;
	/**
	 * Rate Amount Thru Date
	 */
	@Getter
	@Setter
	private Timestamp rateAmountThruDate;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Rate Type Id
	 */
	@Getter
	@Setter
	private String rateTypeId;
	/**
	 * Empl Position Type Id
	 */
	@Getter
	@Setter
	private String emplPositionTypeId;
	/**
	 * Salary Step Seq Id
	 */
	@Getter
	@Setter
	private String salaryStepSeqId;
	/**
	 * Pay Grade Id
	 */
	@Getter
	@Setter
	private String payGradeId;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;

	public EmplPositionTypeRateAndAmount(GenericValue value) {
		rateAmount = (BigDecimal) value.get(FIELD_RATE_AMOUNT);
		periodTypeId = (String) value.get(FIELD_PERIOD_TYPE_ID);
		rateCurrencyUomId = (String) value.get(FIELD_RATE_CURRENCY_UOM_ID);
		rateAmountFromDate = (Timestamp) value.get(FIELD_RATE_AMOUNT_FROM_DATE);
		rateAmountThruDate = (Timestamp) value.get(FIELD_RATE_AMOUNT_THRU_DATE);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		rateTypeId = (String) value.get(FIELD_RATE_TYPE_ID);
		emplPositionTypeId = (String) value.get(FIELD_EMPL_POSITION_TYPE_ID);
		salaryStepSeqId = (String) value.get(FIELD_SALARY_STEP_SEQ_ID);
		payGradeId = (String) value.get(FIELD_PAY_GRADE_ID);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
	}

	public static EmplPositionTypeRateAndAmount fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new EmplPositionTypeRateAndAmount(value);
	}

	public static List<EmplPositionTypeRateAndAmount> fromValues(
			List<GenericValue> values) {
		List<EmplPositionTypeRateAndAmount> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new EmplPositionTypeRateAndAmount(value));
		}
		return entities;
	}
}