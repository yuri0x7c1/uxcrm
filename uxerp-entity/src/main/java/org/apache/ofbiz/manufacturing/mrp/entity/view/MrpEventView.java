package org.apache.ofbiz.manufacturing.mrp.entity.view;

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

	public static final long serialVersionUID = 3735661829216054272L;
	public static final String NAME = "MrpEventView";
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
	 * Bill Of Material Level
	 */
	@Getter
	@Setter
	private Long billOfMaterialLevel;

	public enum Fields {
		mrpId, productId, eventDate, mrpEventTypeId, facilityId, quantity, eventName, isLate, billOfMaterialLevel
	}

	public MrpEventView(GenericValue value) {
		mrpId = (String) value.get(Fields.mrpId.name());
		productId = (String) value.get(Fields.productId.name());
		eventDate = (Timestamp) value.get(Fields.eventDate.name());
		mrpEventTypeId = (String) value.get(Fields.mrpEventTypeId.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		quantity = (Double) value.get(Fields.quantity.name());
		eventName = (String) value.get(Fields.eventName.name());
		isLate = (String) value.get(Fields.isLate.name());
		billOfMaterialLevel = (Long) value.get(Fields.billOfMaterialLevel
				.name());
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