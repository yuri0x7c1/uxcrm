package org.apache.ofbiz.order.order.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Item Type
 */
public class OrderItemType implements Serializable {

	public static final long serialVersionUID = 6506516840123301888L;
	public static final String NAME = "OrderItemType";
	/**
	 * Order Item Type Id
	 */
	@Getter
	@Setter
	private String orderItemTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Has Table
	 */
	@Getter
	@Setter
	private String hasTable;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		orderItemTypeId, parentTypeId, hasTable, description
	}

	public OrderItemType(GenericValue value) {
		orderItemTypeId = (String) value.get(Fields.orderItemTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static OrderItemType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderItemType(value);
	}

	public static List<OrderItemType> fromValues(List<GenericValue> values) {
		List<OrderItemType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderItemType(value));
		}
		return entities;
	}
}