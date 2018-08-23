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
 * Sales Opportunity Stage
 */
@FieldNameConstants
public class SalesOpportunityStage implements Serializable {

	public static final long serialVersionUID = 2889243802028783616L;
	public static final String NAME = "SalesOpportunityStage";
	/**
	 * Opportunity Stage Id
	 */
	@Getter
	@Setter
	private String opportunityStageId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Default Probability
	 */
	@Getter
	@Setter
	private BigDecimal defaultProbability;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
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

	public SalesOpportunityStage(GenericValue value) {
		opportunityStageId = (String) value.get(FIELD_OPPORTUNITY_STAGE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		defaultProbability = (BigDecimal) value.get(FIELD_DEFAULT_PROBABILITY);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static SalesOpportunityStage fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SalesOpportunityStage(value);
	}

	public static List<SalesOpportunityStage> fromValues(
			List<GenericValue> values) {
		List<SalesOpportunityStage> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SalesOpportunityStage(value));
		}
		return entities;
	}
}