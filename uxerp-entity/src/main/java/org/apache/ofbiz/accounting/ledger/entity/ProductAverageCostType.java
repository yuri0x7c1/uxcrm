package org.apache.ofbiz.accounting.ledger.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Average Cost Type
 */
public class ProductAverageCostType implements Serializable {

	public static final long serialVersionUID = 6215791268448727040L;
	public static final String NAME = "ProductAverageCostType";
	/**
	 * Product Average Cost Type Id
	 */
	@Getter
	@Setter
	private String productAverageCostTypeId;
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
		productAverageCostTypeId, parentTypeId, hasTable, description
	}

	public ProductAverageCostType(GenericValue value) {
		productAverageCostTypeId = (String) value
				.get(Fields.productAverageCostTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static ProductAverageCostType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductAverageCostType(value);
	}

	public static List<ProductAverageCostType> fromValues(
			List<GenericValue> values) {
		List<ProductAverageCostType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductAverageCostType(value));
		}
		return entities;
	}
}