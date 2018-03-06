package org.apache.ofbiz.order.quote.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Quote Work Effort
 */
public class QuoteWorkEffort implements Serializable {

	public static final long serialVersionUID = 4279557588731641856L;
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

	public enum Fields {
		quoteId, workEffortId
	}

	public QuoteWorkEffort(GenericValue value) {
		quoteId = (String) value.get(Fields.quoteId.name());
		workEffortId = (String) value.get(Fields.workEffortId.name());
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