package org.apache.ofbiz.product.product.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Assoc Type
 */
public class ProductAssocType implements Serializable {

	public static final long serialVersionUID = 7136233026674826240L;
	public static final String NAME = "ProductAssocType";
	/**
	 * Product Assoc Type Id
	 */
	@Getter
	@Setter
	private String productAssocTypeId;
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
		productAssocTypeId, parentTypeId, hasTable, description
	}

	public ProductAssocType(GenericValue value) {
		productAssocTypeId = (String) value.get(Fields.productAssocTypeId
				.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static ProductAssocType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductAssocType(value);
	}

	public static List<ProductAssocType> fromValues(List<GenericValue> values) {
		List<ProductAssocType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductAssocType(value));
		}
		return entities;
	}
}