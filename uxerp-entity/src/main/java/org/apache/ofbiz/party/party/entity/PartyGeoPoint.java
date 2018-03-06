package org.apache.ofbiz.party.party.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Geo Point
 */
public class PartyGeoPoint implements Serializable {

	public static final long serialVersionUID = 6188887756286156800L;
	public static final String NAME = "PartyGeoPoint";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Geo Point Id
	 */
	@Getter
	@Setter
	private String geoPointId;
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
		partyId, geoPointId, fromDate, thruDate
	}

	public PartyGeoPoint(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		geoPointId = (String) value.get(Fields.geoPointId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
	}

	public static PartyGeoPoint fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyGeoPoint(value);
	}

	public static List<PartyGeoPoint> fromValues(List<GenericValue> values) {
		List<PartyGeoPoint> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyGeoPoint(value));
		}
		return entities;
	}
}