package org.apache.ofbiz.party.party;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class PartyAndGeoPoint implements Serializable {

	public static final long serialVersionUID = 3110469797308552192L;
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

	public PartyAndGeoPoint(GenericValue value) {
		partyId = (String) value.get(FIELD_PARTY_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		elevation = (BigDecimal) value.get(FIELD_ELEVATION);
		geoPointTypeEnumId = (String) value.get(FIELD_GEO_POINT_TYPE_ENUM_ID);
		latitude = (String) value.get(FIELD_LATITUDE);
		description = (String) value.get(FIELD_DESCRIPTION);
		dataSourceId = (String) value.get(FIELD_DATA_SOURCE_ID);
		elevationUomId = (String) value.get(FIELD_ELEVATION_UOM_ID);
		information = (String) value.get(FIELD_INFORMATION);
		geoPointId = (String) value.get(FIELD_GEO_POINT_ID);
		longitude = (String) value.get(FIELD_LONGITUDE);
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