package org.apache.ofbiz.marketing.opportunity;

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
public class SalesOpportunityCompetitor implements Serializable {

	public static final long serialVersionUID = 720148605580644352L;
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

	public enum Fields {
		salesOpportunityId, competitorPartyId, positionEnumId, strengths, weaknesses, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public SalesOpportunityCompetitor(GenericValue value) {
		salesOpportunityId = (String) value.get(Fields.salesOpportunityId
				.name());
		competitorPartyId = (String) value.get(Fields.competitorPartyId.name());
		positionEnumId = (String) value.get(Fields.positionEnumId.name());
		strengths = (String) value.get(Fields.strengths.name());
		weaknesses = (String) value.get(Fields.weaknesses.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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