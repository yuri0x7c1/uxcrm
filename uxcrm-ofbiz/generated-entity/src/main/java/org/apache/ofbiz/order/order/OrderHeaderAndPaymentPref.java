package org.apache.ofbiz.order.order;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Header And Payment Pref
 */
@FieldNameConstants
public class OrderHeaderAndPaymentPref implements Serializable {

	public static final long serialVersionUID = 7617578551175858176L;
	public static final String NAME = "OrderHeaderAndPaymentPref";
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Order Date
	 */
	@Getter
	@Setter
	private Timestamp orderDate;
	/**
	 * Origin Facility Id
	 */
	@Getter
	@Setter
	private String originFacilityId;
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Terminal Id
	 */
	@Getter
	@Setter
	private String terminalId;
	/**
	 * Web Site Id
	 */
	@Getter
	@Setter
	private String webSiteId;
	/**
	 * Currency Uom
	 */
	@Getter
	@Setter
	private String currencyUom;
	/**
	 * Order Payment Preference Id
	 */
	@Getter
	@Setter
	private String orderPaymentPreferenceId;
	/**
	 * Payment Method Type Id
	 */
	@Getter
	@Setter
	private String paymentMethodTypeId;
	/**
	 * Order Status Id
	 */
	@Getter
	@Setter
	private String orderStatusId;
	/**
	 * Payment Status Id
	 */
	@Getter
	@Setter
	private String paymentStatusId;
	/**
	 * Max Amount
	 */
	@Getter
	@Setter
	private BigDecimal maxAmount;

	public OrderHeaderAndPaymentPref(GenericValue value) {
		orderId = (String) value.get(FIELD_ORDER_ID);
		orderDate = (Timestamp) value.get(FIELD_ORDER_DATE);
		originFacilityId = (String) value.get(FIELD_ORIGIN_FACILITY_ID);
		productStoreId = (String) value.get(FIELD_PRODUCT_STORE_ID);
		terminalId = (String) value.get(FIELD_TERMINAL_ID);
		webSiteId = (String) value.get(FIELD_WEB_SITE_ID);
		currencyUom = (String) value.get(FIELD_CURRENCY_UOM);
		orderPaymentPreferenceId = (String) value
				.get(FIELD_ORDER_PAYMENT_PREFERENCE_ID);
		paymentMethodTypeId = (String) value.get(FIELD_PAYMENT_METHOD_TYPE_ID);
		orderStatusId = (String) value.get(FIELD_ORDER_STATUS_ID);
		paymentStatusId = (String) value.get(FIELD_PAYMENT_STATUS_ID);
		maxAmount = (BigDecimal) value.get(FIELD_MAX_AMOUNT);
	}

	public static OrderHeaderAndPaymentPref fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderHeaderAndPaymentPref(value);
	}

	public static List<OrderHeaderAndPaymentPref> fromValues(
			List<GenericValue> values) {
		List<OrderHeaderAndPaymentPref> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderHeaderAndPaymentPref(value));
		}
		return entities;
	}
}