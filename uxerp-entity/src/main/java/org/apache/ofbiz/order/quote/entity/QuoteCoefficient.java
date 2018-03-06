package org.apache.ofbiz.order.quote.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Quote Coefficient
 */
public class QuoteCoefficient implements Serializable {

	public static final long serialVersionUID = 6520890912302354432L;
	public static final String NAME = "QuoteCoefficient";
	/**
	 * Quote Id
	 */
	@Getter
	@Setter
	private String quoteId;
	/**
	 * Coeff Name
	 */
	@Getter
	@Setter
	private String coeffName;
	/**
	 * Coeff Value
	 */
	@Getter
	@Setter
	private BigDecimal coeffValue;

	public enum Fields {
		quoteId, coeffName, coeffValue
	}

	public QuoteCoefficient(GenericValue value) {
		quoteId = (String) value.get(Fields.quoteId.name());
		coeffName = (String) value.get(Fields.coeffName.name());
		coeffValue = (BigDecimal) value.get(Fields.coeffValue.name());
	}

	public static QuoteCoefficient fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new QuoteCoefficient(value);
	}

	public static List<QuoteCoefficient> fromValues(List<GenericValue> values) {
		List<QuoteCoefficient> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new QuoteCoefficient(value));
		}
		return entities;
	}
}