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
 * Old Order Item Inventory Res
 */
@FieldNameConstants
public class OldOrderItemInventoryRes implements Serializable {

	public static final long serialVersionUID = 3073783435674341376L;
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

	public OldOrderItemInventoryRes(GenericValue value) {
		orderId = (String) value.get(FIELD_ORDER_ID);
		orderItemSeqId = (String) value.get(FIELD_ORDER_ITEM_SEQ_ID);
		inventoryItemId = (String) value.get(FIELD_INVENTORY_ITEM_ID);
		reserveOrderEnumId = (String) value.get(FIELD_RESERVE_ORDER_ENUM_ID);
		quantity = (Double) value.get(FIELD_QUANTITY);
		quantityNotAvailable = (Double) value.get(FIELD_QUANTITY_NOT_AVAILABLE);
		reservedDatetime = (Timestamp) value.get(FIELD_RESERVED_DATETIME);
		createdDatetime = (Timestamp) value.get(FIELD_CREATED_DATETIME);
		promisedDatetime = (Timestamp) value.get(FIELD_PROMISED_DATETIME);
		currentPromisedDate = (Timestamp) value
				.get(FIELD_CURRENT_PROMISED_DATE);
		pickStartDate = (Timestamp) value.get(FIELD_PICK_START_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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