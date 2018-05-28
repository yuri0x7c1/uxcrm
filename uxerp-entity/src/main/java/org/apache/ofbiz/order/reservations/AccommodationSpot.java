package org.apache.ofbiz.order.reservations;

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
public class AccommodationSpot implements Serializable {

	public static final long serialVersionUID = 577804107067020288L;
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

	public enum Fields {
		accommodationSpotId, accommodationClassId, fixedAssetId, numberOfSpaces, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public AccommodationSpot(GenericValue value) {
		accommodationSpotId = (String) value.get(Fields.accommodationSpotId
				.name());
		accommodationClassId = (String) value.get(Fields.accommodationClassId
				.name());
		fixedAssetId = (String) value.get(Fields.fixedAssetId.name());
		numberOfSpaces = (Long) value.get(Fields.numberOfSpaces.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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