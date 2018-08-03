package org.apache.ofbiz.order.order;

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
public class OrderItemAndShipGrpInvResAndItemSum implements Serializable {

	public static final long serialVersionUID = 3238670917470396416L;
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

	public enum Fields {
		orderId, orderItemSeqId, productId, inventoryProductId, shipGroupSeqId, quantityOrdered, totQuantityReserved, totQuantityNotAvailable, totQuantityAvailable
	}

	public OrderItemAndShipGrpInvResAndItemSum(GenericValue value) {
		orderId = (String) value.get(Fields.orderId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		productId = (String) value.get(Fields.productId.name());
		inventoryProductId = (String) value.get(Fields.inventoryProductId
				.name());
		shipGroupSeqId = (String) value.get(Fields.shipGroupSeqId.name());
		quantityOrdered = (BigDecimal) value.get(Fields.quantityOrdered.name());
		totQuantityReserved = (BigDecimal) value.get(Fields.totQuantityReserved
				.name());
		totQuantityNotAvailable = (BigDecimal) value
				.get(Fields.totQuantityNotAvailable.name());
		totQuantityAvailable = (BigDecimal) value
				.get(Fields.totQuantityAvailable.name());
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