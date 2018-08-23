package org.apache.ofbiz.humanres.employment;

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
 * Benefit Type And Party
 */
@FieldNameConstants
public class BenefitTypeAndParty implements Serializable {

	public static final long serialVersionUID = 4270331936212390912L;
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

	public BenefitTypeAndParty(GenericValue value) {
		parentTypeId = (String) value.get(FIELD_PARENT_TYPE_ID);
		employerPaidPercentage = (Double) value
				.get(FIELD_EMPLOYER_PAID_PERCENTAGE);
		hasTable = (String) value.get(FIELD_HAS_TABLE);
		benefitName = (String) value.get(FIELD_BENEFIT_NAME);
		benefitTypeId = (String) value.get(FIELD_BENEFIT_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		roleTypeIdTo = (String) value.get(FIELD_ROLE_TYPE_ID_TO);
		partyIdFrom = (String) value.get(FIELD_PARTY_ID_FROM);
		cost = (BigDecimal) value.get(FIELD_COST);
		actualEmployerPaidPercent = (Double) value
				.get(FIELD_ACTUAL_EMPLOYER_PAID_PERCENT);
		periodTypeId = (String) value.get(FIELD_PERIOD_TYPE_ID);
		roleTypeIdFrom = (String) value.get(FIELD_ROLE_TYPE_ID_FROM);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		availableTime = (Long) value.get(FIELD_AVAILABLE_TIME);
		partyIdTo = (String) value.get(FIELD_PARTY_ID_TO);
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