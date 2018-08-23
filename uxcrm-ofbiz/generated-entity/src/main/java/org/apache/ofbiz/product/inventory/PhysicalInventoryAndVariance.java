package org.apache.ofbiz.product.inventory;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Physical Inventory And Variance
 */
@FieldNameConstants
public class PhysicalInventoryAndVariance implements Serializable {

	public static final long serialVersionUID = 5951245371142221824L;
	public static final String NAME = "PhysicalInventoryAndVariance";
	/**
	 * Physical Inventory Id
	 */
	@Getter
	@Setter
	private String physicalInventoryId;
	/**
	 * Physical Inventory Date
	 */
	@Getter
	@Setter
	private Timestamp physicalInventoryDate;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * General Comments
	 */
	@Getter
	@Setter
	private String generalComments;
	/**
	 * Inventory Item Id
	 */
	@Getter
	@Setter
	private String inventoryItemId;
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

	public PhysicalInventoryAndVariance(GenericValue value) {
		physicalInventoryId = (String) value.get(FIELD_PHYSICAL_INVENTORY_ID);
		physicalInventoryDate = (Timestamp) value
				.get(FIELD_PHYSICAL_INVENTORY_DATE);
		partyId = (String) value.get(FIELD_PARTY_ID);
		generalComments = (String) value.get(FIELD_GENERAL_COMMENTS);
		inventoryItemId = (String) value.get(FIELD_INVENTORY_ITEM_ID);
		varianceReasonId = (String) value.get(FIELD_VARIANCE_REASON_ID);
		availableToPromiseVar = (BigDecimal) value
				.get(FIELD_AVAILABLE_TO_PROMISE_VAR);
		quantityOnHandVar = (BigDecimal) value.get(FIELD_QUANTITY_ON_HAND_VAR);
		comments = (String) value.get(FIELD_COMMENTS);
	}

	public static PhysicalInventoryAndVariance fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PhysicalInventoryAndVariance(value);
	}

	public static List<PhysicalInventoryAndVariance> fromValues(
			List<GenericValue> values) {
		List<PhysicalInventoryAndVariance> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PhysicalInventoryAndVariance(value));
		}
		return entities;
	}
}