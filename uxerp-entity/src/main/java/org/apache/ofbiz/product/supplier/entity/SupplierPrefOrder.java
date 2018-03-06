package org.apache.ofbiz.product.supplier.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Supplier Pref Order
 */
public class SupplierPrefOrder implements Serializable {

	public static final long serialVersionUID = 8411602881409572864L;
	public static final String NAME = "SupplierPrefOrder";
	/**
	 * Supplier Pref Order Id
	 */
	@Getter
	@Setter
	private String supplierPrefOrderId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		supplierPrefOrderId, description
	}

	public SupplierPrefOrder(GenericValue value) {
		supplierPrefOrderId = (String) value.get(Fields.supplierPrefOrderId
				.name());
		description = (String) value.get(Fields.description.name());
	}

	public static SupplierPrefOrder fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SupplierPrefOrder(value);
	}

	public static List<SupplierPrefOrder> fromValues(List<GenericValue> values) {
		List<SupplierPrefOrder> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SupplierPrefOrder(value));
		}
		return entities;
	}
}