package org.apache.ofbiz.product.category.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Category Type
 */
public class ProductCategoryType implements Serializable {

	public static final long serialVersionUID = 7042411564185462784L;
	public static final String NAME = "ProductCategoryType";
	/**
	 * Product Category Type Id
	 */
	@Getter
	@Setter
	private String productCategoryTypeId;
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
		productCategoryTypeId, parentTypeId, hasTable, description
	}

	public ProductCategoryType(GenericValue value) {
		productCategoryTypeId = (String) value.get(Fields.productCategoryTypeId
				.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static ProductCategoryType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductCategoryType(value);
	}

	public static List<ProductCategoryType> fromValues(List<GenericValue> values) {
		List<ProductCategoryType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductCategoryType(value));
		}
		return entities;
	}
}