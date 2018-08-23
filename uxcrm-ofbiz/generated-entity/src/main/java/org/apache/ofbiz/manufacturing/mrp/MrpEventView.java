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
 * Mrp Event View
 */
@FieldNameConstants
public class MrpEventView implements Serializable {

	public static final long serialVersionUID = 279634022271945728L;
	public static final String NAME = "MrpEventView";
	/**
	 * Bill Of Material Level
	 */
	@Getter
	@Setter
	private Long billOfMaterialLevel;
	/**
	 * Mrp Event Type Id
	 */
	@Getter
	@Setter
	private String mrpEventTypeId;
	/**
	 * Mrp Id
	 */
	@Getter
	@Setter
	private String mrpId;
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
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Is Late
	 */
	@Getter
	@Setter
	private String isLate;
	/**
	 * Event Name
	 */
	@Getter
	@Setter
	private String eventName;
	/**
	 * Event Date
	 */
	@Getter
	@Setter
	private Timestamp eventDate;

	public MrpEventView(GenericValue value) {
		billOfMaterialLevel = (Long) value.get(FIELD_BILL_OF_MATERIAL_LEVEL);
		mrpEventTypeId = (String) value.get(FIELD_MRP_EVENT_TYPE_ID);
		mrpId = (String) value.get(FIELD_MRP_ID);
		facilityId = (String) value.get(FIELD_FACILITY_ID);
		quantity = (Double) value.get(FIELD_QUANTITY);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		isLate = (String) value.get(FIELD_IS_LATE);
		eventName = (String) value.get(FIELD_EVENT_NAME);
		eventDate = (Timestamp) value.get(FIELD_EVENT_DATE);
	}

	public static MrpEventView fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new MrpEventView(value);
	}

	public static List<MrpEventView> fromValues(List<GenericValue> values) {
		List<MrpEventView> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new MrpEventView(value));
		}
		return entities;
	}
}