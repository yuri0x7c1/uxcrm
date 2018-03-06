package org.apache.ofbiz.marketing.campaign.entity;

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
public class MarketingCampaign implements Serializable {

	public static final long serialVersionUID = 2221077732712777728L;
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

	public enum Fields {
		marketingCampaignId, parentCampaignId, statusId, campaignName, campaignSummary, budgetedCost, actualCost, estimatedCost, currencyUomId, fromDate, thruDate, isActive, convertedLeads, expectedResponsePercent, expectedRevenue, numSent, startDate, createdByUserLogin, lastModifiedByUserLogin
	}

	public MarketingCampaign(GenericValue value) {
		marketingCampaignId = (String) value.get(Fields.marketingCampaignId
				.name());
		parentCampaignId = (String) value.get(Fields.parentCampaignId.name());
		statusId = (String) value.get(Fields.statusId.name());
		campaignName = (String) value.get(Fields.campaignName.name());
		campaignSummary = (String) value.get(Fields.campaignSummary.name());
		budgetedCost = (BigDecimal) value.get(Fields.budgetedCost.name());
		actualCost = (BigDecimal) value.get(Fields.actualCost.name());
		estimatedCost = (BigDecimal) value.get(Fields.estimatedCost.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		isActive = (String) value.get(Fields.isActive.name());
		convertedLeads = (String) value.get(Fields.convertedLeads.name());
		expectedResponsePercent = (Double) value
				.get(Fields.expectedResponsePercent.name());
		expectedRevenue = (BigDecimal) value.get(Fields.expectedRevenue.name());
		numSent = (Long) value.get(Fields.numSent.name());
		startDate = (Timestamp) value.get(Fields.startDate.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
		lastModifiedByUserLogin = (String) value
				.get(Fields.lastModifiedByUserLogin.name());
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