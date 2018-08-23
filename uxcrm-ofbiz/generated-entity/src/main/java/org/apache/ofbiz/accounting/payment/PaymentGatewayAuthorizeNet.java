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
 * Payment Gateway Authorize Net
 */
@FieldNameConstants
public class PaymentGatewayAuthorizeNet implements Serializable {

	public static final long serialVersionUID = 5228801202059915264L;
	public static final String NAME = "PaymentGatewayAuthorizeNet";
	/**
	 * Payment Gateway Config Id
	 */
	@Getter
	@Setter
	private String paymentGatewayConfigId;
	/**
	 * Transaction Url
	 */
	@Getter
	@Setter
	private String transactionUrl;
	/**
	 * Certificate Alias
	 */
	@Getter
	@Setter
	private String certificateAlias;
	/**
	 * Api Version
	 */
	@Getter
	@Setter
	private String apiVersion;
	/**
	 * Delimited Data
	 */
	@Getter
	@Setter
	private String delimitedData;
	/**
	 * Delimiter Char
	 */
	@Getter
	@Setter
	private String delimiterChar;
	/**
	 * Cp Version
	 */
	@Getter
	@Setter
	private String cpVersion;
	/**
	 * Cp Market Type
	 */
	@Getter
	@Setter
	private String cpMarketType;
	/**
	 * Cp Device Type
	 */
	@Getter
	@Setter
	private String cpDeviceType;
	/**
	 * Method
	 */
	@Getter
	@Setter
	private String method;
	/**
	 * Email Customer
	 */
	@Getter
	@Setter
	private String emailCustomer;
	/**
	 * Email Merchant
	 */
	@Getter
	@Setter
	private String emailMerchant;
	/**
	 * Test Mode
	 */
	@Getter
	@Setter
	private String testMode;
	/**
	 * Relay Response
	 */
	@Getter
	@Setter
	private String relayResponse;
	/**
	 * Tran Key
	 */
	@Getter
	@Setter
	private String tranKey;
	/**
	 * User Id
	 */
	@Getter
	@Setter
	private String userId;
	/**
	 * Pwd
	 */
	@Getter
	@Setter
	private String pwd;
	/**
	 * Trans Description
	 */
	@Getter
	@Setter
	private String transDescription;
	/**
	 * Duplicate Window
	 */
	@Getter
	@Setter
	private Long duplicateWindow;
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

	public PaymentGatewayAuthorizeNet(GenericValue value) {
		paymentGatewayConfigId = (String) value
				.get(FIELD_PAYMENT_GATEWAY_CONFIG_ID);
		transactionUrl = (String) value.get(FIELD_TRANSACTION_URL);
		certificateAlias = (String) value.get(FIELD_CERTIFICATE_ALIAS);
		apiVersion = (String) value.get(FIELD_API_VERSION);
		delimitedData = (String) value.get(FIELD_DELIMITED_DATA);
		delimiterChar = (String) value.get(FIELD_DELIMITER_CHAR);
		cpVersion = (String) value.get(FIELD_CP_VERSION);
		cpMarketType = (String) value.get(FIELD_CP_MARKET_TYPE);
		cpDeviceType = (String) value.get(FIELD_CP_DEVICE_TYPE);
		method = (String) value.get(FIELD_METHOD);
		emailCustomer = (String) value.get(FIELD_EMAIL_CUSTOMER);
		emailMerchant = (String) value.get(FIELD_EMAIL_MERCHANT);
		testMode = (String) value.get(FIELD_TEST_MODE);
		relayResponse = (String) value.get(FIELD_RELAY_RESPONSE);
		tranKey = (String) value.get(FIELD_TRAN_KEY);
		userId = (String) value.get(FIELD_USER_ID);
		pwd = (String) value.get(FIELD_PWD);
		transDescription = (String) value.get(FIELD_TRANS_DESCRIPTION);
		duplicateWindow = (Long) value.get(FIELD_DUPLICATE_WINDOW);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PaymentGatewayAuthorizeNet fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentGatewayAuthorizeNet(value);
	}

	public static List<PaymentGatewayAuthorizeNet> fromValues(
			List<GenericValue> values) {
		List<PaymentGatewayAuthorizeNet> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentGatewayAuthorizeNet(value));
		}
		return entities;
	}
}