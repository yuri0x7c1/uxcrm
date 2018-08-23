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
 * Carrier Shipment Box Type
 */
@FieldNameConstants
public class CarrierShipmentBoxType implements Serializable {

	public static final long serialVersionUID = 8161350389218551808L;
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

	public CarrierShipmentBoxType(GenericValue value) {
		shipmentBoxTypeId = (String) value.get(FIELD_SHIPMENT_BOX_TYPE_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		packagingTypeCode = (String) value.get(FIELD_PACKAGING_TYPE_CODE);
		oversizeCode = (String) value.get(FIELD_OVERSIZE_CODE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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