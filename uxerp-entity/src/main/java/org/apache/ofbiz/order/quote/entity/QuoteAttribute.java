package org.apache.ofbiz.order.quote.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Quote Attribute
 */
public class QuoteAttribute implements Serializable {

	public static final long serialVersionUID = 6555453265047712768L;
	public static final String NAME = "QuoteAttribute";
	/**
	 * Quote Id
	 */
	@Getter
	@Setter
	private String quoteId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Attr Value
	 */
	@Getter
	@Setter
	private String attrValue;
	/**
	 * Attr Description
	 */
	@Getter
	@Setter
	private String attrDescription;

	public enum Fields {
		quoteId, attrName, attrValue, attrDescription
	}

	public QuoteAttribute(GenericValue value) {
		quoteId = (String) value.get(Fields.quoteId.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
		attrDescription = (String) value.get(Fields.attrDescription.name());
	}

	public static QuoteAttribute fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new QuoteAttribute(value);
	}

	public static List<QuoteAttribute> fromValues(List<GenericValue> values) {
		List<QuoteAttribute> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new QuoteAttribute(value));
		}
		return entities;
	}
}