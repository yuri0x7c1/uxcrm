package org.apache.ofbiz.order.order;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class OrderHeaderWorkEffort implements Serializable {

	public static final long serialVersionUID = 8714370619836612608L;
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

	public OrderHeaderWorkEffort(GenericValue value) {
		orderId = (String) value.get(FIELD_ORDER_ID);
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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