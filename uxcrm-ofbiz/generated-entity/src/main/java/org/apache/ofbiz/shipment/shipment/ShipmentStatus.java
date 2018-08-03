package org.apache.ofbiz.shipment.shipment;

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

	public static final long serialVersionUID = 1146284787220245504L;
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
		statusId, shipmentId, statusDate, changeByUserLoginId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ShipmentStatus(GenericValue value) {
		statusId = (String) value.get(Fields.statusId.name());
		shipmentId = (String) value.get(Fields.shipmentId.name());
		statusDate = (Timestamp) value.get(Fields.statusDate.name());
		changeByUserLoginId = (String) value.get(Fields.changeByUserLoginId
				.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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