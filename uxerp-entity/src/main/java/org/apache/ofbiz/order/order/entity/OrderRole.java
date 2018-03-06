package org.apache.ofbiz.order.order.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Role
 */
public class OrderRole implements Serializable {

	public static final long serialVersionUID = 4362417569115097088L;
	public static final String NAME = "OrderRole";
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
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
		orderId, partyId, roleTypeId
	}

	public OrderRole(GenericValue value) {
		orderId = (String) value.get(Fields.orderId.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
	}

	public static OrderRole fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new OrderRole(value);
	}

	public static List<OrderRole> fromValues(List<GenericValue> values) {
		List<OrderRole> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderRole(value));
		}
		return entities;
	}
}