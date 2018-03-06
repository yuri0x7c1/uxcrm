package org.apache.ofbiz.product.facility.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Facility Contact Mech
 */
public class FacilityContactMech implements Serializable {

	public static final long serialVersionUID = 8550074428762575872L;
	public static final String NAME = "FacilityContactMech";
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
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
	/**
	 * Extension
	 */
	@Getter
	@Setter
	private String extension;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;

	public enum Fields {
		facilityId, contactMechId, fromDate, thruDate, extension, comments
	}

	public FacilityContactMech(GenericValue value) {
		facilityId = (String) value.get(Fields.facilityId.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		extension = (String) value.get(Fields.extension.name());
		comments = (String) value.get(Fields.comments.name());
	}

	public static FacilityContactMech fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FacilityContactMech(value);
	}

	public static List<FacilityContactMech> fromValues(List<GenericValue> values) {
		List<FacilityContactMech> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FacilityContactMech(value));
		}
		return entities;
	}
}