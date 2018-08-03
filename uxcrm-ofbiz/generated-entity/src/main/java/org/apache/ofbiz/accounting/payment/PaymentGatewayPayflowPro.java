package org.apache.ofbiz.accounting.payment;

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
public class PaymentGatewayPayflowPro implements Serializable {

	public static final long serialVersionUID = 5413857416896509952L;
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

	public enum Fields {
		paymentGatewayConfigId, certsPath, hostAddress, hostPort, timeout, proxyAddress, proxyPort, proxyLogon, proxyPassword, vendor, userId, pwd, partner, checkAvs, checkCvv2, preAuth, enableTransmit, logFileName, loggingLevel, maxLogFileSize, stackTraceOn, redirectUrl, returnUrl, cancelReturnUrl, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PaymentGatewayPayflowPro(GenericValue value) {
		paymentGatewayConfigId = (String) value
				.get(Fields.paymentGatewayConfigId.name());
		certsPath = (String) value.get(Fields.certsPath.name());
		hostAddress = (String) value.get(Fields.hostAddress.name());
		hostPort = (Long) value.get(Fields.hostPort.name());
		timeout = (Long) value.get(Fields.timeout.name());
		proxyAddress = (String) value.get(Fields.proxyAddress.name());
		proxyPort = (Long) value.get(Fields.proxyPort.name());
		proxyLogon = (String) value.get(Fields.proxyLogon.name());
		proxyPassword = (String) value.get(Fields.proxyPassword.name());
		vendor = (String) value.get(Fields.vendor.name());
		userId = (String) value.get(Fields.userId.name());
		pwd = (String) value.get(Fields.pwd.name());
		partner = (String) value.get(Fields.partner.name());
		checkAvs = (String) value.get(Fields.checkAvs.name());
		checkCvv2 = (String) value.get(Fields.checkCvv2.name());
		preAuth = (String) value.get(Fields.preAuth.name());
		enableTransmit = (String) value.get(Fields.enableTransmit.name());
		logFileName = (String) value.get(Fields.logFileName.name());
		loggingLevel = (Long) value.get(Fields.loggingLevel.name());
		maxLogFileSize = (Long) value.get(Fields.maxLogFileSize.name());
		stackTraceOn = (String) value.get(Fields.stackTraceOn.name());
		redirectUrl = (String) value.get(Fields.redirectUrl.name());
		returnUrl = (String) value.get(Fields.returnUrl.name());
		cancelReturnUrl = (String) value.get(Fields.cancelReturnUrl.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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