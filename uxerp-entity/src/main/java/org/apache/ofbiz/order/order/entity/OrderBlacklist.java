package org.apache.ofbiz.order.order.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Blacklist
 */
public class OrderBlacklist implements Serializable {

	public static final long serialVersionUID = 1892855310360860672L;
	public static final String NAME = "OrderBlacklist";
	/**
	 * Blacklist String
	 */
	@Getter
	@Setter
	private String blacklistString;
	/**
	 * Order Blacklist Type Id
	 */
	@Getter
	@Setter
	private String orderBlacklistTypeId;

	public enum Fields {
		blacklistString, orderBlacklistTypeId
	}

	public OrderBlacklist(GenericValue value) {
		blacklistString = (String) value.get(Fields.blacklistString.name());
		orderBlacklistTypeId = (String) value.get(Fields.orderBlacklistTypeId
				.name());
	}

	public static OrderBlacklist fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderBlacklist(value);
	}

	public static List<OrderBlacklist> fromValues(List<GenericValue> values) {
		List<OrderBlacklist> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderBlacklist(value));
		}
		return entities;
	}
}