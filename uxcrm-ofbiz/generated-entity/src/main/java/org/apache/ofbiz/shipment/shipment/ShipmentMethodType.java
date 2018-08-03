package org.apache.ofbiz.shipment.shipment;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shipment Method Type
 */
public class ShipmentMethodType implements Serializable {

	public static final long serialVersionUID = 6827579424747431936L;
	public static final String NAME = "ShipmentMethodType";
	/**
	 * Shipment Method Type Id
	 */
	@Getter
	@Setter
	private String shipmentMethodTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
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
		shipmentMethodTypeId, description, sequenceNum, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ShipmentMethodType(GenericValue value) {
		shipmentMethodTypeId = (String) value.get(Fields.shipmentMethodTypeId
				.name());
		description = (String) value.get(Fields.description.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ShipmentMethodType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ShipmentMethodType(value);
	}

	public static List<ShipmentMethodType> fromValues(List<GenericValue> values) {
		List<ShipmentMethodType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ShipmentMethodType(value));
		}
		return entities;
	}
}