package org.apache.ofbiz.order.quote;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Quote Work Effort
 */
@FieldNameConstants
public class QuoteWorkEffort implements Serializable {

	public static final long serialVersionUID = 6174712895765769216L;
	public static final String NAME = "QuoteWorkEffort";
	/**
	 * Quote Id
	 */
	@Getter
	@Setter
	private String quoteId;
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
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

	public QuoteWorkEffort(GenericValue value) {
		quoteId = (String) value.get(FIELD_QUOTE_ID);
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static QuoteWorkEffort fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new QuoteWorkEffort(value);
	}

	public static List<QuoteWorkEffort> fromValues(List<GenericValue> values) {
		List<QuoteWorkEffort> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new QuoteWorkEffort(value));
		}
		return entities;
	}
}