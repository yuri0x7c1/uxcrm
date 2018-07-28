package org.apache.ofbiz.order.order;

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
public class OrderItemShipGrpInvRes implements Serializable {

	public static final long serialVersionUID = 1764249626361550848L;
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

	public enum Fields {
		orderId, shipGroupSeqId, orderItemSeqId, inventoryItemId, reserveOrderEnumId, quantity, quantityNotAvailable, reservedDatetime, createdDatetime, promisedDatetime, currentPromisedDate, priority, sequenceId, oldPickStartDate, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public OrderItemShipGrpInvRes(GenericValue value) {
		orderId = (String) value.get(Fields.orderId.name());
		shipGroupSeqId = (String) value.get(Fields.shipGroupSeqId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		inventoryItemId = (String) value.get(Fields.inventoryItemId.name());
		reserveOrderEnumId = (String) value.get(Fields.reserveOrderEnumId
				.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		quantityNotAvailable = (BigDecimal) value
				.get(Fields.quantityNotAvailable.name());
		reservedDatetime = (Timestamp) value
				.get(Fields.reservedDatetime.name());
		createdDatetime = (Timestamp) value.get(Fields.createdDatetime.name());
		promisedDatetime = (Timestamp) value
				.get(Fields.promisedDatetime.name());
		currentPromisedDate = (Timestamp) value.get(Fields.currentPromisedDate
				.name());
		priority = (String) value.get(Fields.priority.name());
		sequenceId = (Long) value.get(Fields.sequenceId.name());
		oldPickStartDate = (Timestamp) value
				.get(Fields.oldPickStartDate.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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