package org.apache.ofbiz.accounting.fixedasset;

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
public class AccommodationMapType implements Serializable {

	public static final long serialVersionUID = 5192299286253268992L;
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

	public enum Fields {
		accommodationMapTypeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public AccommodationMapType(GenericValue value) {
		accommodationMapTypeId = (String) value
				.get(Fields.accommodationMapTypeId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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