package org.apache.ofbiz.product.inventory.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Inventory Item Variance
 */
public class InventoryItemVariance implements Serializable {

	public static final long serialVersionUID = 4035943698461435904L;
	public static final String NAME = "InventoryItemVariance";
	/**
	 * Inventory Item Id
	 */
	@Getter
	@Setter
	private String inventoryItemId;
	/**
	 * Physical Inventory Id
	 */
	@Getter
	@Setter
	private String physicalInventoryId;
	/**
	 * Variance Reason Id
	 */
	@Getter
	@Setter
	private String varianceReasonId;
	/**
	 * Available To Promise Var
	 */
	@Getter
	@Setter
	private BigDecimal availableToPromiseVar;
	/**
	 * Quantity On Hand Var
	 */
	@Getter
	@Setter
	private BigDecimal quantityOnHandVar;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;

	public enum Fields {
		inventoryItemId, physicalInventoryId, varianceReasonId, availableToPromiseVar, quantityOnHandVar, comments
	}

	public InventoryItemVariance(GenericValue value) {
		inventoryItemId = (String) value.get(Fields.inventoryItemId.name());
		physicalInventoryId = (String) value.get(Fields.physicalInventoryId
				.name());
		varianceReasonId = (String) value.get(Fields.varianceReasonId.name());
		availableToPromiseVar = (BigDecimal) value
				.get(Fields.availableToPromiseVar.name());
		quantityOnHandVar = (BigDecimal) value.get(Fields.quantityOnHandVar
				.name());
		comments = (String) value.get(Fields.comments.name());
	}

	public static InventoryItemVariance fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InventoryItemVariance(value);
	}

	public static List<InventoryItemVariance> fromValues(
			List<GenericValue> values) {
		List<InventoryItemVariance> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InventoryItemVariance(value));
		}
		return entities;
	}
}