package org.apache.ofbiz.accounting.rate.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Rate Amount
 */
public class RateAmount implements Serializable {

	public static final long serialVersionUID = 2951660922610504704L;
	public static final String NAME = "RateAmount";
	/**
	 * Rate Type Id
	 */
	@Getter
	@Setter
	private String rateTypeId;
	/**
	 * Rate Currency Uom Id
	 */
	@Getter
	@Setter
	private String rateCurrencyUomId;
	/**
	 * Period Type Id
	 */
	@Getter
	@Setter
	private String periodTypeId;
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Empl Position Type Id
	 */
	@Getter
	@Setter
	private String emplPositionTypeId;
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

	public enum Fields {
		rateTypeId, rateCurrencyUomId, periodTypeId, workEffortId, partyId, emplPositionTypeId, fromDate, thruDate, rateAmount
	}

	public RateAmount(GenericValue value) {
		rateTypeId = (String) value.get(Fields.rateTypeId.name());
		rateCurrencyUomId = (String) value.get(Fields.rateCurrencyUomId.name());
		periodTypeId = (String) value.get(Fields.periodTypeId.name());
		workEffortId = (String) value.get(Fields.workEffortId.name());
		partyId = (String) value.get(Fields.partyId.name());
		emplPositionTypeId = (String) value.get(Fields.emplPositionTypeId
				.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		rateAmount = (BigDecimal) value.get(Fields.rateAmount.name());
	}

	public static RateAmount fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new RateAmount(value);
	}

	public static List<RateAmount> fromValues(List<GenericValue> values) {
		List<RateAmount> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new RateAmount(value));
		}
		return entities;
	}
}