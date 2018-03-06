package org.apache.ofbiz.product.inventory.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Inventory Item Temp Res
 */
public class InventoryItemTempRes implements Serializable {

	public static final long serialVersionUID = 7918745819691153408L;
	public static final String NAME = "InventoryItemTempRes";
	/**
	 * Visit Id
	 */
	@Getter
	@Setter
	private String visitId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
	/**
	 * Reserved Date
	 */
	@Getter
	@Setter
	private Timestamp reservedDate;

	public enum Fields {
		visitId, productId, productStoreId, quantity, reservedDate
	}

	public InventoryItemTempRes(GenericValue value) {
		visitId = (String) value.get(Fields.visitId.name());
		productId = (String) value.get(Fields.productId.name());
		productStoreId = (String) value.get(Fields.productStoreId.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		reservedDate = (Timestamp) value.get(Fields.reservedDate.name());
	}

	public static InventoryItemTempRes fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InventoryItemTempRes(value);
	}

	public static List<InventoryItemTempRes> fromValues(
			List<GenericValue> values) {
		List<InventoryItemTempRes> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InventoryItemTempRes(value));
		}
		return entities;
	}
}