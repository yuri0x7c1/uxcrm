package org.apache.ofbiz.product.facility;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Facility Location
 */
@FieldNameConstants
public class FacilityLocation implements Serializable {

	public static final long serialVersionUID = 8376231950018784256L;
	public static final String NAME = "FacilityLocation";
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
	 * Location Type Enum Id
	 */
	@Getter
	@Setter
	private String locationTypeEnumId;
	/**
	 * Area Id
	 */
	@Getter
	@Setter
	private String areaId;
	/**
	 * Aisle Id
	 */
	@Getter
	@Setter
	private String aisleId;
	/**
	 * Section Id
	 */
	@Getter
	@Setter
	private String sectionId;
	/**
	 * Level Id
	 */
	@Getter
	@Setter
	private String levelId;
	/**
	 * Position Id
	 */
	@Getter
	@Setter
	private String positionId;
	/**
	 * Geo Point Id
	 */
	@Getter
	@Setter
	private String geoPointId;
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

	public FacilityLocation(GenericValue value) {
		facilityId = (String) value.get(FIELD_FACILITY_ID);
		locationSeqId = (String) value.get(FIELD_LOCATION_SEQ_ID);
		locationTypeEnumId = (String) value.get(FIELD_LOCATION_TYPE_ENUM_ID);
		areaId = (String) value.get(FIELD_AREA_ID);
		aisleId = (String) value.get(FIELD_AISLE_ID);
		sectionId = (String) value.get(FIELD_SECTION_ID);
		levelId = (String) value.get(FIELD_LEVEL_ID);
		positionId = (String) value.get(FIELD_POSITION_ID);
		geoPointId = (String) value.get(FIELD_GEO_POINT_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static FacilityLocation fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FacilityLocation(value);
	}

	public static List<FacilityLocation> fromValues(List<GenericValue> values) {
		List<FacilityLocation> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FacilityLocation(value));
		}
		return entities;
	}
}