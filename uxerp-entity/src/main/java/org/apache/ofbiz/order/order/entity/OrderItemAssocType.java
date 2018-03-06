package org.apache.ofbiz.order.order.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Item Assoc Type
 */
public class OrderItemAssocType implements Serializable {

	public static final long serialVersionUID = 184491815164145664L;
	public static final String NAME = "OrderItemAssocType";
	/**
	 * Order Item Assoc Type Id
	 */
	@Getter
	@Setter
	private String orderItemAssocTypeId;
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
		orderItemAssocTypeId, parentTypeId, hasTable, description
	}

	public OrderItemAssocType(GenericValue value) {
		orderItemAssocTypeId = (String) value.get(Fields.orderItemAssocTypeId
				.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static OrderItemAssocType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderItemAssocType(value);
	}

	public static List<OrderItemAssocType> fromValues(List<GenericValue> values) {
		List<OrderItemAssocType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderItemAssocType(value));
		}
		return entities;
	}
}