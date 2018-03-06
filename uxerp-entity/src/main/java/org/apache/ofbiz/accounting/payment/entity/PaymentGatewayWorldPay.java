package org.apache.ofbiz.accounting.payment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Payment Gateway World Pay
 */
public class PaymentGatewayWorldPay implements Serializable {

	public static final long serialVersionUID = 7257470340714489856L;
	public static final String NAME = "PaymentGatewayWorldPay";
	/**
	 * Payment Gateway Config Id
	 */
	@Getter
	@Setter
	private String paymentGatewayConfigId;
	/**
	 * Redirect Url
	 */
	@Getter
	@Setter
	private String redirectUrl;
	/**
	 * Inst Id
	 */
	@Getter
	@Setter
	private String instId;
	/**
	 * Auth Mode
	 */
	@Getter
	@Setter
	private String authMode;
	/**
	 * Fix Contact
	 */
	@Getter
	@Setter
	private String fixContact;
	/**
	 * Hide Contact
	 */
	@Getter
	@Setter
	private String hideContact;
	/**
	 * Hide Currency
	 */
	@Getter
	@Setter
	private String hideCurrency;
	/**
	 * Lang Id
	 */
	@Getter
	@Setter
	private String langId;
	/**
	 * No Language Menu
	 */
	@Getter
	@Setter
	private String noLanguageMenu;
	/**
	 * With Delivery
	 */
	@Getter
	@Setter
	private String withDelivery;
	/**
	 * Test Mode
	 */
	@Getter
	@Setter
	private Long testMode;

	public enum Fields {
		paymentGatewayConfigId, redirectUrl, instId, authMode, fixContact, hideContact, hideCurrency, langId, noLanguageMenu, withDelivery, testMode
	}

	public PaymentGatewayWorldPay(GenericValue value) {
		paymentGatewayConfigId = (String) value
				.get(Fields.paymentGatewayConfigId.name());
		redirectUrl = (String) value.get(Fields.redirectUrl.name());
		instId = (String) value.get(Fields.instId.name());
		authMode = (String) value.get(Fields.authMode.name());
		fixContact = (String) value.get(Fields.fixContact.name());
		hideContact = (String) value.get(Fields.hideContact.name());
		hideCurrency = (String) value.get(Fields.hideCurrency.name());
		langId = (String) value.get(Fields.langId.name());
		noLanguageMenu = (String) value.get(Fields.noLanguageMenu.name());
		withDelivery = (String) value.get(Fields.withDelivery.name());
		testMode = (Long) value.get(Fields.testMode.name());
	}

	public static PaymentGatewayWorldPay fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentGatewayWorldPay(value);
	}

	public static List<PaymentGatewayWorldPay> fromValues(
			List<GenericValue> values) {
		List<PaymentGatewayWorldPay> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentGatewayWorldPay(value));
		}
		return entities;
	}
}