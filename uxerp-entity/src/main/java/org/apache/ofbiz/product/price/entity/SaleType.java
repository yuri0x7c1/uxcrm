package org.apache.ofbiz.product.price.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Sale Type
 */
public class SaleType implements Serializable {

	public static final long serialVersionUID = 3202985395697796096L;
	public static final String NAME = "SaleType";
	/**
	 * Sale Type Id
	 */
	@Getter
	@Setter
	private String saleTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		saleTypeId, description
	}

	public SaleType(GenericValue value) {
		saleTypeId = (String) value.get(Fields.saleTypeId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static SaleType fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new SaleType(value);
	}

	public static List<SaleType> fromValues(List<GenericValue> values) {
		List<SaleType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SaleType(value));
		}
		return entities;
	}
}