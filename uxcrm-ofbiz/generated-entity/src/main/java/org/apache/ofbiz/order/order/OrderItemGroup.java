package org.apache.ofbiz.order.order;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Item Group
 */
public class OrderItemGroup implements Serializable {

	public static final long serialVersionUID = 1393515444303501312L;
	public static final String NAME = "OrderItemGroup";
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Order Item Group Seq Id
	 */
	@Getter
	@Setter
	private String orderItemGroupSeqId;
	/**
	 * Parent Group Seq Id
	 */
	@Getter
	@Setter
	private String parentGroupSeqId;
	/**
	 * Group Name
	 */
	@Getter
	@Setter
	private String groupName;
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
		orderId, orderItemGroupSeqId, parentGroupSeqId, groupName, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public OrderItemGroup(GenericValue value) {
		orderId = (String) value.get(Fields.orderId.name());
		orderItemGroupSeqId = (String) value.get(Fields.orderItemGroupSeqId
				.name());
		parentGroupSeqId = (String) value.get(Fields.parentGroupSeqId.name());
		groupName = (String) value.get(Fields.groupName.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static OrderItemGroup fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderItemGroup(value);
	}

	public static List<OrderItemGroup> fromValues(List<GenericValue> values) {
		List<OrderItemGroup> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderItemGroup(value));
		}
		return entities;
	}
}