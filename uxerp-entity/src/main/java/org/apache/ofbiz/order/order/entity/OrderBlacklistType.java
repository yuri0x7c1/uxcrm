package org.apache.ofbiz.order.order.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Blacklist Type
 */
public class OrderBlacklistType implements Serializable {

	public static final long serialVersionUID = 5701233994961556480L;
	public static final String NAME = "OrderBlacklistType";
	/**
	 * Order Blacklist Type Id
	 */
	@Getter
	@Setter
	private String orderBlacklistTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		orderBlacklistTypeId, description
	}

	public OrderBlacklistType(GenericValue value) {
		orderBlacklistTypeId = (String) value.get(Fields.orderBlacklistTypeId
				.name());
		description = (String) value.get(Fields.description.name());
	}

	public static OrderBlacklistType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderBlacklistType(value);
	}

	public static List<OrderBlacklistType> fromValues(List<GenericValue> values) {
		List<OrderBlacklistType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderBlacklistType(value));
		}
		return entities;
	}
}