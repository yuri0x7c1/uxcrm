package org.apache.ofbiz.accounting.fixedasset;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class FixedAssetGeoPoint implements Serializable {

	public static final long serialVersionUID = 5692604658587920384L;
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

	public FixedAssetGeoPoint(GenericValue value) {
		fixedAssetId = (String) value.get(FIELD_FIXED_ASSET_ID);
		geoPointId = (String) value.get(FIELD_GEO_POINT_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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