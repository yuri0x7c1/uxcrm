package org.apache.ofbiz.accounting.payment;

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
public class PaymentGatewayPayPal implements Serializable {

	public static final long serialVersionUID = 8194083062186673152L;
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

	public enum Fields {
		paymentGatewayConfigId, businessEmail, apiUserName, apiPassword, apiSignature, apiEnvironment, notifyUrl, returnUrl, cancelReturnUrl, imageUrl, confirmTemplate, redirectUrl, confirmUrl, shippingCallbackUrl, requireConfirmedShipping, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PaymentGatewayPayPal(GenericValue value) {
		paymentGatewayConfigId = (String) value
				.get(Fields.paymentGatewayConfigId.name());
		businessEmail = (String) value.get(Fields.businessEmail.name());
		apiUserName = (String) value.get(Fields.apiUserName.name());
		apiPassword = (String) value.get(Fields.apiPassword.name());
		apiSignature = (String) value.get(Fields.apiSignature.name());
		apiEnvironment = (String) value.get(Fields.apiEnvironment.name());
		notifyUrl = (String) value.get(Fields.notifyUrl.name());
		returnUrl = (String) value.get(Fields.returnUrl.name());
		cancelReturnUrl = (String) value.get(Fields.cancelReturnUrl.name());
		imageUrl = (String) value.get(Fields.imageUrl.name());
		confirmTemplate = (String) value.get(Fields.confirmTemplate.name());
		redirectUrl = (String) value.get(Fields.redirectUrl.name());
		confirmUrl = (String) value.get(Fields.confirmUrl.name());
		shippingCallbackUrl = (String) value.get(Fields.shippingCallbackUrl
				.name());
		requireConfirmedShipping = (String) value
				.get(Fields.requireConfirmedShipping.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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