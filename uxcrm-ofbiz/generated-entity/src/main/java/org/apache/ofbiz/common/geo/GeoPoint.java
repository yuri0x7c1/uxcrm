package org.apache.ofbiz.common.geo;

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
public class GeoPoint implements Serializable {

	public static final long serialVersionUID = 19674184926043136L;
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

	public enum Fields {
		geoPointId, geoPointTypeEnumId, description, dataSourceId, latitude, longitude, elevation, elevationUomId, information, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public GeoPoint(GenericValue value) {
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
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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