package org.apache.ofbiz.order.order.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Item Contact Mech
 */
public class OrderItemContactMech implements Serializable {

	public static final long serialVersionUID = 2689207105741017088L;
	public static final String NAME = "OrderItemContactMech";
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
		orderId, orderItemSeqId, contactMechPurposeTypeId, contactMechId
	}

	public OrderItemContactMech(GenericValue value) {
		orderId = (String) value.get(Fields.orderId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		contactMechPurposeTypeId = (String) value
				.get(Fields.contactMechPurposeTypeId.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
	}

	public static OrderItemContactMech fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderItemContactMech(value);
	}

	public static List<OrderItemContactMech> fromValues(
			List<GenericValue> values) {
		List<OrderItemContactMech> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderItemContactMech(value));
		}
		return entities;
	}
}