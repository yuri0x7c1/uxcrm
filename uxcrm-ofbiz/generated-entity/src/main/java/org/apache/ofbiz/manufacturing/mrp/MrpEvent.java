package org.apache.ofbiz.manufacturing.mrp;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class MrpEvent implements Serializable {

	public static final long serialVersionUID = 4315790523043084288L;
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

	public MrpEvent(GenericValue value) {
		mrpId = (String) value.get(FIELD_MRP_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		eventDate = (Timestamp) value.get(FIELD_EVENT_DATE);
		mrpEventTypeId = (String) value.get(FIELD_MRP_EVENT_TYPE_ID);
		facilityId = (String) value.get(FIELD_FACILITY_ID);
		quantity = (Double) value.get(FIELD_QUANTITY);
		eventName = (String) value.get(FIELD_EVENT_NAME);
		isLate = (String) value.get(FIELD_IS_LATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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