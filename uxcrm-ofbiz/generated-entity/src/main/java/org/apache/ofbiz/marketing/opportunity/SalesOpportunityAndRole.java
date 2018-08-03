package org.apache.ofbiz.marketing.opportunity;

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
public class SalesOpportunityAndRole implements Serializable {

	public static final long serialVersionUID = 1528161175142931456L;
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

	public enum Fields {
		partyId, roleTypeId, estimatedProbability, opportunityName, marketingCampaignId, description, opportunityStageId, typeEnumId, estimatedCloseDate, dataSourceId, currencyUomId, nextStep, nextStepDate, estimatedAmount, createdByUserLogin, salesOpportunityId
	}

	public SalesOpportunityAndRole(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		estimatedProbability = (BigDecimal) value
				.get(Fields.estimatedProbability.name());
		opportunityName = (String) value.get(Fields.opportunityName.name());
		marketingCampaignId = (String) value.get(Fields.marketingCampaignId
				.name());
		description = (String) value.get(Fields.description.name());
		opportunityStageId = (String) value.get(Fields.opportunityStageId
				.name());
		typeEnumId = (String) value.get(Fields.typeEnumId.name());
		estimatedCloseDate = (Timestamp) value.get(Fields.estimatedCloseDate
				.name());
		dataSourceId = (String) value.get(Fields.dataSourceId.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		nextStep = (String) value.get(Fields.nextStep.name());
		nextStepDate = (Timestamp) value.get(Fields.nextStepDate.name());
		estimatedAmount = (BigDecimal) value.get(Fields.estimatedAmount.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
		salesOpportunityId = (String) value.get(Fields.salesOpportunityId
				.name());
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