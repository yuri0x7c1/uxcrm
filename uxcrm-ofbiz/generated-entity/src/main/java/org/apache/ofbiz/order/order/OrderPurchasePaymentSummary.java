package org.apache.ofbiz.order.order;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Purchase Payment Summary
 */
@FieldNameConstants
public class OrderPurchasePaymentSummary implements Serializable {

	public static final long serialVersionUID = 8315448990050081792L;
	public static final String NAME = "OrderPurchasePaymentSummary";
	/**
	 * Web Site Id
	 */
	@Getter
	@Setter
	private String webSiteId;
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Origin Facility Id
	 */
	@Getter
	@Setter
	private String originFacilityId;
	/**
	 * Terminal Id
	 */
	@Getter
	@Setter
	private String terminalId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Payment Method Type Id
	 */
	@Getter
	@Setter
	private String paymentMethodTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Max Amount
	 */
	@Getter
	@Setter
	private BigDecimal maxAmount;
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Order Type Id
	 */
	@Getter
	@Setter
	private String orderTypeId;
	/**
	 * Order Date
	 */
	@Getter
	@Setter
	private Timestamp orderDate;
	/**
	 * Billing Account Id
	 */
	@Getter
	@Setter
	private String billingAccountId;
	/**
	 * Preference Status Id
	 */
	@Getter
	@Setter
	private String preferenceStatusId;

	public OrderPurchasePaymentSummary(GenericValue value) {
		webSiteId = (String) value.get(FIELD_WEB_SITE_ID);
		productStoreId = (String) value.get(FIELD_PRODUCT_STORE_ID);
		originFacilityId = (String) value.get(FIELD_ORIGIN_FACILITY_ID);
		terminalId = (String) value.get(FIELD_TERMINAL_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		paymentMethodTypeId = (String) value.get(FIELD_PAYMENT_METHOD_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		maxAmount = (BigDecimal) value.get(FIELD_MAX_AMOUNT);
		orderId = (String) value.get(FIELD_ORDER_ID);
		orderTypeId = (String) value.get(FIELD_ORDER_TYPE_ID);
		orderDate = (Timestamp) value.get(FIELD_ORDER_DATE);
		billingAccountId = (String) value.get(FIELD_BILLING_ACCOUNT_ID);
		preferenceStatusId = (String) value.get(FIELD_PREFERENCE_STATUS_ID);
	}

	public static OrderPurchasePaymentSummary fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderPurchasePaymentSummary(value);
	}

	public static List<OrderPurchasePaymentSummary> fromValues(
			List<GenericValue> values) {
		List<OrderPurchasePaymentSummary> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderPurchasePaymentSummary(value));
		}
		return entities;
	}
}