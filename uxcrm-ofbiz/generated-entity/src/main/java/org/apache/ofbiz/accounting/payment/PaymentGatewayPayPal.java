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
 * Payment Gateway Pay Pal
 */
@FieldNameConstants
public class PaymentGatewayPayPal implements Serializable {

	public static final long serialVersionUID = 4378961158437265408L;
	public static final String NAME = "PaymentGatewayPayPal";
	/**
	 * Payment Gateway Config Id
	 */
	@Getter
	@Setter
	private String paymentGatewayConfigId;
	/**
	 * Business Email
	 */
	@Getter
	@Setter
	private String businessEmail;
	/**
	 * Api User Name
	 */
	@Getter
	@Setter
	private String apiUserName;
	/**
	 * Api Password
	 */
	@Getter
	@Setter
	private String apiPassword;
	/**
	 * Api Signature
	 */
	@Getter
	@Setter
	private String apiSignature;
	/**
	 * Api Environment
	 */
	@Getter
	@Setter
	private String apiEnvironment;
	/**
	 * Notify Url
	 */
	@Getter
	@Setter
	private String notifyUrl;
	/**
	 * Return Url
	 */
	@Getter
	@Setter
	private String returnUrl;
	/**
	 * Cancel Return Url
	 */
	@Getter
	@Setter
	private String cancelReturnUrl;
	/**
	 * Image Url
	 */
	@Getter
	@Setter
	private String imageUrl;
	/**
	 * Confirm Template
	 */
	@Getter
	@Setter
	private String confirmTemplate;
	/**
	 * Redirect Url
	 */
	@Getter
	@Setter
	private String redirectUrl;
	/**
	 * Confirm Url
	 */
	@Getter
	@Setter
	private String confirmUrl;
	/**
	 * Shipping Callback Url
	 */
	@Getter
	@Setter
	private String shippingCallbackUrl;
	/**
	 * Require Confirmed Shipping
	 */
	@Getter
	@Setter
	private String requireConfirmedShipping;
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

	public PaymentGatewayPayPal(GenericValue value) {
		paymentGatewayConfigId = (String) value
				.get(FIELD_PAYMENT_GATEWAY_CONFIG_ID);
		businessEmail = (String) value.get(FIELD_BUSINESS_EMAIL);
		apiUserName = (String) value.get(FIELD_API_USER_NAME);
		apiPassword = (String) value.get(FIELD_API_PASSWORD);
		apiSignature = (String) value.get(FIELD_API_SIGNATURE);
		apiEnvironment = (String) value.get(FIELD_API_ENVIRONMENT);
		notifyUrl = (String) value.get(FIELD_NOTIFY_URL);
		returnUrl = (String) value.get(FIELD_RETURN_URL);
		cancelReturnUrl = (String) value.get(FIELD_CANCEL_RETURN_URL);
		imageUrl = (String) value.get(FIELD_IMAGE_URL);
		confirmTemplate = (String) value.get(FIELD_CONFIRM_TEMPLATE);
		redirectUrl = (String) value.get(FIELD_REDIRECT_URL);
		confirmUrl = (String) value.get(FIELD_CONFIRM_URL);
		shippingCallbackUrl = (String) value.get(FIELD_SHIPPING_CALLBACK_URL);
		requireConfirmedShipping = (String) value
				.get(FIELD_REQUIRE_CONFIRMED_SHIPPING);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PaymentGatewayPayPal fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentGatewayPayPal(value);
	}

	public static List<PaymentGatewayPayPal> fromValues(
			List<GenericValue> values) {
		List<PaymentGatewayPayPal> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentGatewayPayPal(value));
		}
		return entities;
	}
}