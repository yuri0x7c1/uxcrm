package org.apache.ofbiz.accounting.fixedasset;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Accommodation Class
 */
public class AccommodationClass implements Serializable {

	public static final long serialVersionUID = 6297127094610412544L;
	public static final String NAME = "AccommodationClass";
	/**
	 * Accommodation Class Id
	 */
	@Getter
	@Setter
	private String accommodationClassId;
	/**
	 * Parent Class Id
	 */
	@Getter
	@Setter
	private String parentClassId;
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
		accommodationClassId, parentClassId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public AccommodationClass(GenericValue value) {
		accommodationClassId = (String) value.get(Fields.accommodationClassId
				.name());
		parentClassId = (String) value.get(Fields.parentClassId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static AccommodationClass fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new AccommodationClass(value);
	}

	public static List<AccommodationClass> fromValues(List<GenericValue> values) {
		List<AccommodationClass> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new AccommodationClass(value));
		}
		return entities;
	}
}