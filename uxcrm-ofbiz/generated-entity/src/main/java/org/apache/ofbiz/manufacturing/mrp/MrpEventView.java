package org.apache.ofbiz.manufacturing.mrp;

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
public class MrpEventView implements Serializable {

	public static final long serialVersionUID = 253592113995218944L;
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

	public enum Fields {
		billOfMaterialLevel, mrpEventTypeId, mrpId, facilityId, quantity, productId, isLate, eventName, eventDate
	}

	public MrpEventView(GenericValue value) {
		billOfMaterialLevel = (Long) value.get(Fields.billOfMaterialLevel
				.name());
		mrpEventTypeId = (String) value.get(Fields.mrpEventTypeId.name());
		mrpId = (String) value.get(Fields.mrpId.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		quantity = (Double) value.get(Fields.quantity.name());
		productId = (String) value.get(Fields.productId.name());
		isLate = (String) value.get(Fields.isLate.name());
		eventName = (String) value.get(Fields.eventName.name());
		eventDate = (Timestamp) value.get(Fields.eventDate.name());
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