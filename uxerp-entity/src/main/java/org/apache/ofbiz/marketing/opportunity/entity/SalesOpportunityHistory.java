package org.apache.ofbiz.marketing.opportunity.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Sales Opportunity History
 */
public class SalesOpportunityHistory implements Serializable {

	public static final long serialVersionUID = 544288713157493760L;
	public static final String NAME = "SalesOpportunityHistory";
	/**
	 * Sales Opportunity History Id
	 */
	@Getter
	@Setter
	private String salesOpportunityHistoryId;
	/**
	 * Sales Opportunity Id
	 */
	@Getter
	@Setter
	private String salesOpportunityId;
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
	 * Change Note
	 */
	@Getter
	@Setter
	private String changeNote;
	/**
	 * Modified By User Login
	 */
	@Getter
	@Setter
	private String modifiedByUserLogin;
	/**
	 * Modified Timestamp
	 */
	@Getter
	@Setter
	private Timestamp modifiedTimestamp;

	public enum Fields {
		salesOpportunityHistoryId, salesOpportunityId, description, nextStep, estimatedAmount, estimatedProbability, currencyUomId, estimatedCloseDate, opportunityStageId, changeNote, modifiedByUserLogin, modifiedTimestamp
	}

	public SalesOpportunityHistory(GenericValue value) {
		salesOpportunityHistoryId = (String) value
				.get(Fields.salesOpportunityHistoryId.name());
		salesOpportunityId = (String) value.get(Fields.salesOpportunityId
				.name());
		description = (String) value.get(Fields.description.name());
		nextStep = (String) value.get(Fields.nextStep.name());
		estimatedAmount = (BigDecimal) value.get(Fields.estimatedAmount.name());
		estimatedProbability = (BigDecimal) value
				.get(Fields.estimatedProbability.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		estimatedCloseDate = (Timestamp) value.get(Fields.estimatedCloseDate
				.name());
		opportunityStageId = (String) value.get(Fields.opportunityStageId
				.name());
		changeNote = (String) value.get(Fields.changeNote.name());
		modifiedByUserLogin = (String) value.get(Fields.modifiedByUserLogin
				.name());
		modifiedTimestamp = (Timestamp) value.get(Fields.modifiedTimestamp
				.name());
	}

	public static SalesOpportunityHistory fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SalesOpportunityHistory(value);
	}

	public static List<SalesOpportunityHistory> fromValues(
			List<GenericValue> values) {
		List<SalesOpportunityHistory> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SalesOpportunityHistory(value));
		}
		return entities;
	}
}