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
 * Shipment Gateway Dhl
 */
@FieldNameConstants
public class ShipmentGatewayDhl implements Serializable {

	public static final long serialVersionUID = 7205564076050978816L;
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

	public ShipmentGatewayDhl(GenericValue value) {
		shipmentGatewayConfigId = (String) value
				.get(FIELD_SHIPMENT_GATEWAY_CONFIG_ID);
		connectUrl = (String) value.get(FIELD_CONNECT_URL);
		connectTimeout = (Long) value.get(FIELD_CONNECT_TIMEOUT);
		headVersion = (String) value.get(FIELD_HEAD_VERSION);
		headAction = (String) value.get(FIELD_HEAD_ACTION);
		accessUserId = (String) value.get(FIELD_ACCESS_USER_ID);
		accessPassword = (String) value.get(FIELD_ACCESS_PASSWORD);
		accessAccountNbr = (String) value.get(FIELD_ACCESS_ACCOUNT_NBR);
		accessShippingKey = (String) value.get(FIELD_ACCESS_SHIPPING_KEY);
		labelImageFormat = (String) value.get(FIELD_LABEL_IMAGE_FORMAT);
		rateEstimateTemplate = (String) value.get(FIELD_RATE_ESTIMATE_TEMPLATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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