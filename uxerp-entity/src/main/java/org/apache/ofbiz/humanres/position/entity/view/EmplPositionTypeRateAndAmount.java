package org.apache.ofbiz.humanres.position.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Empl Position Type Rate And Amount
 */
public class EmplPositionTypeRateAndAmount implements Serializable {

	public static final long serialVersionUID = 2241890721307676672L;
	public static final String NAME = "EmplPositionTypeRateAndAmount";
	/**
	 * Empl Position Type Id
	 */
	@Getter
	@Setter
	private String emplPositionTypeId;
	/**
	 * Rate Type Id
	 */
	@Getter
	@Setter
	private String rateTypeId;
	/**
	 * Pay Grade Id
	 */
	@Getter
	@Setter
	private String payGradeId;
	/**
	 * Salary Step Seq Id
	 */
	@Getter
	@Setter
	private String salaryStepSeqId;
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

	public enum Fields {
		emplPositionTypeId, rateTypeId, payGradeId, salaryStepSeqId, fromDate, thruDate, rateAmount, periodTypeId, rateCurrencyUomId
	}

	public EmplPositionTypeRateAndAmount(GenericValue value) {
		emplPositionTypeId = (String) value.get(Fields.emplPositionTypeId
				.name());
		rateTypeId = (String) value.get(Fields.rateTypeId.name());
		payGradeId = (String) value.get(Fields.payGradeId.name());
		salaryStepSeqId = (String) value.get(Fields.salaryStepSeqId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		rateAmount = (BigDecimal) value.get(Fields.rateAmount.name());
		periodTypeId = (String) value.get(Fields.periodTypeId.name());
		rateCurrencyUomId = (String) value.get(Fields.rateCurrencyUomId.name());
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