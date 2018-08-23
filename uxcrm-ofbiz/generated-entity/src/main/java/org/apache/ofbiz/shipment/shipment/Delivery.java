package org.apache.ofbiz.shipment.shipment;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Delivery
 */
@FieldNameConstants
public class Delivery implements Serializable {

	public static final long serialVersionUID = 6277297628530402304L;
	public static final String NAME = "Delivery";
	/**
	 * Delivery Id
	 */
	@Getter
	@Setter
	private String deliveryId;
	/**
	 * Origin Facility Id
	 */
	@Getter
	@Setter
	private String originFacilityId;
	/**
	 * Dest Facility Id
	 */
	@Getter
	@Setter
	private String destFacilityId;
	/**
	 * Actual Start Date
	 */
	@Getter
	@Setter
	private Timestamp actualStartDate;
	/**
	 * Actual Arrival Date
	 */
	@Getter
	@Setter
	private Timestamp actualArrivalDate;
	/**
	 * Estimated Start Date
	 */
	@Getter
	@Setter
	private Timestamp estimatedStartDate;
	/**
	 * Estimated Arrival Date
	 */
	@Getter
	@Setter
	private Timestamp estimatedArrivalDate;
	/**
	 * Fixed Asset Id
	 */
	@Getter
	@Setter
	private String fixedAssetId;
	/**
	 * Start Mileage
	 */
	@Getter
	@Setter
	private BigDecimal startMileage;
	/**
	 * End Mileage
	 */
	@Getter
	@Setter
	private BigDecimal endMileage;
	/**
	 * Fuel Used
	 */
	@Getter
	@Setter
	private BigDecimal fuelUsed;
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

	public Delivery(GenericValue value) {
		deliveryId = (String) value.get(FIELD_DELIVERY_ID);
		originFacilityId = (String) value.get(FIELD_ORIGIN_FACILITY_ID);
		destFacilityId = (String) value.get(FIELD_DEST_FACILITY_ID);
		actualStartDate = (Timestamp) value.get(FIELD_ACTUAL_START_DATE);
		actualArrivalDate = (Timestamp) value.get(FIELD_ACTUAL_ARRIVAL_DATE);
		estimatedStartDate = (Timestamp) value.get(FIELD_ESTIMATED_START_DATE);
		estimatedArrivalDate = (Timestamp) value
				.get(FIELD_ESTIMATED_ARRIVAL_DATE);
		fixedAssetId = (String) value.get(FIELD_FIXED_ASSET_ID);
		startMileage = (BigDecimal) value.get(FIELD_START_MILEAGE);
		endMileage = (BigDecimal) value.get(FIELD_END_MILEAGE);
		fuelUsed = (BigDecimal) value.get(FIELD_FUEL_USED);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static Delivery fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new Delivery(value);
	}

	public static List<Delivery> fromValues(List<GenericValue> values) {
		List<Delivery> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new Delivery(value));
		}
		return entities;
	}
}