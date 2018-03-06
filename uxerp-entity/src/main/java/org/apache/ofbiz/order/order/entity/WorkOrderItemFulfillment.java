package org.apache.ofbiz.order.order.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Order Item Fulfillment
 */
public class WorkOrderItemFulfillment implements Serializable {

	public static final long serialVersionUID = 7235161870291092480L;
	public static final String NAME = "WorkOrderItemFulfillment";
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
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
	 * Ship Group Seq Id
	 */
	@Getter
	@Setter
	private String shipGroupSeqId;

	public enum Fields {
		workEffortId, orderId, orderItemSeqId, shipGroupSeqId
	}

	public WorkOrderItemFulfillment(GenericValue value) {
		workEffortId = (String) value.get(Fields.workEffortId.name());
		orderId = (String) value.get(Fields.orderId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		shipGroupSeqId = (String) value.get(Fields.shipGroupSeqId.name());
	}

	public static WorkOrderItemFulfillment fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkOrderItemFulfillment(value);
	}

	public static List<WorkOrderItemFulfillment> fromValues(
			List<GenericValue> values) {
		List<WorkOrderItemFulfillment> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkOrderItemFulfillment(value));
		}
		return entities;
	}
}