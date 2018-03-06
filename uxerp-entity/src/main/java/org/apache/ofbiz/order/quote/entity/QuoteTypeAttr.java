package org.apache.ofbiz.order.quote.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Quote Type Attr
 */
public class QuoteTypeAttr implements Serializable {

	public static final long serialVersionUID = 1333618774590366720L;
	public static final String NAME = "QuoteTypeAttr";
	/**
	 * Quote Type Id
	 */
	@Getter
	@Setter
	private String quoteTypeId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		quoteTypeId, attrName, description
	}

	public QuoteTypeAttr(GenericValue value) {
		quoteTypeId = (String) value.get(Fields.quoteTypeId.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
	}

	public static QuoteTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new QuoteTypeAttr(value);
	}

	public static List<QuoteTypeAttr> fromValues(List<GenericValue> values) {
		List<QuoteTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new QuoteTypeAttr(value));
		}
		return entities;
	}
}