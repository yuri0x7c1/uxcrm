package org.apache.ofbiz.order.order.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Item Assoc
 */
public class OrderItemAssoc implements Serializable {

	public static final long serialVersionUID = 876928408608880640L;
	public static final String NAME = "OrderItemAssoc";
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
	 * To Order Id
	 */
	@Getter
	@Setter
	private String toOrderId;
	/**
	 * To Order Item Seq Id
	 */
	@Getter
	@Setter
	private String toOrderItemSeqId;
	/**
	 * To Ship Group Seq Id
	 */
	@Getter
	@Setter
	private String toShipGroupSeqId;
	/**
	 * Order Item Assoc Type Id
	 */
	@Getter
	@Setter
	private String orderItemAssocTypeId;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;

	public enum Fields {
		orderId, orderItemSeqId, shipGroupSeqId, toOrderId, toOrderItemSeqId, toShipGroupSeqId, orderItemAssocTypeId, quantity
	}

	public OrderItemAssoc(GenericValue value) {
		orderId = (String) value.get(Fields.orderId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		shipGroupSeqId = (String) value.get(Fields.shipGroupSeqId.name());
		toOrderId = (String) value.get(Fields.toOrderId.name());
		toOrderItemSeqId = (String) value.get(Fields.toOrderItemSeqId.name());
		toShipGroupSeqId = (String) value.get(Fields.toShipGroupSeqId.name());
		orderItemAssocTypeId = (String) value.get(Fields.orderItemAssocTypeId
				.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
	}

	public static OrderItemAssoc fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderItemAssoc(value);
	}

	public static List<OrderItemAssoc> fromValues(List<GenericValue> values) {
		List<OrderItemAssoc> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderItemAssoc(value));
		}
		return entities;
	}
}