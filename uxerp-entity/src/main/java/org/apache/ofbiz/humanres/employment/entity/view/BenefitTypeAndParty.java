package org.apache.ofbiz.humanres.employment.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Benefit Type And Party
 */
public class BenefitTypeAndParty implements Serializable {

	public static final long serialVersionUID = 5808739849084663808L;
	public static final String NAME = "BenefitTypeAndParty";
	/**
	 * Benefit Type Id
	 */
	@Getter
	@Setter
	private String benefitTypeId;
	/**
	 * Benefit Name
	 */
	@Getter
	@Setter
	private String benefitName;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Has Table
	 */
	@Getter
	@Setter
	private String hasTable;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Employer Paid Percentage
	 */
	@Getter
	@Setter
	private Double employerPaidPercentage;
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
		benefitTypeId, benefitName, parentTypeId, hasTable, description, employerPaidPercentage, roleTypeIdFrom, roleTypeIdTo, partyIdFrom, partyIdTo, fromDate, thruDate, periodTypeId, cost, actualEmployerPaidPercent, availableTime
	}

	public BenefitTypeAndParty(GenericValue value) {
		benefitTypeId = (String) value.get(Fields.benefitTypeId.name());
		benefitName = (String) value.get(Fields.benefitName.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
		employerPaidPercentage = (Double) value
				.get(Fields.employerPaidPercentage.name());
		roleTypeIdFrom = (String) value.get(Fields.roleTypeIdFrom.name());
		roleTypeIdTo = (String) value.get(Fields.roleTypeIdTo.name());
		partyIdFrom = (String) value.get(Fields.partyIdFrom.name());
		partyIdTo = (String) value.get(Fields.partyIdTo.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		periodTypeId = (String) value.get(Fields.periodTypeId.name());
		cost = (BigDecimal) value.get(Fields.cost.name());
		actualEmployerPaidPercent = (Double) value
				.get(Fields.actualEmployerPaidPercent.name());
		availableTime = (Long) value.get(Fields.availableTime.name());
	}

	public static BenefitTypeAndParty fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new BenefitTypeAndParty(value);
	}

	public static List<BenefitTypeAndParty> fromValues(List<GenericValue> values) {
		List<BenefitTypeAndParty> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new BenefitTypeAndParty(value));
		}
		return entities;
	}
}