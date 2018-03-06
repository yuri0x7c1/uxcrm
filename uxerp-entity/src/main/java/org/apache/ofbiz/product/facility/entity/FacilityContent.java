package org.apache.ofbiz.product.facility.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Facility Content
 */
public class FacilityContent implements Serializable {

	public static final long serialVersionUID = 2006597710232288256L;
	public static final String NAME = "FacilityContent";
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Content Id
	 */
	@Getter
	@Setter
	private String contentId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;

	public enum Fields {
		facilityId, contentId, fromDate, thruDate
	}

	public FacilityContent(GenericValue value) {
		facilityId = (String) value.get(Fields.facilityId.name());
		contentId = (String) value.get(Fields.contentId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
	}

	public static FacilityContent fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FacilityContent(value);
	}

	public static List<FacilityContent> fromValues(List<GenericValue> values) {
		List<FacilityContent> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FacilityContent(value));
		}
		return entities;
	}
}