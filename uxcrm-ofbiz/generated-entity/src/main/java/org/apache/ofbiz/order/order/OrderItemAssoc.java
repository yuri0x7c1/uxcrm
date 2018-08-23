package org.apache.ofbiz.order.order;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Item Assoc
 */
@FieldNameConstants
public class OrderItemAssoc implements Serializable {

	public static final long serialVersionUID = 548707922889745408L;
	public static final String NAME = "OrderItemAssoc";
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
	/**
	 * To Order Id
	 */
	@Getter
	@Setter
	private String toOrderId;
	/**
	 * To Order Item Seq Id
	 */
	@Getter
	@Setter
	private String toOrderItemSeqId;
	/**
	 * To Ship Group Seq Id
	 */
	@Getter
	@Setter
	private String toShipGroupSeqId;
	/**
	 * Order Item Assoc Type Id
	 */
	@Getter
	@Setter
	private String orderItemAssocTypeId;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
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

	public OrderItemAssoc(GenericValue value) {
		orderId = (String) value.get(FIELD_ORDER_ID);
		orderItemSeqId = (String) value.get(FIELD_ORDER_ITEM_SEQ_ID);
		shipGroupSeqId = (String) value.get(FIELD_SHIP_GROUP_SEQ_ID);
		toOrderId = (String) value.get(FIELD_TO_ORDER_ID);
		toOrderItemSeqId = (String) value.get(FIELD_TO_ORDER_ITEM_SEQ_ID);
		toShipGroupSeqId = (String) value.get(FIELD_TO_SHIP_GROUP_SEQ_ID);
		orderItemAssocTypeId = (String) value
				.get(FIELD_ORDER_ITEM_ASSOC_TYPE_ID);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static OrderItemAssoc fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderItemAssoc(value);
	}

	public static List<OrderItemAssoc> fromValues(List<GenericValue> values) {
		List<OrderItemAssoc> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderItemAssoc(value));
		}
		return entities;
	}
}