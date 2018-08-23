package org.apache.ofbiz.accounting.payment;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Payment Gateway World Pay
 */
@FieldNameConstants
public class PaymentGatewayWorldPay implements Serializable {

	public static final long serialVersionUID = 5897904905836355584L;
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

	public PaymentGatewayWorldPay(GenericValue value) {
		paymentGatewayConfigId = (String) value
				.get(FIELD_PAYMENT_GATEWAY_CONFIG_ID);
		redirectUrl = (String) value.get(FIELD_REDIRECT_URL);
		instId = (String) value.get(FIELD_INST_ID);
		authMode = (String) value.get(FIELD_AUTH_MODE);
		fixContact = (String) value.get(FIELD_FIX_CONTACT);
		hideContact = (String) value.get(FIELD_HIDE_CONTACT);
		hideCurrency = (String) value.get(FIELD_HIDE_CURRENCY);
		langId = (String) value.get(FIELD_LANG_ID);
		noLanguageMenu = (String) value.get(FIELD_NO_LANGUAGE_MENU);
		withDelivery = (String) value.get(FIELD_WITH_DELIVERY);
		testMode = (Long) value.get(FIELD_TEST_MODE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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