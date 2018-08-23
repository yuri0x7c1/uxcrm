package org.apache.ofbiz.product.facility;

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
 * Facility Location And Geo Point
 */
@FieldNameConstants
public class FacilityLocationAndGeoPoint implements Serializable {

	public static final long serialVersionUID = 8477778853898934272L;
	public static final String NAME = "FacilityLocationAndGeoPoint";
	/**
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;
	/**
	 * Location Seq Id
	 */
	@Getter
	@Setter
	private String locationSeqId;
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

	public FacilityLocationAndGeoPoint(GenericValue value) {
		facilityId = (String) value.get(FIELD_FACILITY_ID);
		locationSeqId = (String) value.get(FIELD_LOCATION_SEQ_ID);
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

	public static FacilityLocationAndGeoPoint fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FacilityLocationAndGeoPoint(value);
	}

	public static List<FacilityLocationAndGeoPoint> fromValues(
			List<GenericValue> values) {
		List<FacilityLocationAndGeoPoint> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FacilityLocationAndGeoPoint(value));
		}
		return entities;
	}
}