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
 * Balance Inventory Items View
 */
public class BalanceInventoryItemsView implements Serializable {

	public static final long serialVersionUID = 7368361192122535936L;
	public static final String NAME = "BalanceInventoryItemsView";
	/**
	 * Inventory Item Id
	 */
	@Getter
	@Setter
	private String inventoryItemId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Inventory Item Type Id
	 */
	@Getter
	@Setter
	private String inventoryItemTypeId;
	/**
	 * Available To Promise Total
	 */
	@Getter
	@Setter
	private BigDecimal availableToPromiseTotal;
	/**
	 * Quantity On Hand Total
	 */
	@Getter
	@Setter
	private BigDecimal quantityOnHandTotal;
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Ship Group Seq Id
	 */
	@Getter
	@Setter
	private String shipGroupSeqId;
	/**
	 * Order Item Seq Id
	 */
	@Getter
	@Setter
	private String orderItemSeqId;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
	/**
	 * Quantity Not Available
	 */
	@Getter
	@Setter
	private BigDecimal quantityNotAvailable;
	/**
	 * Reserve Order Enum Id
	 */
	@Getter
	@Setter
	private String reserveOrderEnumId;
	/**
	 * Reserved Datetime
	 */
	@Getter
	@Setter
	private Timestamp reservedDatetime;
	/**
	 * Sequence Id
	 */
	@Getter
	@Setter
	private Long sequenceId;

	public enum Fields {
		inventoryItemId, productId, facilityId, inventoryItemTypeId, availableToPromiseTotal, quantityOnHandTotal, orderId, shipGroupSeqId, orderItemSeqId, quantity, quantityNotAvailable, reserveOrderEnumId, reservedDatetime, sequenceId
	}

	public BalanceInventoryItemsView(GenericValue value) {
		inventoryItemId = (String) value.get(Fields.inventoryItemId.name());
		productId = (String) value.get(Fields.productId.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		inventoryItemTypeId = (String) value.get(Fields.inventoryItemTypeId
				.name());
		availableToPromiseTotal = (BigDecimal) value
				.get(Fields.availableToPromiseTotal.name());
		quantityOnHandTotal = (BigDecimal) value.get(Fields.quantityOnHandTotal
				.name());
		orderId = (String) value.get(Fields.orderId.name());
		shipGroupSeqId = (String) value.get(Fields.shipGroupSeqId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		quantityNotAvailable = (BigDecimal) value
				.get(Fields.quantityNotAvailable.name());
		reserveOrderEnumId = (String) value.get(Fields.reserveOrderEnumId
				.name());
		reservedDatetime = (Timestamp) value
				.get(Fields.reservedDatetime.name());
		sequenceId = (Long) value.get(Fields.sequenceId.name());
	}

	public static BalanceInventoryItemsView fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new BalanceInventoryItemsView(value);
	}

	public static List<BalanceInventoryItemsView> fromValues(
			List<GenericValue> values) {
		List<BalanceInventoryItemsView> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new BalanceInventoryItemsView(value));
		}
		return entities;
	}
}