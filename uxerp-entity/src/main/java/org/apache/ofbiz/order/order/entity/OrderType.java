package org.apache.ofbiz.order.order.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Type
 */
public class OrderType implements Serializable {

	public static final long serialVersionUID = 8349176971944375296L;
	public static final String NAME = "OrderType";
	/**
	 * Order Type Id
	 */
	@Getter
	@Setter
	private String orderTypeId;
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
		orderTypeId, parentTypeId, hasTable, description
	}

	public OrderType(GenericValue value) {
		orderTypeId = (String) value.get(Fields.orderTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static OrderType fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new OrderType(value);
	}

	public static List<OrderType> fromValues(List<GenericValue> values) {
		List<OrderType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderType(value));
		}
		return entities;
	}
}