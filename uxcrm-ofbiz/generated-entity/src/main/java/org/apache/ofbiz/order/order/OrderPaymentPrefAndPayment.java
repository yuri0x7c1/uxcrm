package org.apache.ofbiz.order.order;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class OrderPaymentPrefAndPayment implements Serializable {

	public static final long serialVersionUID = 7291834151036934144L;
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

	public OrderPaymentPrefAndPayment(GenericValue value) {
		orderPaymentPreferenceId = (String) value
				.get(FIELD_ORDER_PAYMENT_PREFERENCE_ID);
		orderId = (String) value.get(FIELD_ORDER_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		paymentId = (String) value.get(FIELD_PAYMENT_ID);
		paymentTypeId = (String) value.get(FIELD_PAYMENT_TYPE_ID);
		amount = (BigDecimal) value.get(FIELD_AMOUNT);
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