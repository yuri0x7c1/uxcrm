package org.apache.ofbiz.product.facility.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Facility Location And Geo Point
 */
public class FacilityLocationAndGeoPoint implements Serializable {

	public static final long serialVersionUID = 383506009767194624L;
	public static final String NAME = "FacilityLocationAndGeoPoint";
	/**
	 * Geo Point Id
	 */
	@Getter
	@Setter
	private String geoPointId;
	/**
	 * Geo Point Type Enum Id
	 */
	@Getter
	@Setter
	private String geoPointTypeEnumId;
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
	 * Latitude
	 */
	@Getter
	@Setter
	private String latitude;
	/**
	 * Longitude
	 */
	@Getter
	@Setter
	private String longitude;
	/**
	 * Elevation
	 */
	@Getter
	@Setter
	private BigDecimal elevation;
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

	public enum Fields {
		geoPointId, geoPointTypeEnumId, description, dataSourceId, latitude, longitude, elevation, elevationUomId, information, facilityId, locationSeqId, fromDate, thruDate
	}

	public FacilityLocationAndGeoPoint(GenericValue value) {
		geoPointId = (String) value.get(Fields.geoPointId.name());
		geoPointTypeEnumId = (String) value.get(Fields.geoPointTypeEnumId
				.name());
		description = (String) value.get(Fields.description.name());
		dataSourceId = (String) value.get(Fields.dataSourceId.name());
		latitude = (String) value.get(Fields.latitude.name());
		longitude = (String) value.get(Fields.longitude.name());
		elevation = (BigDecimal) value.get(Fields.elevation.name());
		elevationUomId = (String) value.get(Fields.elevationUomId.name());
		information = (String) value.get(Fields.information.name());
		facilityId = (String) value.get(Fields.facilityId.name());
		locationSeqId = (String) value.get(Fields.locationSeqId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
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