package org.apache.ofbiz.shipment.shipment;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Carrier Shipment Box Type
 */
public class CarrierShipmentBoxType implements Serializable {

	public static final long serialVersionUID = 5184545558049252352L;
	public static final String NAME = "CarrierShipmentBoxType";
	/**
	 * Shipment Box Type Id
	 */
	@Getter
	@Setter
	private String shipmentBoxTypeId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Packaging Type Code
	 */
	@Getter
	@Setter
	private String packagingTypeCode;
	/**
	 * Oversize Code
	 */
	@Getter
	@Setter
	private String oversizeCode;
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
		shipmentBoxTypeId, partyId, packagingTypeCode, oversizeCode, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public CarrierShipmentBoxType(GenericValue value) {
		shipmentBoxTypeId = (String) value.get(Fields.shipmentBoxTypeId.name());
		partyId = (String) value.get(Fields.partyId.name());
		packagingTypeCode = (String) value.get(Fields.packagingTypeCode.name());
		oversizeCode = (String) value.get(Fields.oversizeCode.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static CarrierShipmentBoxType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CarrierShipmentBoxType(value);
	}

	public static List<CarrierShipmentBoxType> fromValues(
			List<GenericValue> values) {
		List<CarrierShipmentBoxType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CarrierShipmentBoxType(value));
		}
		return entities;
	}
}