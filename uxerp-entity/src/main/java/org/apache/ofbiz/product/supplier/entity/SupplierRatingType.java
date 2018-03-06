package org.apache.ofbiz.product.supplier.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Supplier Rating Type
 */
public class SupplierRatingType implements Serializable {

	public static final long serialVersionUID = 4270957138727307264L;
	public static final String NAME = "SupplierRatingType";
	/**
	 * Supplier Rating Type Id
	 */
	@Getter
	@Setter
	private String supplierRatingTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		supplierRatingTypeId, description
	}

	public SupplierRatingType(GenericValue value) {
		supplierRatingTypeId = (String) value.get(Fields.supplierRatingTypeId
				.name());
		description = (String) value.get(Fields.description.name());
	}

	public static SupplierRatingType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SupplierRatingType(value);
	}

	public static List<SupplierRatingType> fromValues(List<GenericValue> values) {
		List<SupplierRatingType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SupplierRatingType(value));
		}
		return entities;
	}
}