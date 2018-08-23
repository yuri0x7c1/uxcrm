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
 * Order Status
 */
@FieldNameConstants
public class OrderStatus implements Serializable {

	public static final long serialVersionUID = 8038093020441509888L;
	public static final String NAME = "OrderStatus";
	/**
	 * Order Status Id
	 */
	@Getter
	@Setter
	private String orderStatusId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
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
	 * Order Payment Preference Id
	 */
	@Getter
	@Setter
	private String orderPaymentPreferenceId;
	/**
	 * Status Datetime
	 */
	@Getter
	@Setter
	private Timestamp statusDatetime;
	/**
	 * Status User Login
	 */
	@Getter
	@Setter
	private String statusUserLogin;
	/**
	 * Change Reason
	 */
	@Getter
	@Setter
	private String changeReason;
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

	public OrderStatus(GenericValue value) {
		orderStatusId = (String) value.get(FIELD_ORDER_STATUS_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		orderId = (String) value.get(FIELD_ORDER_ID);
		orderItemSeqId = (String) value.get(FIELD_ORDER_ITEM_SEQ_ID);
		orderPaymentPreferenceId = (String) value
				.get(FIELD_ORDER_PAYMENT_PREFERENCE_ID);
		statusDatetime = (Timestamp) value.get(FIELD_STATUS_DATETIME);
		statusUserLogin = (String) value.get(FIELD_STATUS_USER_LOGIN);
		changeReason = (String) value.get(FIELD_CHANGE_REASON);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static OrderStatus fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderStatus(value);
	}

	public static List<OrderStatus> fromValues(List<GenericValue> values) {
		List<OrderStatus> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderStatus(value));
		}
		return entities;
	}
}