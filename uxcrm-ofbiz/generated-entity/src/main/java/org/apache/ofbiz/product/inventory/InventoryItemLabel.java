package org.apache.ofbiz.product.inventory;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Inventory Item Label
 */
public class InventoryItemLabel implements Serializable {

	public static final long serialVersionUID = 7304181876661777408L;
	public static final String NAME = "InventoryItemLabel";
	/**
	 * Inventory Item Label Id
	 */
	@Getter
	@Setter
	private String inventoryItemLabelId;
	/**
	 * Inventory Item Label Type Id
	 */
	@Getter
	@Setter
	private String inventoryItemLabelTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
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
		inventoryItemLabelId, inventoryItemLabelTypeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public InventoryItemLabel(GenericValue value) {
		inventoryItemLabelId = (String) value.get(Fields.inventoryItemLabelId
				.name());
		inventoryItemLabelTypeId = (String) value
				.get(Fields.inventoryItemLabelTypeId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static InventoryItemLabel fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InventoryItemLabel(value);
	}

	public static List<InventoryItemLabel> fromValues(List<GenericValue> values) {
		List<InventoryItemLabel> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InventoryItemLabel(value));
		}
		return entities;
	}
}