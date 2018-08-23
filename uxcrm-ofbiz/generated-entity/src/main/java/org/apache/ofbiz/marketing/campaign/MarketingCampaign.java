package org.apache.ofbiz.marketing.campaign;

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
 * Marketing Campaign
 */
@FieldNameConstants
public class MarketingCampaign implements Serializable {

	public static final long serialVersionUID = 4609745033812048896L;
	public static final String NAME = "MarketingCampaign";
	/**
	 * Marketing Campaign Id
	 */
	@Getter
	@Setter
	private String marketingCampaignId;
	/**
	 * Parent Campaign Id
	 */
	@Getter
	@Setter
	private String parentCampaignId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Campaign Name
	 */
	@Getter
	@Setter
	private String campaignName;
	/**
	 * Campaign Summary
	 */
	@Getter
	@Setter
	private String campaignSummary;
	/**
	 * Budgeted Cost
	 */
	@Getter
	@Setter
	private BigDecimal budgetedCost;
	/**
	 * Actual Cost
	 */
	@Getter
	@Setter
	private BigDecimal actualCost;
	/**
	 * Estimated Cost
	 */
	@Getter
	@Setter
	private BigDecimal estimatedCost;
	/**
	 * Currency Uom Id
	 */
	@Getter
	@Setter
	private String currencyUomId;
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
	 * Is Active
	 */
	@Getter
	@Setter
	private String isActive;
	/**
	 * Converted Leads
	 */
	@Getter
	@Setter
	private String convertedLeads;
	/**
	 * Expected Response Percent
	 */
	@Getter
	@Setter
	private Double expectedResponsePercent;
	/**
	 * Expected Revenue
	 */
	@Getter
	@Setter
	private BigDecimal expectedRevenue;
	/**
	 * Num Sent
	 */
	@Getter
	@Setter
	private Long numSent;
	/**
	 * Start Date
	 */
	@Getter
	@Setter
	private Timestamp startDate;
	/**
	 * Created By User Login
	 */
	@Getter
	@Setter
	private String createdByUserLogin;
	/**
	 * Last Modified By User Login
	 */
	@Getter
	@Setter
	private String lastModifiedByUserLogin;
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

	public MarketingCampaign(GenericValue value) {
		marketingCampaignId = (String) value.get(FIELD_MARKETING_CAMPAIGN_ID);
		parentCampaignId = (String) value.get(FIELD_PARENT_CAMPAIGN_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		campaignName = (String) value.get(FIELD_CAMPAIGN_NAME);
		campaignSummary = (String) value.get(FIELD_CAMPAIGN_SUMMARY);
		budgetedCost = (BigDecimal) value.get(FIELD_BUDGETED_COST);
		actualCost = (BigDecimal) value.get(FIELD_ACTUAL_COST);
		estimatedCost = (BigDecimal) value.get(FIELD_ESTIMATED_COST);
		currencyUomId = (String) value.get(FIELD_CURRENCY_UOM_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		isActive = (String) value.get(FIELD_IS_ACTIVE);
		convertedLeads = (String) value.get(FIELD_CONVERTED_LEADS);
		expectedResponsePercent = (Double) value
				.get(FIELD_EXPECTED_RESPONSE_PERCENT);
		expectedRevenue = (BigDecimal) value.get(FIELD_EXPECTED_REVENUE);
		numSent = (Long) value.get(FIELD_NUM_SENT);
		startDate = (Timestamp) value.get(FIELD_START_DATE);
		createdByUserLogin = (String) value.get(FIELD_CREATED_BY_USER_LOGIN);
		lastModifiedByUserLogin = (String) value
				.get(FIELD_LAST_MODIFIED_BY_USER_LOGIN);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static MarketingCampaign fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new MarketingCampaign(value);
	}

	public static List<MarketingCampaign> fromValues(List<GenericValue> values) {
		List<MarketingCampaign> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new MarketingCampaign(value));
		}
		return entities;
	}
}