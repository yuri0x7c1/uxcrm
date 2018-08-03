package org.apache.ofbiz.order.order;

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
public class OrderStatus implements Serializable {

	public static final long serialVersionUID = 1824577375683607552L;
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

	public enum Fields {
		orderStatusId, statusId, orderId, orderItemSeqId, orderPaymentPreferenceId, statusDatetime, statusUserLogin, changeReason, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public OrderStatus(GenericValue value) {
		orderStatusId = (String) value.get(Fields.orderStatusId.name());
		statusId = (String) value.get(Fields.statusId.name());
		orderId = (String) value.get(Fields.orderId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		orderPaymentPreferenceId = (String) value
				.get(Fields.orderPaymentPreferenceId.name());
		statusDatetime = (Timestamp) value.get(Fields.statusDatetime.name());
		statusUserLogin = (String) value.get(Fields.statusUserLogin.name());
		changeReason = (String) value.get(Fields.changeReason.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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