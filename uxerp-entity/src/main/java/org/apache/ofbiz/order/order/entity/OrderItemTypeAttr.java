package org.apache.ofbiz.order.order.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Item Type Attr
 */
public class OrderItemTypeAttr implements Serializable {

	public static final long serialVersionUID = 4440123363008694272L;
	public static final String NAME = "OrderItemTypeAttr";
	/**
	 * Order Item Type Id
	 */
	@Getter
	@Setter
	private String orderItemTypeId;
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
		orderItemTypeId, attrName, description
	}

	public OrderItemTypeAttr(GenericValue value) {
		orderItemTypeId = (String) value.get(Fields.orderItemTypeId.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
	}

	public static OrderItemTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderItemTypeAttr(value);
	}

	public static List<OrderItemTypeAttr> fromValues(List<GenericValue> values) {
		List<OrderItemTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderItemTypeAttr(value));
		}
		return entities;
	}
}