package org.apache.ofbiz.order.order.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Item Ship Group Assoc
 */
public class OrderItemShipGroupAssoc implements Serializable {

	public static final long serialVersionUID = 3872754463969011712L;
	public static final String NAME = "OrderItemShipGroupAssoc";
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
		orderId, orderItemSeqId, shipGroupSeqId, quantity, cancelQuantity
	}

	public OrderItemShipGroupAssoc(GenericValue value) {
		orderId = (String) value.get(Fields.orderId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		shipGroupSeqId = (String) value.get(Fields.shipGroupSeqId.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		cancelQuantity = (BigDecimal) value.get(Fields.cancelQuantity.name());
	}

	public static OrderItemShipGroupAssoc fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderItemShipGroupAssoc(value);
	}

	public static List<OrderItemShipGroupAssoc> fromValues(
			List<GenericValue> values) {
		List<OrderItemShipGroupAssoc> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderItemShipGroupAssoc(value));
		}
		return entities;
	}
}