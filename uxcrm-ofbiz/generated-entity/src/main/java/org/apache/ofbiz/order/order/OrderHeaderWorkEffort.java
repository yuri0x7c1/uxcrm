package org.apache.ofbiz.order.order;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Header Work Effort
 */
public class OrderHeaderWorkEffort implements Serializable {

	public static final long serialVersionUID = 4847658204189777920L;
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
	/**
	 * Last Updated Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedStamp;
	/**
	 * Last Updated Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedTxStamp;
	/**
	 * Created Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdStamp;
	/**
	 * Created Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdTxStamp;

	public enum Fields {
		orderId, workEffortId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public OrderHeaderWorkEffort(GenericValue value) {
		orderId = (String) value.get(Fields.orderId.name());
		workEffortId = (String) value.get(Fields.workEffortId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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