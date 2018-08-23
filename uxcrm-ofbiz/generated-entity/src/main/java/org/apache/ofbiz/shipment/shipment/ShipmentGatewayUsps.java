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
 * Shipment Gateway Usps
 */
@FieldNameConstants
public class ShipmentGatewayUsps implements Serializable {

	public static final long serialVersionUID = 2702153742802490368L;
	public static final String NAME = "ShipmentGatewayUsps";
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
	 * Connect Url Labels
	 */
	@Getter
	@Setter
	private String connectUrlLabels;
	/**
	 * Connect Timeout
	 */
	@Getter
	@Setter
	private Long connectTimeout;
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
	 * Max Estimate Weight
	 */
	@Getter
	@Setter
	private Long maxEstimateWeight;
	/**
	 * Test
	 */
	@Getter
	@Setter
	private String test;
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

	public ShipmentGatewayUsps(GenericValue value) {
		shipmentGatewayConfigId = (String) value
				.get(FIELD_SHIPMENT_GATEWAY_CONFIG_ID);
		connectUrl = (String) value.get(FIELD_CONNECT_URL);
		connectUrlLabels = (String) value.get(FIELD_CONNECT_URL_LABELS);
		connectTimeout = (Long) value.get(FIELD_CONNECT_TIMEOUT);
		accessUserId = (String) value.get(FIELD_ACCESS_USER_ID);
		accessPassword = (String) value.get(FIELD_ACCESS_PASSWORD);
		maxEstimateWeight = (Long) value.get(FIELD_MAX_ESTIMATE_WEIGHT);
		test = (String) value.get(FIELD_TEST);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ShipmentGatewayUsps fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ShipmentGatewayUsps(value);
	}

	public static List<ShipmentGatewayUsps> fromValues(List<GenericValue> values) {
		List<ShipmentGatewayUsps> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ShipmentGatewayUsps(value));
		}
		return entities;
	}
}