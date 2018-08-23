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
 * Payment Gateway Orbital
 */
@FieldNameConstants
public class PaymentGatewayOrbital implements Serializable {

	public static final long serialVersionUID = 7371324348467335168L;
	public static final String NAME = "PaymentGatewayOrbital";
	/**
	 * Payment Gateway Config Id
	 */
	@Getter
	@Setter
	private String paymentGatewayConfigId;
	/**
	 * Username
	 */
	@Getter
	@Setter
	private String username;
	/**
	 * Connection Password
	 */
	@Getter
	@Setter
	private String connectionPassword;
	/**
	 * Merchant Id
	 */
	@Getter
	@Setter
	private String merchantId;
	/**
	 * Engine Class
	 */
	@Getter
	@Setter
	private String engineClass;
	/**
	 * Host Name
	 */
	@Getter
	@Setter
	private String hostName;
	/**
	 * Port
	 */
	@Getter
	@Setter
	private Long port;
	/**
	 * Host Name Failover
	 */
	@Getter
	@Setter
	private String hostNameFailover;
	/**
	 * Port Failover
	 */
	@Getter
	@Setter
	private Long portFailover;
	/**
	 * Connection Timeout Seconds
	 */
	@Getter
	@Setter
	private Long connectionTimeoutSeconds;
	/**
	 * Read Timeout Seconds
	 */
	@Getter
	@Setter
	private Long readTimeoutSeconds;
	/**
	 * Authorization Uri
	 */
	@Getter
	@Setter
	private String authorizationURI;
	/**
	 * Sdk Version
	 */
	@Getter
	@Setter
	private String sdkVersion;
	/**
	 * Ssl Socket Factory
	 */
	@Getter
	@Setter
	private String sslSocketFactory;
	/**
	 * Response Type
	 */
	@Getter
	@Setter
	private String responseType;
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

	public PaymentGatewayOrbital(GenericValue value) {
		paymentGatewayConfigId = (String) value
				.get(FIELD_PAYMENT_GATEWAY_CONFIG_ID);
		username = (String) value.get(FIELD_USERNAME);
		connectionPassword = (String) value.get(FIELD_CONNECTION_PASSWORD);
		merchantId = (String) value.get(FIELD_MERCHANT_ID);
		engineClass = (String) value.get(FIELD_ENGINE_CLASS);
		hostName = (String) value.get(FIELD_HOST_NAME);
		port = (Long) value.get(FIELD_PORT);
		hostNameFailover = (String) value.get(FIELD_HOST_NAME_FAILOVER);
		portFailover = (Long) value.get(FIELD_PORT_FAILOVER);
		connectionTimeoutSeconds = (Long) value
				.get(FIELD_CONNECTION_TIMEOUT_SECONDS);
		readTimeoutSeconds = (Long) value.get(FIELD_READ_TIMEOUT_SECONDS);
		authorizationURI = (String) value.get(FIELD_AUTHORIZATION_U_R_I);
		sdkVersion = (String) value.get(FIELD_SDK_VERSION);
		sslSocketFactory = (String) value.get(FIELD_SSL_SOCKET_FACTORY);
		responseType = (String) value.get(FIELD_RESPONSE_TYPE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static PaymentGatewayOrbital fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PaymentGatewayOrbital(value);
	}

	public static List<PaymentGatewayOrbital> fromValues(
			List<GenericValue> values) {
		List<PaymentGatewayOrbital> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PaymentGatewayOrbital(value));
		}
		return entities;
	}
}