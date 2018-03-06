package org.apache.ofbiz.shipment.issuance.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Item Issuance
 */
public class ItemIssuance implements Serializable {

	public static final long serialVersionUID = 8929390431685103616L;
	public static final String NAME = "ItemIssuance";
	/**
	 * Item Issuance Id
	 */
	@Getter
	@Setter
	private String itemIssuanceId;
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
	 * Inventory Item Id
	 */
	@Getter
	@Setter
	private String inventoryItemId;
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
	 * Issued Date Time
	 */
	@Getter
	@Setter
	private Timestamp issuedDateTime;
	/**
	 * Issued By User Login Id
	 */
	@Getter
	@Setter
	private String issuedByUserLoginId;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
	/**
	 * Cancel Quantity
	 */
	@Getter
	@Setter
	private BigDecimal cancelQuantity;

	public enum Fields {
		itemIssuanceId, orderId, orderItemSeqId, shipGroupSeqId, inventoryItemId, shipmentId, shipmentItemSeqId, fixedAssetId, maintHistSeqId, issuedDateTime, issuedByUserLoginId, quantity, cancelQuantity
	}

	public ItemIssuance(GenericValue value) {
		itemIssuanceId = (String) value.get(Fields.itemIssuanceId.name());
		orderId = (String) value.get(Fields.orderId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		shipGroupSeqId = (String) value.get(Fields.shipGroupSeqId.name());
		inventoryItemId = (String) value.get(Fields.inventoryItemId.name());
		shipmentId = (String) value.get(Fields.shipmentId.name());
		shipmentItemSeqId = (String) value.get(Fields.shipmentItemSeqId.name());
		fixedAssetId = (String) value.get(Fields.fixedAssetId.name());
		maintHistSeqId = (String) value.get(Fields.maintHistSeqId.name());
		issuedDateTime = (Timestamp) value.get(Fields.issuedDateTime.name());
		issuedByUserLoginId = (String) value.get(Fields.issuedByUserLoginId
				.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		cancelQuantity = (BigDecimal) value.get(Fields.cancelQuantity.name());
	}

	public static ItemIssuance fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ItemIssuance(value);
	}

	public static List<ItemIssuance> fromValues(List<GenericValue> values) {
		List<ItemIssuance> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ItemIssuance(value));
		}
		return entities;
	}
}