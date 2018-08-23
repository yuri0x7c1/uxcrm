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
 * Sales Opportunity History
 */
@FieldNameConstants
public class SalesOpportunityHistory implements Serializable {

	public static final long serialVersionUID = 2170346556350503936L;
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

	public SalesOpportunityHistory(GenericValue value) {
		salesOpportunityHistoryId = (String) value
				.get(FIELD_SALES_OPPORTUNITY_HISTORY_ID);
		salesOpportunityId = (String) value.get(FIELD_SALES_OPPORTUNITY_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		nextStep = (String) value.get(FIELD_NEXT_STEP);
		estimatedAmount = (BigDecimal) value.get(FIELD_ESTIMATED_AMOUNT);
		estimatedProbability = (BigDecimal) value
				.get(FIELD_ESTIMATED_PROBABILITY);
		currencyUomId = (String) value.get(FIELD_CURRENCY_UOM_ID);
		estimatedCloseDate = (Timestamp) value.get(FIELD_ESTIMATED_CLOSE_DATE);
		opportunityStageId = (String) value.get(FIELD_OPPORTUNITY_STAGE_ID);
		changeNote = (String) value.get(FIELD_CHANGE_NOTE);
		modifiedByUserLogin = (String) value.get(FIELD_MODIFIED_BY_USER_LOGIN);
		modifiedTimestamp = (Timestamp) value.get(FIELD_MODIFIED_TIMESTAMP);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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