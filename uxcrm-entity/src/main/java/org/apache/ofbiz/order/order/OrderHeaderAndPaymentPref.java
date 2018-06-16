package org.apache.ofbiz.order.order;

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
public class OrderHeaderAndPaymentPref implements Serializable {

	public static final long serialVersionUID = 1170550813288268800L;
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

	public enum Fields {
		orderId, orderDate, originFacilityId, productStoreId, terminalId, webSiteId, currencyUom, orderPaymentPreferenceId, paymentMethodTypeId, orderStatusId, paymentStatusId, maxAmount
	}

	public OrderHeaderAndPaymentPref(GenericValue value) {
		orderId = (String) value.get(Fields.orderId.name());
		orderDate = (Timestamp) value.get(Fields.orderDate.name());
		originFacilityId = (String) value.get(Fields.originFacilityId.name());
		productStoreId = (String) value.get(Fields.productStoreId.name());
		terminalId = (String) value.get(Fields.terminalId.name());
		webSiteId = (String) value.get(Fields.webSiteId.name());
		currencyUom = (String) value.get(Fields.currencyUom.name());
		orderPaymentPreferenceId = (String) value
				.get(Fields.orderPaymentPreferenceId.name());
		paymentMethodTypeId = (String) value.get(Fields.paymentMethodTypeId
				.name());
		orderStatusId = (String) value.get(Fields.orderStatusId.name());
		paymentStatusId = (String) value.get(Fields.paymentStatusId.name());
		maxAmount = (BigDecimal) value.get(Fields.maxAmount.name());
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