package org.apache.ofbiz.order.quote.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Quote Type
 */
public class QuoteType implements Serializable {

	public static final long serialVersionUID = 5071107799207215104L;
	public static final String NAME = "QuoteType";
	/**
	 * Quote Type Id
	 */
	@Getter
	@Setter
	private String quoteTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Has Table
	 */
	@Getter
	@Setter
	private String hasTable;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		quoteTypeId, parentTypeId, hasTable, description
	}

	public QuoteType(GenericValue value) {
		quoteTypeId = (String) value.get(Fields.quoteTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static QuoteType fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new QuoteType(value);
	}

	public static List<QuoteType> fromValues(List<GenericValue> values) {
		List<QuoteType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new QuoteType(value));
		}
		return entities;
	}
}