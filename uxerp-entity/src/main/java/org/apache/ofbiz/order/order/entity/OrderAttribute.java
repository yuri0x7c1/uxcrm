package org.apache.ofbiz.order.order.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Attribute
 */
public class OrderAttribute implements Serializable {

	public static final long serialVersionUID = 8275327516452775936L;
	public static final String NAME = "OrderAttribute";
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
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
		orderId, attrName, attrValue, attrDescription
	}

	public OrderAttribute(GenericValue value) {
		orderId = (String) value.get(Fields.orderId.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
		attrDescription = (String) value.get(Fields.attrDescription.name());
	}

	public static OrderAttribute fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderAttribute(value);
	}

	public static List<OrderAttribute> fromValues(List<GenericValue> values) {
		List<OrderAttribute> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderAttribute(value));
		}
		return entities;
	}
}