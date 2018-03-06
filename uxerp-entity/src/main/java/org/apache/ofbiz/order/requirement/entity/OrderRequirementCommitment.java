package org.apache.ofbiz.order.requirement.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Requirement Commitment
 */
public class OrderRequirementCommitment implements Serializable {

	public static final long serialVersionUID = 6471874676310744064L;
	public static final String NAME = "OrderRequirementCommitment";
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
	 * Requirement Id
	 */
	@Getter
	@Setter
	private String requirementId;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;

	public enum Fields {
		orderId, orderItemSeqId, requirementId, quantity
	}

	public OrderRequirementCommitment(GenericValue value) {
		orderId = (String) value.get(Fields.orderId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		requirementId = (String) value.get(Fields.requirementId.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
	}

	public static OrderRequirementCommitment fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderRequirementCommitment(value);
	}

	public static List<OrderRequirementCommitment> fromValues(
			List<GenericValue> values) {
		List<OrderRequirementCommitment> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderRequirementCommitment(value));
		}
		return entities;
	}
}