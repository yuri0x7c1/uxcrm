package org.apache.ofbiz.marketing.opportunity.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Sales Opportunity Competitor
 */
public class SalesOpportunityCompetitor implements Serializable {

	public static final long serialVersionUID = 6917301835895096320L;
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

	public enum Fields {
		salesOpportunityId, competitorPartyId, positionEnumId, strengths, weaknesses
	}

	public SalesOpportunityCompetitor(GenericValue value) {
		salesOpportunityId = (String) value.get(Fields.salesOpportunityId
				.name());
		competitorPartyId = (String) value.get(Fields.competitorPartyId.name());
		positionEnumId = (String) value.get(Fields.positionEnumId.name());
		strengths = (String) value.get(Fields.strengths.name());
		weaknesses = (String) value.get(Fields.weaknesses.name());
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