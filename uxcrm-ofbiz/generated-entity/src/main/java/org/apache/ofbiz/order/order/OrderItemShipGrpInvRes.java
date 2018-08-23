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
 * Order Item Ship Grp Inv Res
 */
@FieldNameConstants
public class OrderItemShipGrpInvRes implements Serializable {

	public static final long serialVersionUID = 7212661382097205248L;
	public static final String NAME = "OrderItemShipGrpInvRes";
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Ship Group Seq Id
	 */
	@Getter
	@Setter
	private String shipGroupSeqId;
	/**
	 * Order Item Seq Id
	 */
	@Getter
	@Setter
	private String orderItemSeqId;
	/**
	 * Inventory Item Id
	 */
	@Getter
	@Setter
	private String inventoryItemId;
	/**
	 * Reserve Order Enum Id
	 */
	@Getter
	@Setter
	private String reserveOrderEnumId;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
	/**
	 * Quantity Not Available
	 */
	@Getter
	@Setter
	private BigDecimal quantityNotAvailable;
	/**
	 * Reserved Datetime
	 */
	@Getter
	@Setter
	private Timestamp reservedDatetime;
	/**
	 * Created Datetime
	 */
	@Getter
	@Setter
	private Timestamp createdDatetime;
	/**
	 * Promised Datetime
	 */
	@Getter
	@Setter
	private Timestamp promisedDatetime;
	/**
	 * Current Promised Date
	 */
	@Getter
	@Setter
	private Timestamp currentPromisedDate;
	/**
	 * Priority
	 */
	@Getter
	@Setter
	private String priority;
	/**
	 * Sequence Id
	 */
	@Getter
	@Setter
	private Long sequenceId;
	/**
	 * Old Pick Start Date
	 */
	@Getter
	@Setter
	private Timestamp oldPickStartDate;
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

	public OrderItemShipGrpInvRes(GenericValue value) {
		orderId = (String) value.get(FIELD_ORDER_ID);
		shipGroupSeqId = (String) value.get(FIELD_SHIP_GROUP_SEQ_ID);
		orderItemSeqId = (String) value.get(FIELD_ORDER_ITEM_SEQ_ID);
		inventoryItemId = (String) value.get(FIELD_INVENTORY_ITEM_ID);
		reserveOrderEnumId = (String) value.get(FIELD_RESERVE_ORDER_ENUM_ID);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
		quantityNotAvailable = (BigDecimal) value
				.get(FIELD_QUANTITY_NOT_AVAILABLE);
		reservedDatetime = (Timestamp) value.get(FIELD_RESERVED_DATETIME);
		createdDatetime = (Timestamp) value.get(FIELD_CREATED_DATETIME);
		promisedDatetime = (Timestamp) value.get(FIELD_PROMISED_DATETIME);
		currentPromisedDate = (Timestamp) value
				.get(FIELD_CURRENT_PROMISED_DATE);
		priority = (String) value.get(FIELD_PRIORITY);
		sequenceId = (Long) value.get(FIELD_SEQUENCE_ID);
		oldPickStartDate = (Timestamp) value.get(FIELD_OLD_PICK_START_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static OrderItemShipGrpInvRes fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderItemShipGrpInvRes(value);
	}

	public static List<OrderItemShipGrpInvRes> fromValues(
			List<GenericValue> values) {
		List<OrderItemShipGrpInvRes> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderItemShipGrpInvRes(value));
		}
		return entities;
	}
}