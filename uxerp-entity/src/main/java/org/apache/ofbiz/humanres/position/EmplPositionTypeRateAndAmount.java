package org.apache.ofbiz.humanres.position;

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
public class EmplPositionTypeRateAndAmount implements Serializable {

	public static final long serialVersionUID = 57953345511838720L;
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

	public enum Fields {
		rateAmount, periodTypeId, rateCurrencyUomId, rateAmountFromDate, rateAmountThruDate, fromDate, rateTypeId, emplPositionTypeId, salaryStepSeqId, payGradeId, thruDate
	}

	public EmplPositionTypeRateAndAmount(GenericValue value) {
		rateAmount = (BigDecimal) value.get(Fields.rateAmount.name());
		periodTypeId = (String) value.get(Fields.periodTypeId.name());
		rateCurrencyUomId = (String) value.get(Fields.rateCurrencyUomId.name());
		rateAmountFromDate = (Timestamp) value.get(Fields.rateAmountFromDate
				.name());
		rateAmountThruDate = (Timestamp) value.get(Fields.rateAmountThruDate
				.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		rateTypeId = (String) value.get(Fields.rateTypeId.name());
		emplPositionTypeId = (String) value.get(Fields.emplPositionTypeId
				.name());
		salaryStepSeqId = (String) value.get(Fields.salaryStepSeqId.name());
		payGradeId = (String) value.get(Fields.payGradeId.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
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