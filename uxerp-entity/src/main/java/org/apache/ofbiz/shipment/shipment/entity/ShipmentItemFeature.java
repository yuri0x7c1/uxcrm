package org.apache.ofbiz.shipment.shipment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shipment Item Feature
 */
public class ShipmentItemFeature implements Serializable {

	public static final long serialVersionUID = 8347804086230513664L;
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

	public enum Fields {
		shipmentId, shipmentItemSeqId, productFeatureId
	}

	public ShipmentItemFeature(GenericValue value) {
		shipmentId = (String) value.get(Fields.shipmentId.name());
		shipmentItemSeqId = (String) value.get(Fields.shipmentItemSeqId.name());
		productFeatureId = (String) value.get(Fields.productFeatureId.name());
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