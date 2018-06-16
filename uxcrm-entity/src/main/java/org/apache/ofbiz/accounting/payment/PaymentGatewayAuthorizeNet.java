package org.apache.ofbiz.accounting.payment;

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
public class PaymentGatewayAuthorizeNet implements Serializable {

	public static final long serialVersionUID = 5143517035078411264L;
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

	public enum Fields {
		paymentGatewayConfigId, transactionUrl, certificateAlias, apiVersion, delimitedData, delimiterChar, cpVersion, cpMarketType, cpDeviceType, method, emailCustomer, emailMerchant, testMode, relayResponse, tranKey, userId, pwd, transDescription, duplicateWindow, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PaymentGatewayAuthorizeNet(GenericValue value) {
		paymentGatewayConfigId = (String) value
				.get(Fields.paymentGatewayConfigId.name());
		transactionUrl = (String) value.get(Fields.transactionUrl.name());
		certificateAlias = (String) value.get(Fields.certificateAlias.name());
		apiVersion = (String) value.get(Fields.apiVersion.name());
		delimitedData = (String) value.get(Fields.delimitedData.name());
		delimiterChar = (String) value.get(Fields.delimiterChar.name());
		cpVersion = (String) value.get(Fields.cpVersion.name());
		cpMarketType = (String) value.get(Fields.cpMarketType.name());
		cpDeviceType = (String) value.get(Fields.cpDeviceType.name());
		method = (String) value.get(Fields.method.name());
		emailCustomer = (String) value.get(Fields.emailCustomer.name());
		emailMerchant = (String) value.get(Fields.emailMerchant.name());
		testMode = (String) value.get(Fields.testMode.name());
		relayResponse = (String) value.get(Fields.relayResponse.name());
		tranKey = (String) value.get(Fields.tranKey.name());
		userId = (String) value.get(Fields.userId.name());
		pwd = (String) value.get(Fields.pwd.name());
		transDescription = (String) value.get(Fields.transDescription.name());
		duplicateWindow = (Long) value.get(Fields.duplicateWindow.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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