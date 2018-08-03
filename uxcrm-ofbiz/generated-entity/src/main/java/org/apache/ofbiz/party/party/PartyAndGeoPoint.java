package org.apache.ofbiz.party.party;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party And Geo Point
 */
public class PartyAndGeoPoint implements Serializable {

	public static final long serialVersionUID = 298511995930160128L;
	public static final String NAME = "PartyAndGeoPoint";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
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
	 * Elevation
	 */
	@Getter
	@Setter
	private BigDecimal elevation;
	/**
	 * Geo Point Type Enum Id
	 */
	@Getter
	@Setter
	private String geoPointTypeEnumId;
	/**
	 * Latitude
	 */
	@Getter
	@Setter
	private String latitude;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Data Source Id
	 */
	@Getter
	@Setter
	private String dataSourceId;
	/**
	 * Elevation Uom Id
	 */
	@Getter
	@Setter
	private String elevationUomId;
	/**
	 * Information
	 */
	@Getter
	@Setter
	private String information;
	/**
	 * Geo Point Id
	 */
	@Getter
	@Setter
	private String geoPointId;
	/**
	 * Longitude
	 */
	@Getter
	@Setter
	private String longitude;

	public enum Fields {
		partyId, fromDate, thruDate, elevation, geoPointTypeEnumId, latitude, description, dataSourceId, elevationUomId, information, geoPointId, longitude
	}

	public PartyAndGeoPoint(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		elevation = (BigDecimal) value.get(Fields.elevation.name());
		geoPointTypeEnumId = (String) value.get(Fields.geoPointTypeEnumId
				.name());
		latitude = (String) value.get(Fields.latitude.name());
		description = (String) value.get(Fields.description.name());
		dataSourceId = (String) value.get(Fields.dataSourceId.name());
		elevationUomId = (String) value.get(Fields.elevationUomId.name());
		information = (String) value.get(Fields.information.name());
		geoPointId = (String) value.get(Fields.geoPointId.name());
		longitude = (String) value.get(Fields.longitude.name());
	}

	public static PartyAndGeoPoint fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyAndGeoPoint(value);
	}

	public static List<PartyAndGeoPoint> fromValues(List<GenericValue> values) {
		List<PartyAndGeoPoint> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyAndGeoPoint(value));
		}
		return entities;
	}
}