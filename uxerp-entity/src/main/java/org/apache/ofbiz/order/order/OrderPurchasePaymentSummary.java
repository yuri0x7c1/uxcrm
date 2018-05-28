package org.apache.ofbiz.order.order;

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
public class OrderPurchasePaymentSummary implements Serializable {

	public static final long serialVersionUID = 4713917903344777216L;
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

	public enum Fields {
		webSiteId, productStoreId, originFacilityId, terminalId, statusId, paymentMethodTypeId, description, maxAmount, orderId, orderTypeId, orderDate, billingAccountId, preferenceStatusId
	}

	public OrderPurchasePaymentSummary(GenericValue value) {
		webSiteId = (String) value.get(Fields.webSiteId.name());
		productStoreId = (String) value.get(Fields.productStoreId.name());
		originFacilityId = (String) value.get(Fields.originFacilityId.name());
		terminalId = (String) value.get(Fields.terminalId.name());
		statusId = (String) value.get(Fields.statusId.name());
		paymentMethodTypeId = (String) value.get(Fields.paymentMethodTypeId
				.name());
		description = (String) value.get(Fields.description.name());
		maxAmount = (BigDecimal) value.get(Fields.maxAmount.name());
		orderId = (String) value.get(Fields.orderId.name());
		orderTypeId = (String) value.get(Fields.orderTypeId.name());
		orderDate = (Timestamp) value.get(Fields.orderDate.name());
		billingAccountId = (String) value.get(Fields.billingAccountId.name());
		preferenceStatusId = (String) value.get(Fields.preferenceStatusId
				.name());
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