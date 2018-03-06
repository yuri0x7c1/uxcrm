package org.apache.ofbiz.order.order.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Item Attribute
 */
public class OrderItemAttribute implements Serializable {

	public static final long serialVersionUID = 3929337173974463488L;
	public static final String NAME = "OrderItemAttribute";
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
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Attr Value
	 */
	@Getter
	@Setter
	private String attrValue;
	/**
	 * Attr Description
	 */
	@Getter
	@Setter
	private String attrDescription;

	public enum Fields {
		orderId, orderItemSeqId, attrName, attrValue, attrDescription
	}

	public OrderItemAttribute(GenericValue value) {
		orderId = (String) value.get(Fields.orderId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
		attrDescription = (String) value.get(Fields.attrDescription.name());
	}

	public static OrderItemAttribute fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderItemAttribute(value);
	}

	public static List<OrderItemAttribute> fromValues(List<GenericValue> values) {
		List<OrderItemAttribute> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderItemAttribute(value));
		}
		return entities;
	}
}