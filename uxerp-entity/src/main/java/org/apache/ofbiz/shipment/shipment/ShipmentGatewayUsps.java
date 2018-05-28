package org.apache.ofbiz.shipment.shipment;

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
public class ShipmentGatewayUsps implements Serializable {

	public static final long serialVersionUID = 2492436595191967744L;
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

	public enum Fields {
		shipmentGatewayConfigId, connectUrl, connectUrlLabels, connectTimeout, accessUserId, accessPassword, maxEstimateWeight, test, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ShipmentGatewayUsps(GenericValue value) {
		shipmentGatewayConfigId = (String) value
				.get(Fields.shipmentGatewayConfigId.name());
		connectUrl = (String) value.get(Fields.connectUrl.name());
		connectUrlLabels = (String) value.get(Fields.connectUrlLabels.name());
		connectTimeout = (Long) value.get(Fields.connectTimeout.name());
		accessUserId = (String) value.get(Fields.accessUserId.name());
		accessPassword = (String) value.get(Fields.accessPassword.name());
		maxEstimateWeight = (Long) value.get(Fields.maxEstimateWeight.name());
		test = (String) value.get(Fields.test.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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