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
 * Accommodation Map Type
 */
@FieldNameConstants
public class AccommodationMapType implements Serializable {

	public static final long serialVersionUID = 77162082241337344L;
	public static final String NAME = "AccommodationMapType";
	/**
	 * Accommodation Map Type Id
	 */
	@Getter
	@Setter
	private String accommodationMapTypeId;
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

	public AccommodationMapType(GenericValue value) {
		accommodationMapTypeId = (String) value
				.get(FIELD_ACCOMMODATION_MAP_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static AccommodationMapType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new AccommodationMapType(value);
	}

	public static List<AccommodationMapType> fromValues(
			List<GenericValue> values) {
		List<AccommodationMapType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new AccommodationMapType(value));
		}
		return entities;
	}
}