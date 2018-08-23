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
 * Order Item Group
 */
@FieldNameConstants
public class OrderItemGroup implements Serializable {

	public static final long serialVersionUID = 2877545023413877760L;
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

	public OrderItemGroup(GenericValue value) {
		orderId = (String) value.get(FIELD_ORDER_ID);
		orderItemGroupSeqId = (String) value.get(FIELD_ORDER_ITEM_GROUP_SEQ_ID);
		parentGroupSeqId = (String) value.get(FIELD_PARENT_GROUP_SEQ_ID);
		groupName = (String) value.get(FIELD_GROUP_NAME);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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