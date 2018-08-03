package org.apache.ofbiz.shipment.shipment;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shipment Item Feature
 */
public class ShipmentItemFeature implements Serializable {

	public static final long serialVersionUID = 1673127422258574336L;
	public static final String NAME = "ShipmentItemFeature";
	/**
	 * Shipment Id
	 */
	@Getter
	@Setter
	private String shipmentId;
	/**
	 * Shipment Item Seq Id
	 */
	@Getter
	@Setter
	private String shipmentItemSeqId;
	/**
	 * Product Feature Id
	 */
	@Getter
	@Setter
	private String productFeatureId;
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
		shipmentId, shipmentItemSeqId, productFeatureId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ShipmentItemFeature(GenericValue value) {
		shipmentId = (String) value.get(Fields.shipmentId.name());
		shipmentItemSeqId = (String) value.get(Fields.shipmentItemSeqId.name());
		productFeatureId = (String) value.get(Fields.productFeatureId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ShipmentItemFeature fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ShipmentItemFeature(value);
	}

	public static List<ShipmentItemFeature> fromValues(List<GenericValue> values) {
		List<ShipmentItemFeature> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ShipmentItemFeature(value));
		}
		return entities;
	}
}