package org.apache.ofbiz.marketing.opportunity;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Sales Opportunity
 */
@FieldNameConstants
public class SalesOpportunity implements Serializable {

	public static final long serialVersionUID = 6305470304147401728L;
	public static final String NAME = "SalesOpportunity";
	/**
	 * Sales Opportunity Id
	 */
	@Getter
	@Setter
	private String salesOpportunityId;
	/**
	 * Opportunity Name
	 */
	@Getter
	@Setter
	private String opportunityName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
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
	 * Estimated Probability
	 */
	@Getter
	@Setter
	private BigDecimal estimatedProbability;
	/**
	 * Currency Uom Id
	 */
	@Getter
	@Setter
	private String currencyUomId;
	/**
	 * Marketing Campaign Id
	 */
	@Getter
	@Setter
	private String marketingCampaignId;
	/**
	 * Data Source Id
	 */
	@Getter
	@Setter
	private String dataSourceId;
	/**
	 * Estimated Close Date
	 */
	@Getter
	@Setter
	private Timestamp estimatedCloseDate;
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
	 * Created By User Login
	 */
	@Getter
	@Setter
	private String createdByUserLogin;
	/**
	 * Last Updated Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedStamp;
	/**
	 * Last Updated Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedTxStamp;
	/**
	 * Created Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdStamp;
	/**
	 * Created Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdTxStamp;

	public SalesOpportunity(GenericValue value) {
		salesOpportunityId = (String) value.get(FIELD_SALES_OPPORTUNITY_ID);
		opportunityName = (String) value.get(FIELD_OPPORTUNITY_NAME);
		description = (String) value.get(FIELD_DESCRIPTION);
		nextStep = (String) value.get(FIELD_NEXT_STEP);
		nextStepDate = (Timestamp) value.get(FIELD_NEXT_STEP_DATE);
		estimatedAmount = (BigDecimal) value.get(FIELD_ESTIMATED_AMOUNT);
		estimatedProbability = (BigDecimal) value
				.get(FIELD_ESTIMATED_PROBABILITY);
		currencyUomId = (String) value.get(FIELD_CURRENCY_UOM_ID);
		marketingCampaignId = (String) value.get(FIELD_MARKETING_CAMPAIGN_ID);
		dataSourceId = (String) value.get(FIELD_DATA_SOURCE_ID);
		estimatedCloseDate = (Timestamp) value.get(FIELD_ESTIMATED_CLOSE_DATE);
		opportunityStageId = (String) value.get(FIELD_OPPORTUNITY_STAGE_ID);
		typeEnumId = (String) value.get(FIELD_TYPE_ENUM_ID);
		createdByUserLogin = (String) value.get(FIELD_CREATED_BY_USER_LOGIN);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static SalesOpportunity fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SalesOpportunity(value);
	}

	public static List<SalesOpportunity> fromValues(List<GenericValue> values) {
		List<SalesOpportunity> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SalesOpportunity(value));
		}
		return entities;
	}
}