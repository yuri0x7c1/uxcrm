package org.apache.ofbiz.marketing.opportunity;

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
public class SalesOpportunity implements Serializable {

	public static final long serialVersionUID = 7543767100688846848L;
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

	public enum Fields {
		salesOpportunityId, opportunityName, description, nextStep, nextStepDate, estimatedAmount, estimatedProbability, currencyUomId, marketingCampaignId, dataSourceId, estimatedCloseDate, opportunityStageId, typeEnumId, createdByUserLogin, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public SalesOpportunity(GenericValue value) {
		salesOpportunityId = (String) value.get(Fields.salesOpportunityId
				.name());
		opportunityName = (String) value.get(Fields.opportunityName.name());
		description = (String) value.get(Fields.description.name());
		nextStep = (String) value.get(Fields.nextStep.name());
		nextStepDate = (Timestamp) value.get(Fields.nextStepDate.name());
		estimatedAmount = (BigDecimal) value.get(Fields.estimatedAmount.name());
		estimatedProbability = (BigDecimal) value
				.get(Fields.estimatedProbability.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		marketingCampaignId = (String) value.get(Fields.marketingCampaignId
				.name());
		dataSourceId = (String) value.get(Fields.dataSourceId.name());
		estimatedCloseDate = (Timestamp) value.get(Fields.estimatedCloseDate
				.name());
		opportunityStageId = (String) value.get(Fields.opportunityStageId
				.name());
		typeEnumId = (String) value.get(Fields.typeEnumId.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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