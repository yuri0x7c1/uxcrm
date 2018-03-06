package org.apache.ofbiz.order.order.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Type Attr
 */
public class OrderTypeAttr implements Serializable {

	public static final long serialVersionUID = 2490620604770246656L;
	public static final String NAME = "OrderTypeAttr";
	/**
	 * Order Type Id
	 */
	@Getter
	@Setter
	private String orderTypeId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		orderTypeId, attrName, description
	}

	public OrderTypeAttr(GenericValue value) {
		orderTypeId = (String) value.get(Fields.orderTypeId.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
	}

	public static OrderTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderTypeAttr(value);
	}

	public static List<OrderTypeAttr> fromValues(List<GenericValue> values) {
		List<OrderTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderTypeAttr(value));
		}
		return entities;
	}
}