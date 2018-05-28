package org.apache.ofbiz.product.inventory;

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
public class InventoryItemDetail implements Serializable {

	public static final long serialVersionUID = 7124248107632493568L;
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

	public enum Fields {
		inventoryItemId, inventoryItemDetailSeqId, effectiveDate, quantityOnHandDiff, availableToPromiseDiff, accountingQuantityDiff, unitCost, orderId, orderItemSeqId, shipGroupSeqId, shipmentId, shipmentItemSeqId, returnId, returnItemSeqId, workEffortId, fixedAssetId, maintHistSeqId, itemIssuanceId, receiptId, physicalInventoryId, reasonEnumId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public InventoryItemDetail(GenericValue value) {
		inventoryItemId = (String) value.get(Fields.inventoryItemId.name());
		inventoryItemDetailSeqId = (String) value
				.get(Fields.inventoryItemDetailSeqId.name());
		effectiveDate = (Timestamp) value.get(Fields.effectiveDate.name());
		quantityOnHandDiff = (BigDecimal) value.get(Fields.quantityOnHandDiff
				.name());
		availableToPromiseDiff = (BigDecimal) value
				.get(Fields.availableToPromiseDiff.name());
		accountingQuantityDiff = (BigDecimal) value
				.get(Fields.accountingQuantityDiff.name());
		unitCost = (BigDecimal) value.get(Fields.unitCost.name());
		orderId = (String) value.get(Fields.orderId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		shipGroupSeqId = (String) value.get(Fields.shipGroupSeqId.name());
		shipmentId = (String) value.get(Fields.shipmentId.name());
		shipmentItemSeqId = (String) value.get(Fields.shipmentItemSeqId.name());
		returnId = (String) value.get(Fields.returnId.name());
		returnItemSeqId = (String) value.get(Fields.returnItemSeqId.name());
		workEffortId = (String) value.get(Fields.workEffortId.name());
		fixedAssetId = (String) value.get(Fields.fixedAssetId.name());
		maintHistSeqId = (String) value.get(Fields.maintHistSeqId.name());
		itemIssuanceId = (String) value.get(Fields.itemIssuanceId.name());
		receiptId = (String) value.get(Fields.receiptId.name());
		physicalInventoryId = (String) value.get(Fields.physicalInventoryId
				.name());
		reasonEnumId = (String) value.get(Fields.reasonEnumId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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