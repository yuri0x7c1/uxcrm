package org.apache.ofbiz.accounting.payment;

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
public class PaymentGatewayOrbital implements Serializable {

	public static final long serialVersionUID = 3775288319564897280L;
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

	public enum Fields {
		paymentGatewayConfigId, username, connectionPassword, merchantId, engineClass, hostName, port, hostNameFailover, portFailover, connectionTimeoutSeconds, readTimeoutSeconds, authorizationURI, sdkVersion, sslSocketFactory, responseType, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public PaymentGatewayOrbital(GenericValue value) {
		paymentGatewayConfigId = (String) value
				.get(Fields.paymentGatewayConfigId.name());
		username = (String) value.get(Fields.username.name());
		connectionPassword = (String) value.get(Fields.connectionPassword
				.name());
		merchantId = (String) value.get(Fields.merchantId.name());
		engineClass = (String) value.get(Fields.engineClass.name());
		hostName = (String) value.get(Fields.hostName.name());
		port = (Long) value.get(Fields.port.name());
		hostNameFailover = (String) value.get(Fields.hostNameFailover.name());
		portFailover = (Long) value.get(Fields.portFailover.name());
		connectionTimeoutSeconds = (Long) value
				.get(Fields.connectionTimeoutSeconds.name());
		readTimeoutSeconds = (Long) value.get(Fields.readTimeoutSeconds.name());
		authorizationURI = (String) value.get(Fields.authorizationURI.name());
		sdkVersion = (String) value.get(Fields.sdkVersion.name());
		sslSocketFactory = (String) value.get(Fields.sslSocketFactory.name());
		responseType = (String) value.get(Fields.responseType.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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