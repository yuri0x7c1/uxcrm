package org.apache.ofbiz.marketing.opportunity;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Sales Opportunity Competitor
 */
@FieldNameConstants
public class SalesOpportunityCompetitor implements Serializable {

	public static final long serialVersionUID = 5954643535225248768L;
	public static final String NAME = "SalesOpportunityCompetitor";
	/**
	 * Sales Opportunity Id
	 */
	@Getter
	@Setter
	private String salesOpportunityId;
	/**
	 * Competitor Party Id
	 */
	@Getter
	@Setter
	private String competitorPartyId;
	/**
	 * Position Enum Id
	 */
	@Getter
	@Setter
	private String positionEnumId;
	/**
	 * Strengths
	 */
	@Getter
	@Setter
	private String strengths;
	/**
	 * Weaknesses
	 */
	@Getter
	@Setter
	private String weaknesses;
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

	public SalesOpportunityCompetitor(GenericValue value) {
		salesOpportunityId = (String) value.get(FIELD_SALES_OPPORTUNITY_ID);
		competitorPartyId = (String) value.get(FIELD_COMPETITOR_PARTY_ID);
		positionEnumId = (String) value.get(FIELD_POSITION_ENUM_ID);
		strengths = (String) value.get(FIELD_STRENGTHS);
		weaknesses = (String) value.get(FIELD_WEAKNESSES);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static SalesOpportunityCompetitor fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SalesOpportunityCompetitor(value);
	}

	public static List<SalesOpportunityCompetitor> fromValues(
			List<GenericValue> values) {
		List<SalesOpportunityCompetitor> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SalesOpportunityCompetitor(value));
		}
		return entities;
	}
}