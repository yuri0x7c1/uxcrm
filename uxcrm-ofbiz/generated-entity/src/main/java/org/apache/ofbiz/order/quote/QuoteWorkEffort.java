package org.apache.ofbiz.order.quote;

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
public class QuoteWorkEffort implements Serializable {

	public static final long serialVersionUID = 7903268875334742016L;
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

	public enum Fields {
		quoteId, workEffortId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public QuoteWorkEffort(GenericValue value) {
		quoteId = (String) value.get(Fields.quoteId.name());
		workEffortId = (String) value.get(Fields.workEffortId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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