package org.apache.ofbiz.order.order;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Payment Pref And Payment
 */
public class OrderPaymentPrefAndPayment implements Serializable {

	public static final long serialVersionUID = 525577959179872256L;
	public static final String NAME = "OrderPaymentPrefAndPayment";
	/**
	 * Order Payment Preference Id
	 */
	@Getter
	@Setter
	private String orderPaymentPreferenceId;
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Payment Id
	 */
	@Getter
	@Setter
	private String paymentId;
	/**
	 * Payment Type Id
	 */
	@Getter
	@Setter
	private String paymentTypeId;
	/**
	 * Amount
	 */
	@Getter
	@Setter
	private BigDecimal amount;

	public enum Fields {
		orderPaymentPreferenceId, orderId, statusId, paymentId, paymentTypeId, amount
	}

	public OrderPaymentPrefAndPayment(GenericValue value) {
		orderPaymentPreferenceId = (String) value
				.get(Fields.orderPaymentPreferenceId.name());
		orderId = (String) value.get(Fields.orderId.name());
		statusId = (String) value.get(Fields.statusId.name());
		paymentId = (String) value.get(Fields.paymentId.name());
		paymentTypeId = (String) value.get(Fields.paymentTypeId.name());
		amount = (BigDecimal) value.get(Fields.amount.name());
	}

	public static OrderPaymentPrefAndPayment fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderPaymentPrefAndPayment(value);
	}

	public static List<OrderPaymentPrefAndPayment> fromValues(
			List<GenericValue> values) {
		List<OrderPaymentPrefAndPayment> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderPaymentPrefAndPayment(value));
		}
		return entities;
	}
}