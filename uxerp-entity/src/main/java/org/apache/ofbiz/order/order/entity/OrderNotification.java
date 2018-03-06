package org.apache.ofbiz.order.order.entity;

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
public class OrderNotification implements Serializable {

	public static final long serialVersionUID = 4898905531977909248L;
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

	public enum Fields {
		orderNotificationId, orderId, emailType, comments, notificationDate
	}

	public OrderNotification(GenericValue value) {
		orderNotificationId = (String) value.get(Fields.orderNotificationId
				.name());
		orderId = (String) value.get(Fields.orderId.name());
		emailType = (String) value.get(Fields.emailType.name());
		comments = (String) value.get(Fields.comments.name());
		notificationDate = (Timestamp) value
				.get(Fields.notificationDate.name());
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