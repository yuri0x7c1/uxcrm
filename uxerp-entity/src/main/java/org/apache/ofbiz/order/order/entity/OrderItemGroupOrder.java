package org.apache.ofbiz.order.order.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Item Group Order
 */
public class OrderItemGroupOrder implements Serializable {

	public static final long serialVersionUID = 5114653159023020032L;
	public static final String NAME = "OrderItemGroupOrder";
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
	 * Group Order Id
	 */
	@Getter
	@Setter
	private String groupOrderId;

	public enum Fields {
		orderId, orderItemSeqId, groupOrderId
	}

	public OrderItemGroupOrder(GenericValue value) {
		orderId = (String) value.get(Fields.orderId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		groupOrderId = (String) value.get(Fields.groupOrderId.name());
	}

	public static OrderItemGroupOrder fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderItemGroupOrder(value);
	}

	public static List<OrderItemGroupOrder> fromValues(List<GenericValue> values) {
		List<OrderItemGroupOrder> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderItemGroupOrder(value));
		}
		return entities;
	}
}