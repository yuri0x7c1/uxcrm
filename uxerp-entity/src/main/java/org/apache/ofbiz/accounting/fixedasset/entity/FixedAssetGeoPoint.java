package org.apache.ofbiz.accounting.fixedasset.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Fixed Asset Geo Point
 */
public class FixedAssetGeoPoint implements Serializable {

	public static final long serialVersionUID = 3614208422682298368L;
	public static final String NAME = "FixedAssetGeoPoint";
	/**
	 * Fixed Asset Id
	 */
	@Getter
	@Setter
	private String fixedAssetId;
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
		fixedAssetId, geoPointId, fromDate, thruDate
	}

	public FixedAssetGeoPoint(GenericValue value) {
		fixedAssetId = (String) value.get(Fields.fixedAssetId.name());
		geoPointId = (String) value.get(Fields.geoPointId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
	}

	public static FixedAssetGeoPoint fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FixedAssetGeoPoint(value);
	}

	public static List<FixedAssetGeoPoint> fromValues(List<GenericValue> values) {
		List<FixedAssetGeoPoint> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FixedAssetGeoPoint(value));
		}
		return entities;
	}
}