package org.apache.ofbiz.manufacturing.mrp;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Mrp Event
 */
public class MrpEvent implements Serializable {

	public static final long serialVersionUID = 8922655188089468928L;
	public static final String NAME = "MrpEvent";
	/**
	 * Mrp Id
	 */
	@Getter
	@Setter
	private String mrpId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Event Date
	 */
	@Getter
	@Setter
	private Timestamp eventDate;
	/**
	 * Mrp Event Type Id
	 */
	@Getter
	@Setter
	private String mrpEventTypeId;
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private Double quantity;
	/**
	 * Event Name
	 */
	@Getter
	@Setter
	private String eventName;
	/**
	 * Is Late
	 */
	@Getter
	@Setter
	private String isLate;
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
		mrpId, productId, eventDate, mrpEventTypeId, facilityId, quantity, eventName, isLate, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public MrpEvent(GenericValue value) {
		mrpId = (String) value.get(Fields.mrpId.name());
		productId = (String) value.get(Fields.productId.name());
		eventDate = (Timestamp) value.get(Fields.eventDate.name());
		mrpEventTypeId = (String) value.get(Fields.mrpEventTypeId.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		quantity = (Double) value.get(Fields.quantity.name());
		eventName = (String) value.get(Fields.eventName.name());
		isLate = (String) value.get(Fields.isLate.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static MrpEvent fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new MrpEvent(value);
	}

	public static List<MrpEvent> fromValues(List<GenericValue> values) {
		List<MrpEvent> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new MrpEvent(value));
		}
		return entities;
	}
}