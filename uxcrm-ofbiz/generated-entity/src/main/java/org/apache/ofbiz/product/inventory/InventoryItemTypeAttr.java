package org.apache.ofbiz.product.inventory;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Inventory Item Type Attr
 */
public class InventoryItemTypeAttr implements Serializable {

	public static final long serialVersionUID = 7150848390245967872L;
	public static final String NAME = "InventoryItemTypeAttr";
	/**
	 * Inventory Item Type Id
	 */
	@Getter
	@Setter
	private String inventoryItemTypeId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
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
		inventoryItemTypeId, attrName, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public InventoryItemTypeAttr(GenericValue value) {
		inventoryItemTypeId = (String) value.get(Fields.inventoryItemTypeId
				.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static InventoryItemTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InventoryItemTypeAttr(value);
	}

	public static List<InventoryItemTypeAttr> fromValues(
			List<GenericValue> values) {
		List<InventoryItemTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InventoryItemTypeAttr(value));
		}
		return entities;
	}
}