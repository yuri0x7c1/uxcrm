package org.apache.ofbiz.marketing.opportunity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Sales Opportunity Quote
 */
public class SalesOpportunityQuote implements Serializable {

	public static final long serialVersionUID = 812440630322071552L;
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
		salesOpportunityId, quoteId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public SalesOpportunityQuote(GenericValue value) {
		salesOpportunityId = (String) value.get(Fields.salesOpportunityId
				.name());
		quoteId = (String) value.get(Fields.quoteId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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