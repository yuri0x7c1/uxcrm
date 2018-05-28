package org.apache.ofbiz.order.order;

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

	public static final long serialVersionUID = 3340848296005813248L;
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

	public enum Fields {
		orderNotificationId, orderId, emailType, comments, notificationDate, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public OrderNotification(GenericValue value) {
		orderNotificationId = (String) value.get(Fields.orderNotificationId
				.name());
		orderId = (String) value.get(Fields.orderId.name());
		emailType = (String) value.get(Fields.emailType.name());
		comments = (String) value.get(Fields.comments.name());
		notificationDate = (Timestamp) value
				.get(Fields.notificationDate.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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