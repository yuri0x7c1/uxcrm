package org.apache.ofbiz.product.inventory;

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
public class InventoryItemVariance implements Serializable {

	public static final long serialVersionUID = 5924504893181817856L;
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

	public enum Fields {
		inventoryItemId, physicalInventoryId, varianceReasonId, availableToPromiseVar, quantityOnHandVar, comments, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
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
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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