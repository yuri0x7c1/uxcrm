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
 * Accommodation Map
 */
@FieldNameConstants
public class AccommodationMap implements Serializable {

	public static final long serialVersionUID = 8828395381034423296L;
	public static final String NAME = "AccommodationMap";
	/**
	 * Accommodation Map Id
	 */
	@Getter
	@Setter
	private String accommodationMapId;
	/**
	 * Accommodation Class Id
	 */
	@Getter
	@Setter
	private String accommodationClassId;
	/**
	 * Fixed Asset Id
	 */
	@Getter
	@Setter
	private String fixedAssetId;
	/**
	 * Accommodation Map Type Id
	 */
	@Getter
	@Setter
	private String accommodationMapTypeId;
	/**
	 * Number Of Spaces
	 */
	@Getter
	@Setter
	private Long numberOfSpaces;
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

	public AccommodationMap(GenericValue value) {
		accommodationMapId = (String) value.get(FIELD_ACCOMMODATION_MAP_ID);
		accommodationClassId = (String) value.get(FIELD_ACCOMMODATION_CLASS_ID);
		fixedAssetId = (String) value.get(FIELD_FIXED_ASSET_ID);
		accommodationMapTypeId = (String) value
				.get(FIELD_ACCOMMODATION_MAP_TYPE_ID);
		numberOfSpaces = (Long) value.get(FIELD_NUMBER_OF_SPACES);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static AccommodationMap fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new AccommodationMap(value);
	}

	public static List<AccommodationMap> fromValues(List<GenericValue> values) {
		List<AccommodationMap> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new AccommodationMap(value));
		}
		return entities;
	}
}