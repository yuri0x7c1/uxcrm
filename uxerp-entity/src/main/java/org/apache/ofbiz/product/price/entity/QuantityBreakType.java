package org.apache.ofbiz.product.price.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Quantity Break Type
 */
public class QuantityBreakType implements Serializable {

	public static final long serialVersionUID = 4991198926598201344L;
	public static final String NAME = "QuantityBreakType";
	/**
	 * Quantity Break Type Id
	 */
	@Getter
	@Setter
	private String quantityBreakTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		quantityBreakTypeId, description
	}

	public QuantityBreakType(GenericValue value) {
		quantityBreakTypeId = (String) value.get(Fields.quantityBreakTypeId
				.name());
		description = (String) value.get(Fields.description.name());
	}

	public static QuantityBreakType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new QuantityBreakType(value);
	}

	public static List<QuantityBreakType> fromValues(List<GenericValue> values) {
		List<QuantityBreakType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new QuantityBreakType(value));
		}
		return entities;
	}
}