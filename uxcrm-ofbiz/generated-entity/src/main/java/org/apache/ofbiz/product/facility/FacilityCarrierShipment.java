package org.apache.ofbiz.product.facility;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Facility Carrier Shipment
 */
@FieldNameConstants
public class FacilityCarrierShipment implements Serializable {

	public static final long serialVersionUID = 8239223888096652288L;
	public static final String NAME = "FacilityCarrierShipment";
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * Shipment Method Type Id
	 */
	@Getter
	@Setter
	private String shipmentMethodTypeId;
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

	public FacilityCarrierShipment(GenericValue value) {
		facilityId = (String) value.get(FIELD_FACILITY_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		shipmentMethodTypeId = (String) value
				.get(FIELD_SHIPMENT_METHOD_TYPE_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static FacilityCarrierShipment fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FacilityCarrierShipment(value);
	}

	public static List<FacilityCarrierShipment> fromValues(
			List<GenericValue> values) {
		List<FacilityCarrierShipment> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FacilityCarrierShipment(value));
		}
		return entities;
	}
}