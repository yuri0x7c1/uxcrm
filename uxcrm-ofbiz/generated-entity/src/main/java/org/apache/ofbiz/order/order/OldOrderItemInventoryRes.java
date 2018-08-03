package org.apache.ofbiz.order.order;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Old Order Item Inventory Res
 */
public class OldOrderItemInventoryRes implements Serializable {

	public static final long serialVersionUID = 2534377088029425664L;
	public static final String NAME = "OldOrderItemInventoryRes";
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
	private Double quantity;
	/**
	 * Quantity Not Available
	 */
	@Getter
	@Setter
	private Double quantityNotAvailable;
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
	 * Pick Start Date
	 */
	@Getter
	@Setter
	private Timestamp pickStartDate;
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
		orderId, orderItemSeqId, inventoryItemId, reserveOrderEnumId, quantity, quantityNotAvailable, reservedDatetime, createdDatetime, promisedDatetime, currentPromisedDate, pickStartDate, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public OldOrderItemInventoryRes(GenericValue value) {
		orderId = (String) value.get(Fields.orderId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		inventoryItemId = (String) value.get(Fields.inventoryItemId.name());
		reserveOrderEnumId = (String) value.get(Fields.reserveOrderEnumId
				.name());
		quantity = (Double) value.get(Fields.quantity.name());
		quantityNotAvailable = (Double) value.get(Fields.quantityNotAvailable
				.name());
		reservedDatetime = (Timestamp) value
				.get(Fields.reservedDatetime.name());
		createdDatetime = (Timestamp) value.get(Fields.createdDatetime.name());
		promisedDatetime = (Timestamp) value
				.get(Fields.promisedDatetime.name());
		currentPromisedDate = (Timestamp) value.get(Fields.currentPromisedDate
				.name());
		pickStartDate = (Timestamp) value.get(Fields.pickStartDate.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static OldOrderItemInventoryRes fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OldOrderItemInventoryRes(value);
	}

	public static List<OldOrderItemInventoryRes> fromValues(
			List<GenericValue> values) {
		List<OldOrderItemInventoryRes> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OldOrderItemInventoryRes(value));
		}
		return entities;
	}
}