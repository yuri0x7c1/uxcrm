package org.apache.ofbiz.order.order;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Item And Ship Grp Inv Res And Item Sum
 */
@FieldNameConstants
public class OrderItemAndShipGrpInvResAndItemSum implements Serializable {

	public static final long serialVersionUID = 5902890404993217536L;
	public static final String NAME = "OrderItemAndShipGrpInvResAndItemSum";
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
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Inventory Product Id
	 */
	@Getter
	@Setter
	private String inventoryProductId;
	/**
	 * Ship Group Seq Id
	 */
	@Getter
	@Setter
	private String shipGroupSeqId;
	/**
	 * Quantity Ordered
	 */
	@Getter
	@Setter
	private BigDecimal quantityOrdered;
	/**
	 * Tot Quantity Reserved
	 */
	@Getter
	@Setter
	private BigDecimal totQuantityReserved;
	/**
	 * Tot Quantity Not Available
	 */
	@Getter
	@Setter
	private BigDecimal totQuantityNotAvailable;
	/**
	 * Tot Quantity Available
	 */
	@Getter
	@Setter
	private BigDecimal totQuantityAvailable;

	public OrderItemAndShipGrpInvResAndItemSum(GenericValue value) {
		orderId = (String) value.get(FIELD_ORDER_ID);
		orderItemSeqId = (String) value.get(FIELD_ORDER_ITEM_SEQ_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		inventoryProductId = (String) value.get(FIELD_INVENTORY_PRODUCT_ID);
		shipGroupSeqId = (String) value.get(FIELD_SHIP_GROUP_SEQ_ID);
		quantityOrdered = (BigDecimal) value.get(FIELD_QUANTITY_ORDERED);
		totQuantityReserved = (BigDecimal) value
				.get(FIELD_TOT_QUANTITY_RESERVED);
		totQuantityNotAvailable = (BigDecimal) value
				.get(FIELD_TOT_QUANTITY_NOT_AVAILABLE);
		totQuantityAvailable = (BigDecimal) value
				.get(FIELD_TOT_QUANTITY_AVAILABLE);
	}

	public static OrderItemAndShipGrpInvResAndItemSum fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderItemAndShipGrpInvResAndItemSum(value);
	}

	public static List<OrderItemAndShipGrpInvResAndItemSum> fromValues(
			List<GenericValue> values) {
		List<OrderItemAndShipGrpInvResAndItemSum> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderItemAndShipGrpInvResAndItemSum(value));
		}
		return entities;
	}
}