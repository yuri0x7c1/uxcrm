package org.apache.ofbiz.order.reservations;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Accommodation Spot
 */
@FieldNameConstants
public class AccommodationSpot implements Serializable {

	public static final long serialVersionUID = 7136555893739360256L;
	public static final String NAME = "AccommodationSpot";
	/**
	 * Accommodation Spot Id
	 */
	@Getter
	@Setter
	private String accommodationSpotId;
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
	 * Number Of Spaces
	 */
	@Getter
	@Setter
	private Long numberOfSpaces;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
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

	public AccommodationSpot(GenericValue value) {
		accommodationSpotId = (String) value.get(FIELD_ACCOMMODATION_SPOT_ID);
		accommodationClassId = (String) value.get(FIELD_ACCOMMODATION_CLASS_ID);
		fixedAssetId = (String) value.get(FIELD_FIXED_ASSET_ID);
		numberOfSpaces = (Long) value.get(FIELD_NUMBER_OF_SPACES);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static AccommodationSpot fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new AccommodationSpot(value);
	}

	public static List<AccommodationSpot> fromValues(List<GenericValue> values) {
		List<AccommodationSpot> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new AccommodationSpot(value));
		}
		return entities;
	}
}