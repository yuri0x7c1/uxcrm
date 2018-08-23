package org.apache.ofbiz.shipment.shipment;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shipment Gateway Fedex
 */
@FieldNameConstants
public class ShipmentGatewayFedex implements Serializable {

	public static final long serialVersionUID = 8437784856915689472L;
	public static final String NAME = "ShipmentGatewayFedex";
	/**
	 * Shipment Gateway Config Id
	 */
	@Getter
	@Setter
	private String shipmentGatewayConfigId;
	/**
	 * Connect Url
	 */
	@Getter
	@Setter
	private String connectUrl;
	/**
	 * Connect Soap Url
	 */
	@Getter
	@Setter
	private String connectSoapUrl;
	/**
	 * Connect Timeout
	 */
	@Getter
	@Setter
	private Long connectTimeout;
	/**
	 * Access Account Nbr
	 */
	@Getter
	@Setter
	private String accessAccountNbr;
	/**
	 * Access Meter Number
	 */
	@Getter
	@Setter
	private String accessMeterNumber;
	/**
	 * Access User Key
	 */
	@Getter
	@Setter
	private String accessUserKey;
	/**
	 * Access User Pwd
	 */
	@Getter
	@Setter
	private String accessUserPwd;
	/**
	 * Label Image Type
	 */
	@Getter
	@Setter
	private String labelImageType;
	/**
	 * Default Dropoff Type
	 */
	@Getter
	@Setter
	private String defaultDropoffType;
	/**
	 * Default Packaging Type
	 */
	@Getter
	@Setter
	private String defaultPackagingType;
	/**
	 * Template Shipment
	 */
	@Getter
	@Setter
	private String templateShipment;
	/**
	 * Template Subscription
	 */
	@Getter
	@Setter
	private String templateSubscription;
	/**
	 * Rate Estimate Template
	 */
	@Getter
	@Setter
	private String rateEstimateTemplate;
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

	public ShipmentGatewayFedex(GenericValue value) {
		shipmentGatewayConfigId = (String) value
				.get(FIELD_SHIPMENT_GATEWAY_CONFIG_ID);
		connectUrl = (String) value.get(FIELD_CONNECT_URL);
		connectSoapUrl = (String) value.get(FIELD_CONNECT_SOAP_URL);
		connectTimeout = (Long) value.get(FIELD_CONNECT_TIMEOUT);
		accessAccountNbr = (String) value.get(FIELD_ACCESS_ACCOUNT_NBR);
		accessMeterNumber = (String) value.get(FIELD_ACCESS_METER_NUMBER);
		accessUserKey = (String) value.get(FIELD_ACCESS_USER_KEY);
		accessUserPwd = (String) value.get(FIELD_ACCESS_USER_PWD);
		labelImageType = (String) value.get(FIELD_LABEL_IMAGE_TYPE);
		defaultDropoffType = (String) value.get(FIELD_DEFAULT_DROPOFF_TYPE);
		defaultPackagingType = (String) value.get(FIELD_DEFAULT_PACKAGING_TYPE);
		templateShipment = (String) value.get(FIELD_TEMPLATE_SHIPMENT);
		templateSubscription = (String) value.get(FIELD_TEMPLATE_SUBSCRIPTION);
		rateEstimateTemplate = (String) value.get(FIELD_RATE_ESTIMATE_TEMPLATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ShipmentGatewayFedex fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ShipmentGatewayFedex(value);
	}

	public static List<ShipmentGatewayFedex> fromValues(
			List<GenericValue> values) {
		List<ShipmentGatewayFedex> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ShipmentGatewayFedex(value));
		}
		return entities;
	}
}