package org.apache.ofbiz.product.facility.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Facility Party
 */
public class FacilityParty implements Serializable {

	public static final long serialVersionUID = 4577896974234831872L;
	public static final String NAME = "FacilityParty";
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
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
		facilityId, partyId, roleTypeId, fromDate, thruDate
	}

	public FacilityParty(GenericValue value) {
		facilityId = (String) value.get(Fields.facilityId.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
	}

	public static FacilityParty fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FacilityParty(value);
	}

	public static List<FacilityParty> fromValues(List<GenericValue> values) {
		List<FacilityParty> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FacilityParty(value));
		}
		return entities;
	}
}