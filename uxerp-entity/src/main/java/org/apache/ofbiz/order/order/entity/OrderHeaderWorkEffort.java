package org.apache.ofbiz.order.order.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Header Work Effort
 */
public class OrderHeaderWorkEffort implements Serializable {

	public static final long serialVersionUID = 5733782593875555328L;
	public static final String NAME = "OrderHeaderWorkEffort";
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;

	public enum Fields {
		orderId, workEffortId
	}

	public OrderHeaderWorkEffort(GenericValue value) {
		orderId = (String) value.get(Fields.orderId.name());
		workEffortId = (String) value.get(Fields.workEffortId.name());
	}

	public static OrderHeaderWorkEffort fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderHeaderWorkEffort(value);
	}

	public static List<OrderHeaderWorkEffort> fromValues(
			List<GenericValue> values) {
		List<OrderHeaderWorkEffort> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderHeaderWorkEffort(value));
		}
		return entities;
	}
}