package org.apache.ofbiz.humanres.employment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Benefit
 */
public class PartyBenefit implements Serializable {

	public static final long serialVersionUID = 1077562448168217600L;
	public static final String NAME = "PartyBenefit";
	/**
	 * Role Type Id From
	 */
	@Getter
	@Setter
	private String roleTypeIdFrom;
	/**
	 * Role Type Id To
	 */
	@Getter
	@Setter
	private String roleTypeIdTo;
	/**
	 * Party Id From
	 */
	@Getter
	@Setter
	private String partyIdFrom;
	/**
	 * Party Id To
	 */
	@Getter
	@Setter
	private String partyIdTo;
	/**
	 * Benefit Type Id
	 */
	@Getter
	@Setter
	private String benefitTypeId;
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
	 * Period Type Id
	 */
	@Getter
	@Setter
	private String periodTypeId;
	/**
	 * Cost
	 */
	@Getter
	@Setter
	private BigDecimal cost;
	/**
	 * Actual Employer Paid Percent
	 */
	@Getter
	@Setter
	private Double actualEmployerPaidPercent;
	/**
	 * Available Time
	 */
	@Getter
	@Setter
	private Long availableTime;

	public enum Fields {
		roleTypeIdFrom, roleTypeIdTo, partyIdFrom, partyIdTo, benefitTypeId, fromDate, thruDate, periodTypeId, cost, actualEmployerPaidPercent, availableTime
	}

	public PartyBenefit(GenericValue value) {
		roleTypeIdFrom = (String) value.get(Fields.roleTypeIdFrom.name());
		roleTypeIdTo = (String) value.get(Fields.roleTypeIdTo.name());
		partyIdFrom = (String) value.get(Fields.partyIdFrom.name());
		partyIdTo = (String) value.get(Fields.partyIdTo.name());
		benefitTypeId = (String) value.get(Fields.benefitTypeId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		periodTypeId = (String) value.get(Fields.periodTypeId.name());
		cost = (BigDecimal) value.get(Fields.cost.name());
		actualEmployerPaidPercent = (Double) value
				.get(Fields.actualEmployerPaidPercent.name());
		availableTime = (Long) value.get(Fields.availableTime.name());
	}

	public static PartyBenefit fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyBenefit(value);
	}

	public static List<PartyBenefit> fromValues(List<GenericValue> values) {
		List<PartyBenefit> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyBenefit(value));
		}
		return entities;
	}
}