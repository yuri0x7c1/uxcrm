package org.apache.ofbiz.order.order.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Shipment
 */
public class OrderShipment implements Serializable {

	public static final long serialVersionUID = 2829774696892896256L;
	public static final String NAME = "OrderShipment";
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
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;

	public enum Fields {
		orderId, orderItemSeqId, shipGroupSeqId, shipmentId, shipmentItemSeqId, quantity
	}

	public OrderShipment(GenericValue value) {
		orderId = (String) value.get(Fields.orderId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		shipGroupSeqId = (String) value.get(Fields.shipGroupSeqId.name());
		shipmentId = (String) value.get(Fields.shipmentId.name());
		shipmentItemSeqId = (String) value.get(Fields.shipmentItemSeqId.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
	}

	public static OrderShipment fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderShipment(value);
	}

	public static List<OrderShipment> fromValues(List<GenericValue> values) {
		List<OrderShipment> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderShipment(value));
		}
		return entities;
	}
}