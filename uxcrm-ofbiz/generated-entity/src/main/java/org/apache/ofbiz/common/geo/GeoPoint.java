package org.apache.ofbiz.common.geo;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Geo Point
 */
@FieldNameConstants
public class GeoPoint implements Serializable {

	public static final long serialVersionUID = 1416359400032303104L;
	public static final String NAME = "GeoPoint";
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
	 * Last Updated Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedStamp;
	/**
	 * Last Updated Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedTxStamp;
	/**
	 * Created Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdStamp;
	/**
	 * Created Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdTxStamp;

	public GeoPoint(GenericValue value) {
		geoPointId = (String) value.get(FIELD_GEO_POINT_ID);
		geoPointTypeEnumId = (String) value.get(FIELD_GEO_POINT_TYPE_ENUM_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		dataSourceId = (String) value.get(FIELD_DATA_SOURCE_ID);
		latitude = (String) value.get(FIELD_LATITUDE);
		longitude = (String) value.get(FIELD_LONGITUDE);
		elevation = (BigDecimal) value.get(FIELD_ELEVATION);
		elevationUomId = (String) value.get(FIELD_ELEVATION_UOM_ID);
		information = (String) value.get(FIELD_INFORMATION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static GeoPoint fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new GeoPoint(value);
	}

	public static List<GeoPoint> fromValues(List<GenericValue> values) {
		List<GeoPoint> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GeoPoint(value));
		}
		return entities;
	}
}