package org.apache.ofbiz.product.facility;

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
public class FacilityLocation implements Serializable {

	public static final long serialVersionUID = 8591728352092449792L;
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

	public enum Fields {
		facilityId, locationSeqId, locationTypeEnumId, areaId, aisleId, sectionId, levelId, positionId, geoPointId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public FacilityLocation(GenericValue value) {
		facilityId = (String) value.get(Fields.facilityId.name());
		locationSeqId = (String) value.get(Fields.locationSeqId.name());
		locationTypeEnumId = (String) value.get(Fields.locationTypeEnumId
				.name());
		areaId = (String) value.get(Fields.areaId.name());
		aisleId = (String) value.get(Fields.aisleId.name());
		sectionId = (String) value.get(Fields.sectionId.name());
		levelId = (String) value.get(Fields.levelId.name());
		positionId = (String) value.get(Fields.positionId.name());
		geoPointId = (String) value.get(Fields.geoPointId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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