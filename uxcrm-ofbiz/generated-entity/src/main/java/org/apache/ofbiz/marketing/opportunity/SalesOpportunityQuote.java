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
 * Sales Opportunity Quote
 */
@FieldNameConstants
public class SalesOpportunityQuote implements Serializable {

	public static final long serialVersionUID = 1339128170233095168L;
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

	public SalesOpportunityQuote(GenericValue value) {
		salesOpportunityId = (String) value.get(FIELD_SALES_OPPORTUNITY_ID);
		quoteId = (String) value.get(FIELD_QUOTE_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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