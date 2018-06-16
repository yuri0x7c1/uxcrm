package org.apache.ofbiz.shipment.shipment;

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
public class ShipmentGatewayFedex implements Serializable {

	public static final long serialVersionUID = 8112875366325680128L;
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

	public enum Fields {
		shipmentGatewayConfigId, connectUrl, connectSoapUrl, connectTimeout, accessAccountNbr, accessMeterNumber, accessUserKey, accessUserPwd, labelImageType, defaultDropoffType, defaultPackagingType, templateShipment, templateSubscription, rateEstimateTemplate, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ShipmentGatewayFedex(GenericValue value) {
		shipmentGatewayConfigId = (String) value
				.get(Fields.shipmentGatewayConfigId.name());
		connectUrl = (String) value.get(Fields.connectUrl.name());
		connectSoapUrl = (String) value.get(Fields.connectSoapUrl.name());
		connectTimeout = (Long) value.get(Fields.connectTimeout.name());
		accessAccountNbr = (String) value.get(Fields.accessAccountNbr.name());
		accessMeterNumber = (String) value.get(Fields.accessMeterNumber.name());
		accessUserKey = (String) value.get(Fields.accessUserKey.name());
		accessUserPwd = (String) value.get(Fields.accessUserPwd.name());
		labelImageType = (String) value.get(Fields.labelImageType.name());
		defaultDropoffType = (String) value.get(Fields.defaultDropoffType
				.name());
		defaultPackagingType = (String) value.get(Fields.defaultPackagingType
				.name());
		templateShipment = (String) value.get(Fields.templateShipment.name());
		templateSubscription = (String) value.get(Fields.templateSubscription
				.name());
		rateEstimateTemplate = (String) value.get(Fields.rateEstimateTemplate
				.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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