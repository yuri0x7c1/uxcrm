package org.apache.ofbiz.shipment.shipment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shipment Gateway Dhl
 */
public class ShipmentGatewayDhl implements Serializable {

	public static final long serialVersionUID = 3879910658712722432L;
	public static final String NAME = "ShipmentGatewayDhl";
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
	 * Connect Timeout
	 */
	@Getter
	@Setter
	private Long connectTimeout;
	/**
	 * Head Version
	 */
	@Getter
	@Setter
	private String headVersion;
	/**
	 * Head Action
	 */
	@Getter
	@Setter
	private String headAction;
	/**
	 * Access User Id
	 */
	@Getter
	@Setter
	private String accessUserId;
	/**
	 * Access Password
	 */
	@Getter
	@Setter
	private String accessPassword;
	/**
	 * Access Account Nbr
	 */
	@Getter
	@Setter
	private String accessAccountNbr;
	/**
	 * Access Shipping Key
	 */
	@Getter
	@Setter
	private String accessShippingKey;
	/**
	 * Label Image Format
	 */
	@Getter
	@Setter
	private String labelImageFormat;
	/**
	 * Rate Estimate Template
	 */
	@Getter
	@Setter
	private String rateEstimateTemplate;

	public enum Fields {
		shipmentGatewayConfigId, connectUrl, connectTimeout, headVersion, headAction, accessUserId, accessPassword, accessAccountNbr, accessShippingKey, labelImageFormat, rateEstimateTemplate
	}

	public ShipmentGatewayDhl(GenericValue value) {
		shipmentGatewayConfigId = (String) value
				.get(Fields.shipmentGatewayConfigId.name());
		connectUrl = (String) value.get(Fields.connectUrl.name());
		connectTimeout = (Long) value.get(Fields.connectTimeout.name());
		headVersion = (String) value.get(Fields.headVersion.name());
		headAction = (String) value.get(Fields.headAction.name());
		accessUserId = (String) value.get(Fields.accessUserId.name());
		accessPassword = (String) value.get(Fields.accessPassword.name());
		accessAccountNbr = (String) value.get(Fields.accessAccountNbr.name());
		accessShippingKey = (String) value.get(Fields.accessShippingKey.name());
		labelImageFormat = (String) value.get(Fields.labelImageFormat.name());
		rateEstimateTemplate = (String) value.get(Fields.rateEstimateTemplate
				.name());
	}

	public static ShipmentGatewayDhl fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ShipmentGatewayDhl(value);
	}

	public static List<ShipmentGatewayDhl> fromValues(List<GenericValue> values) {
		List<ShipmentGatewayDhl> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ShipmentGatewayDhl(value));
		}
		return entities;
	}
}