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
 * Order Notification
 */
@FieldNameConstants
public class OrderNotification implements Serializable {

	public static final long serialVersionUID = 1954179394243371008L;
	public static final String NAME = "OrderNotification";
	/**
	 * Order Notification Id
	 */
	@Getter
	@Setter
	private String orderNotificationId;
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Email Type
	 */
	@Getter
	@Setter
	private String emailType;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Notification Date
	 */
	@Getter
	@Setter
	private Timestamp notificationDate;
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

	public OrderNotification(GenericValue value) {
		orderNotificationId = (String) value.get(FIELD_ORDER_NOTIFICATION_ID);
		orderId = (String) value.get(FIELD_ORDER_ID);
		emailType = (String) value.get(FIELD_EMAIL_TYPE);
		comments = (String) value.get(FIELD_COMMENTS);
		notificationDate = (Timestamp) value.get(FIELD_NOTIFICATION_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static OrderNotification fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderNotification(value);
	}

	public static List<OrderNotification> fromValues(List<GenericValue> values) {
		List<OrderNotification> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderNotification(value));
		}
		return entities;
	}
}