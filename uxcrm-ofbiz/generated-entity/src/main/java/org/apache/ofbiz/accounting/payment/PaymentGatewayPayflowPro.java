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
 * Payment Gateway Payflow Pro
 */
@FieldNameConstants
public class PaymentGatewayPayflowPro implements Serializable {

	public static final long serialVersionUID = 3593216270583843840L;
	public static final String NAME = "PaymentGatewayPayflowPro";
	/**
	 * Payment Gateway Config Id
	 */
	@Getter
	@Setter
	private String paymentGatewayConfigId;
	/**
	 * Certs Path
	 */
	@Getter
	@Setter
	private String certsPath;
	/**
	 * Host Address
	 */
	@Getter
	@Setter
	private String hostAddress;
	/**
	 * Host Port
	 */
	@Getter
	@Setter
	private Long hostPort;
	/**
	 * Timeout
	 */
	@Getter
	@Setter
	private Long timeout;
	/**
	 * Proxy Address
	 */
	@Getter
	@Setter
	private String proxyAddress;
	/**
	 * Proxy Port
	 */
	@Getter
	@Setter
	private Long proxyPort;
	/**
	 * Proxy Logon
	 */
	@Getter
	@Setter
	private String proxyLogon;
	/**
	 * Proxy Password
	 */
	@Getter
	@Setter
	private String proxyPassword;
	/**
	 * Vendor
	 */
	@Getter
	@Setter
	private String vendor;
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
	 * Partner
	 */
	@Getter
	@Setter
	private String partner;
	/**
	 * Check Avs
	 */
	@Getter
	@Setter
	private String checkAvs;
	/**
	 * Check Cvv 2
	 */
	@Getter
	@Setter
	private String checkCvv2;
	/**
	 * Pre Auth
	 */
	@Getter
	@Setter
	private String preAuth;
	/**
	 * Enable Transmit
	 */
	@Getter
	@Setter
	private String enableTransmit;
	/**
	 * Log File Name
	 */
	@Getter
	@Setter
	private String logFileName;
	/**
	 * Logging Level
	 */
	@Getter
	@Setter
	private Long loggingLevel;
	/**
	 * Max Log File Size
	 */
	@Getter
	@Setter
	private Long maxLogFileSize;
	/**
	 * Stack Trace On
	 */
	@Getter
	@Setter
	private String stackTraceOn;
	/**
	 * Redirect Url
	 */
	@Getter
	@Setter
	private String redirectUrl;
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

	public PaymentGatewayPayflowPro(GenericValue value) {
		paymentGatewayConfigId = (String) value
				.get(FIELD_PAYMENT_GATEWAY_CONFIG_ID);
		certsPath = (String) value.get(FIELD_CERTS_PATH);
		hostAddress = (String) value.get(FIELD_HOST_ADDRESS);
		hostPort = (Long) value.get(FIELD_HOST_PORT);
		timeout = (Long) value.get(FIELD_TIMEOUT);
		proxyAddress = (String) value.get(FIELD_PROXY_ADDRESS);
		proxyPort = (Long) value.get(FIELD_PROXY_PORT);
		proxyLogon = (String) value.get(FIELD_PROXY_LOGON);
		proxyPassword = (String) value.get(FIELD_PROXY_PASSWORD);
		vendor = (String) value.get(FIELD_VENDOR);
		userId = (String) value.get(FIELD_USER_ID);
		pwd = (String) value.get(FIELD_PWD);
		partner = (String) value.get(FIELD_PARTNER);
		checkAvs = (String) value.get(FIELD_CHECK_AVS);
		checkCvv2 = (String) value.get(FIELD_CHECK_CVV2);
		preAuth = (String) value.get(FIELD_PRE_AUTH);
		enableTransmit = (String) value.get(FIELD_ENABLE_TRANSMIT);
		logFileName = (String) value.get(FIELD_LOG_FILE_NAME);
		loggingLevel = (Long) value.get(FIELD_LOGGING_LEVEL);
		maxLogFileSize = (Long) value.get(FIELD_MAX_LOG_FILE_SIZE);
		stackTraceOn = (String) value.get(FIELD_STACK_TRACE_ON);
		redirectUrl = (String) value.get(FIELD_REDIRECT_URL);
		returnUrl = (String) value.get(FIELD_RETURN_URL);
		cancelReturnUrl = (String) value.get(FIELD_CANCEL_RETURN_URL);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PaymentGatewayPayflowPro fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentGatewayPayflowPro(value);
	}

	public static List<PaymentGatewayPayflowPro> fromValues(
			List<GenericValue> values) {
		List<PaymentGatewayPayflowPro> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentGatewayPayflowPro(value));
		}
		return entities;
	}
}