package org.apache.ofbiz.product.facility.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Facility Contact Mech Purpose
 */
public class FacilityContactMechPurpose implements Serializable {

	public static final long serialVersionUID = 6261210424221810688L;
	public static final String NAME = "FacilityContactMechPurpose";
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
	 * Contact Mech Purpose Type Id
	 */
	@Getter
	@Setter
	private String contactMechPurposeTypeId;
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
		facilityId, contactMechId, contactMechPurposeTypeId, fromDate, thruDate
	}

	public FacilityContactMechPurpose(GenericValue value) {
		facilityId = (String) value.get(Fields.facilityId.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
		contactMechPurposeTypeId = (String) value
				.get(Fields.contactMechPurposeTypeId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
	}

	public static FacilityContactMechPurpose fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FacilityContactMechPurpose(value);
	}

	public static List<FacilityContactMechPurpose> fromValues(
			List<GenericValue> values) {
		List<FacilityContactMechPurpose> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FacilityContactMechPurpose(value));
		}
		return entities;
	}
}