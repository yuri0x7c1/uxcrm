package org.apache.ofbiz.product.inventory;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Inventory Item Label Appl
 */
@FieldNameConstants
public class InventoryItemLabelAppl implements Serializable {

	public static final long serialVersionUID = 7209176812432240640L;
	public static final String NAME = "InventoryItemLabelAppl";
	/**
	 * Inventory Item Id
	 */
	@Getter
	@Setter
	private String inventoryItemId;
	/**
	 * Inventory Item Label Type Id
	 */
	@Getter
	@Setter
	private String inventoryItemLabelTypeId;
	/**
	 * Inventory Item Label Id
	 */
	@Getter
	@Setter
	private String inventoryItemLabelId;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
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

	public InventoryItemLabelAppl(GenericValue value) {
		inventoryItemId = (String) value.get(FIELD_INVENTORY_ITEM_ID);
		inventoryItemLabelTypeId = (String) value
				.get(FIELD_INVENTORY_ITEM_LABEL_TYPE_ID);
		inventoryItemLabelId = (String) value
				.get(FIELD_INVENTORY_ITEM_LABEL_ID);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static InventoryItemLabelAppl fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InventoryItemLabelAppl(value);
	}

	public static List<InventoryItemLabelAppl> fromValues(
			List<GenericValue> values) {
		List<InventoryItemLabelAppl> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InventoryItemLabelAppl(value));
		}
		return entities;
	}
}