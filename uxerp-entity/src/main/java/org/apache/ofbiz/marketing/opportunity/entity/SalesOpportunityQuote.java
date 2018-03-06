package org.apache.ofbiz.marketing.opportunity.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Sales Opportunity Quote
 */
public class SalesOpportunityQuote implements Serializable {

	public static final long serialVersionUID = 1016254846477713408L;
	public static final String NAME = "SalesOpportunityQuote";
	/**
	 * Sales Opportunity Id
	 */
	@Getter
	@Setter
	private String salesOpportunityId;
	/**
	 * Quote Id
	 */
	@Getter
	@Setter
	private String quoteId;

	public enum Fields {
		salesOpportunityId, quoteId
	}

	public SalesOpportunityQuote(GenericValue value) {
		salesOpportunityId = (String) value.get(Fields.salesOpportunityId
				.name());
		quoteId = (String) value.get(Fields.quoteId.name());
	}

	public static SalesOpportunityQuote fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SalesOpportunityQuote(value);
	}

	public static List<SalesOpportunityQuote> fromValues(
			List<GenericValue> values) {
		List<SalesOpportunityQuote> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SalesOpportunityQuote(value));
		}
		return entities;
	}
}