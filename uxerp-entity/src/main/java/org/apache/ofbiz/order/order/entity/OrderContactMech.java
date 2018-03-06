package org.apache.ofbiz.order.order.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Contact Mech
 */
public class OrderContactMech implements Serializable {

	public static final long serialVersionUID = 8745108121047512064L;
	public static final String NAME = "OrderContactMech";
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Contact Mech Purpose Type Id
	 */
	@Getter
	@Setter
	private String contactMechPurposeTypeId;
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;

	public enum Fields {
		orderId, contactMechPurposeTypeId, contactMechId
	}

	public OrderContactMech(GenericValue value) {
		orderId = (String) value.get(Fields.orderId.name());
		contactMechPurposeTypeId = (String) value
				.get(Fields.contactMechPurposeTypeId.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
	}

	public static OrderContactMech fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderContactMech(value);
	}

	public static List<OrderContactMech> fromValues(List<GenericValue> values) {
		List<OrderContactMech> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderContactMech(value));
		}
		return entities;
	}
}