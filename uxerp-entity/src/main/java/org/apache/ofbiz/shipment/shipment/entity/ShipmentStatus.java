package org.apache.ofbiz.shipment.shipment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shipment Status
 */
public class ShipmentStatus implements Serializable {

	public static final long serialVersionUID = 1904336759415406592L;
	public static final String NAME = "ShipmentStatus";
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Shipment Id
	 */
	@Getter
	@Setter
	private String shipmentId;
	/**
	 * Status Date
	 */
	@Getter
	@Setter
	private Timestamp statusDate;
	/**
	 * Change By User Login Id
	 */
	@Getter
	@Setter
	private String changeByUserLoginId;

	public enum Fields {
		statusId, shipmentId, statusDate, changeByUserLoginId
	}

	public ShipmentStatus(GenericValue value) {
		statusId = (String) value.get(Fields.statusId.name());
		shipmentId = (String) value.get(Fields.shipmentId.name());
		statusDate = (Timestamp) value.get(Fields.statusDate.name());
		changeByUserLoginId = (String) value.get(Fields.changeByUserLoginId
				.name());
	}

	public static ShipmentStatus fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ShipmentStatus(value);
	}

	public static List<ShipmentStatus> fromValues(List<GenericValue> values) {
		List<ShipmentStatus> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ShipmentStatus(value));
		}
		return entities;
	}
}