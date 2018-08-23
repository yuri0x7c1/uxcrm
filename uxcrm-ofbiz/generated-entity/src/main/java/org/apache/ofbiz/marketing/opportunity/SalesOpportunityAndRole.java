package org.apache.ofbiz.marketing.opportunity;

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
 * Sales Opportunity And Role
 */
@FieldNameConstants
public class SalesOpportunityAndRole implements Serializable {

	public static final long serialVersionUID = 7999646171893564416L;
	public static final String NAME = "SalesOpportunityAndRole";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * Estimated Probability
	 */
	@Getter
	@Setter
	private BigDecimal estimatedProbability;
	/**
	 * Opportunity Name
	 */
	@Getter
	@Setter
	private String opportunityName;
	/**
	 * Marketing Campaign Id
	 */
	@Getter
	@Setter
	private String marketingCampaignId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Opportunity Stage Id
	 */
	@Getter
	@Setter
	private String opportunityStageId;
	/**
	 * Type Enum Id
	 */
	@Getter
	@Setter
	private String typeEnumId;
	/**
	 * Estimated Close Date
	 */
	@Getter
	@Setter
	private Timestamp estimatedCloseDate;
	/**
	 * Data Source Id
	 */
	@Getter
	@Setter
	private String dataSourceId;
	/**
	 * Currency Uom Id
	 */
	@Getter
	@Setter
	private String currencyUomId;
	/**
	 * Next Step
	 */
	@Getter
	@Setter
	private String nextStep;
	/**
	 * Next Step Date
	 */
	@Getter
	@Setter
	private Timestamp nextStepDate;
	/**
	 * Estimated Amount
	 */
	@Getter
	@Setter
	private BigDecimal estimatedAmount;
	/**
	 * Created By User Login
	 */
	@Getter
	@Setter
	private String createdByUserLogin;
	/**
	 * Sales Opportunity Id
	 */
	@Getter
	@Setter
	private String salesOpportunityId;

	public SalesOpportunityAndRole(GenericValue value) {
		partyId = (String) value.get(FIELD_PARTY_ID);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		estimatedProbability = (BigDecimal) value
				.get(FIELD_ESTIMATED_PROBABILITY);
		opportunityName = (String) value.get(FIELD_OPPORTUNITY_NAME);
		marketingCampaignId = (String) value.get(FIELD_MARKETING_CAMPAIGN_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		opportunityStageId = (String) value.get(FIELD_OPPORTUNITY_STAGE_ID);
		typeEnumId = (String) value.get(FIELD_TYPE_ENUM_ID);
		estimatedCloseDate = (Timestamp) value.get(FIELD_ESTIMATED_CLOSE_DATE);
		dataSourceId = (String) value.get(FIELD_DATA_SOURCE_ID);
		currencyUomId = (String) value.get(FIELD_CURRENCY_UOM_ID);
		nextStep = (String) value.get(FIELD_NEXT_STEP);
		nextStepDate = (Timestamp) value.get(FIELD_NEXT_STEP_DATE);
		estimatedAmount = (BigDecimal) value.get(FIELD_ESTIMATED_AMOUNT);
		createdByUserLogin = (String) value.get(FIELD_CREATED_BY_USER_LOGIN);
		salesOpportunityId = (String) value.get(FIELD_SALES_OPPORTUNITY_ID);
	}

	public static SalesOpportunityAndRole fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SalesOpportunityAndRole(value);
	}

	public static List<SalesOpportunityAndRole> fromValues(
			List<GenericValue> values) {
		List<SalesOpportunityAndRole> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SalesOpportunityAndRole(value));
		}
		return entities;
	}
}