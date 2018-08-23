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
 * Inventory Item Detail
 */
@FieldNameConstants
public class InventoryItemDetail implements Serializable {

	public static final long serialVersionUID = 6299632879823420416L;
	public static final String NAME = "InventoryItemDetail";
	/**
	 * Inventory Item Id
	 */
	@Getter
	@Setter
	private String inventoryItemId;
	/**
	 * Inventory Item Detail Seq Id
	 */
	@Getter
	@Setter
	private String inventoryItemDetailSeqId;
	/**
	 * Effective Date
	 */
	@Getter
	@Setter
	private Timestamp effectiveDate;
	/**
	 * Quantity On Hand Diff
	 */
	@Getter
	@Setter
	private BigDecimal quantityOnHandDiff;
	/**
	 * Available To Promise Diff
	 */
	@Getter
	@Setter
	private BigDecimal availableToPromiseDiff;
	/**
	 * Accounting Quantity Diff
	 */
	@Getter
	@Setter
	private BigDecimal accountingQuantityDiff;
	/**
	 * Unit Cost
	 */
	@Getter
	@Setter
	private BigDecimal unitCost;
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Order Item Seq Id
	 */
	@Getter
	@Setter
	private String orderItemSeqId;
	/**
	 * Ship Group Seq Id
	 */
	@Getter
	@Setter
	private String shipGroupSeqId;
	/**
	 * Shipment Id
	 */
	@Getter
	@Setter
	private String shipmentId;
	/**
	 * Shipment Item Seq Id
	 */
	@Getter
	@Setter
	private String shipmentItemSeqId;
	/**
	 * Return Id
	 */
	@Getter
	@Setter
	private String returnId;
	/**
	 * Return Item Seq Id
	 */
	@Getter
	@Setter
	private String returnItemSeqId;
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Fixed Asset Id
	 */
	@Getter
	@Setter
	private String fixedAssetId;
	/**
	 * Maint Hist Seq Id
	 */
	@Getter
	@Setter
	private String maintHistSeqId;
	/**
	 * Item Issuance Id
	 */
	@Getter
	@Setter
	private String itemIssuanceId;
	/**
	 * Receipt Id
	 */
	@Getter
	@Setter
	private String receiptId;
	/**
	 * Physical Inventory Id
	 */
	@Getter
	@Setter
	private String physicalInventoryId;
	/**
	 * Reason Enum Id
	 */
	@Getter
	@Setter
	private String reasonEnumId;
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

	public InventoryItemDetail(GenericValue value) {
		inventoryItemId = (String) value.get(FIELD_INVENTORY_ITEM_ID);
		inventoryItemDetailSeqId = (String) value
				.get(FIELD_INVENTORY_ITEM_DETAIL_SEQ_ID);
		effectiveDate = (Timestamp) value.get(FIELD_EFFECTIVE_DATE);
		quantityOnHandDiff = (BigDecimal) value
				.get(FIELD_QUANTITY_ON_HAND_DIFF);
		availableToPromiseDiff = (BigDecimal) value
				.get(FIELD_AVAILABLE_TO_PROMISE_DIFF);
		accountingQuantityDiff = (BigDecimal) value
				.get(FIELD_ACCOUNTING_QUANTITY_DIFF);
		unitCost = (BigDecimal) value.get(FIELD_UNIT_COST);
		orderId = (String) value.get(FIELD_ORDER_ID);
		orderItemSeqId = (String) value.get(FIELD_ORDER_ITEM_SEQ_ID);
		shipGroupSeqId = (String) value.get(FIELD_SHIP_GROUP_SEQ_ID);
		shipmentId = (String) value.get(FIELD_SHIPMENT_ID);
		shipmentItemSeqId = (String) value.get(FIELD_SHIPMENT_ITEM_SEQ_ID);
		returnId = (String) value.get(FIELD_RETURN_ID);
		returnItemSeqId = (String) value.get(FIELD_RETURN_ITEM_SEQ_ID);
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		fixedAssetId = (String) value.get(FIELD_FIXED_ASSET_ID);
		maintHistSeqId = (String) value.get(FIELD_MAINT_HIST_SEQ_ID);
		itemIssuanceId = (String) value.get(FIELD_ITEM_ISSUANCE_ID);
		receiptId = (String) value.get(FIELD_RECEIPT_ID);
		physicalInventoryId = (String) value.get(FIELD_PHYSICAL_INVENTORY_ID);
		reasonEnumId = (String) value.get(FIELD_REASON_ENUM_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static InventoryItemDetail fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InventoryItemDetail(value);
	}

	public static List<InventoryItemDetail> fromValues(List<GenericValue> values) {
		List<InventoryItemDetail> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InventoryItemDetail(value));
		}
		return entities;
	}
}