package org.apache.ofbiz.marketing.opportunity.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Sales Opportunity And Role
 */
public class SalesOpportunityAndRole implements Serializable {

	public static final long serialVersionUID = 6808249913066536960L;
	public static final String NAME = "SalesOpportunityAndRole";
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

	public enum Fields {
		salesOpportunityId, opportunityName, description, nextStep, nextStepDate, estimatedAmount, estimatedProbability, currencyUomId, marketingCampaignId, dataSourceId, estimatedCloseDate, opportunityStageId, typeEnumId, createdByUserLogin, partyId, roleTypeId
	}

	public SalesOpportunityAndRole(GenericValue value) {
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
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
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