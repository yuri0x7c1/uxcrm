package org.apache.ofbiz.humanres.employment;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Benefit Type And Party
 */
public class BenefitTypeAndParty implements Serializable {

	public static final long serialVersionUID = 639852821989603328L;
	public static final String NAME = "BenefitTypeAndParty";
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Employer Paid Percentage
	 */
	@Getter
	@Setter
	private Double employerPaidPercentage;
	/**
	 * Has Table
	 */
	@Getter
	@Setter
	private String hasTable;
	/**
	 * Benefit Name
	 */
	@Getter
	@Setter
	private String benefitName;
	/**
	 * Benefit Type Id
	 */
	@Getter
	@Setter
	private String benefitTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
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
	 * Period Type Id
	 */
	@Getter
	@Setter
	private String periodTypeId;
	/**
	 * Role Type Id From
	 */
	@Getter
	@Setter
	private String roleTypeIdFrom;
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
	 * Available Time
	 */
	@Getter
	@Setter
	private Long availableTime;
	/**
	 * Party Id To
	 */
	@Getter
	@Setter
	private String partyIdTo;

	public enum Fields {
		parentTypeId, employerPaidPercentage, hasTable, benefitName, benefitTypeId, description, roleTypeIdTo, partyIdFrom, cost, actualEmployerPaidPercent, periodTypeId, roleTypeIdFrom, thruDate, fromDate, availableTime, partyIdTo
	}

	public BenefitTypeAndParty(GenericValue value) {
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		employerPaidPercentage = (Double) value
				.get(Fields.employerPaidPercentage.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		benefitName = (String) value.get(Fields.benefitName.name());
		benefitTypeId = (String) value.get(Fields.benefitTypeId.name());
		description = (String) value.get(Fields.description.name());
		roleTypeIdTo = (String) value.get(Fields.roleTypeIdTo.name());
		partyIdFrom = (String) value.get(Fields.partyIdFrom.name());
		cost = (BigDecimal) value.get(Fields.cost.name());
		actualEmployerPaidPercent = (Double) value
				.get(Fields.actualEmployerPaidPercent.name());
		periodTypeId = (String) value.get(Fields.periodTypeId.name());
		roleTypeIdFrom = (String) value.get(Fields.roleTypeIdFrom.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		availableTime = (Long) value.get(Fields.availableTime.name());
		partyIdTo = (String) value.get(Fields.partyIdTo.name());
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