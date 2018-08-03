package org.apache.ofbiz.shipment.shipment;

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
public class Delivery implements Serializable {

	public static final long serialVersionUID = 1243854612783351808L;
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

	public enum Fields {
		deliveryId, originFacilityId, destFacilityId, actualStartDate, actualArrivalDate, estimatedStartDate, estimatedArrivalDate, fixedAssetId, startMileage, endMileage, fuelUsed, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public Delivery(GenericValue value) {
		deliveryId = (String) value.get(Fields.deliveryId.name());
		originFacilityId = (String) value.get(Fields.originFacilityId.name());
		destFacilityId = (String) value.get(Fields.destFacilityId.name());
		actualStartDate = (Timestamp) value.get(Fields.actualStartDate.name());
		actualArrivalDate = (Timestamp) value.get(Fields.actualArrivalDate
				.name());
		estimatedStartDate = (Timestamp) value.get(Fields.estimatedStartDate
				.name());
		estimatedArrivalDate = (Timestamp) value
				.get(Fields.estimatedArrivalDate.name());
		fixedAssetId = (String) value.get(Fields.fixedAssetId.name());
		startMileage = (BigDecimal) value.get(Fields.startMileage.name());
		endMileage = (BigDecimal) value.get(Fields.endMileage.name());
		fuelUsed = (BigDecimal) value.get(Fields.fuelUsed.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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