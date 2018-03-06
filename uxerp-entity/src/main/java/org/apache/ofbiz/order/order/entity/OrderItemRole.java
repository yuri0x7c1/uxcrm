package org.apache.ofbiz.order.order.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Item Role
 */
public class OrderItemRole implements Serializable {

	public static final long serialVersionUID = 5809848481398469632L;
	public static final String NAME = "OrderItemRole";
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
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;

	public enum Fields {
		orderId, orderItemSeqId, partyId, roleTypeId
	}

	public OrderItemRole(GenericValue value) {
		orderId = (String) value.get(Fields.orderId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
	}

	public static OrderItemRole fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderItemRole(value);
	}

	public static List<OrderItemRole> fromValues(List<GenericValue> values) {
		List<OrderItemRole> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderItemRole(value));
		}
		return entities;
	}
}