package org.apache.ofbiz.product.inventory;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Inventory Item Variance
 */
@FieldNameConstants
public class InventoryItemVariance implements Serializable {

	public static final long serialVersionUID = 1739632197145795584L;
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
	/**
	 * Last Updated Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedStamp;
	/**
	 * Last Updated Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedTxStamp;
	/**
	 * Created Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdStamp;
	/**
	 * Created Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdTxStamp;

	public InventoryItemVariance(GenericValue value) {
		inventoryItemId = (String) value.get(FIELD_INVENTORY_ITEM_ID);
		physicalInventoryId = (String) value.get(FIELD_PHYSICAL_INVENTORY_ID);
		varianceReasonId = (String) value.get(FIELD_VARIANCE_REASON_ID);
		availableToPromiseVar = (BigDecimal) value
				.get(FIELD_AVAILABLE_TO_PROMISE_VAR);
		quantityOnHandVar = (BigDecimal) value.get(FIELD_QUANTITY_ON_HAND_VAR);
		comments = (String) value.get(FIELD_COMMENTS);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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