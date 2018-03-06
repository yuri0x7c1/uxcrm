package org.apache.ofbiz.order.order.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Adjustment Attribute
 */
public class OrderAdjustmentAttribute implements Serializable {

	public static final long serialVersionUID = 262800356988683264L;
	public static final String NAME = "OrderAdjustmentAttribute";
	/**
	 * Order Adjustment Id
	 */
	@Getter
	@Setter
	private String orderAdjustmentId;
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
		orderAdjustmentId, attrName, attrValue, attrDescription
	}

	public OrderAdjustmentAttribute(GenericValue value) {
		orderAdjustmentId = (String) value.get(Fields.orderAdjustmentId.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
		attrDescription = (String) value.get(Fields.attrDescription.name());
	}

	public static OrderAdjustmentAttribute fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderAdjustmentAttribute(value);
	}

	public static List<OrderAdjustmentAttribute> fromValues(
			List<GenericValue> values) {
		List<OrderAdjustmentAttribute> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderAdjustmentAttribute(value));
		}
		return entities;
	}
}