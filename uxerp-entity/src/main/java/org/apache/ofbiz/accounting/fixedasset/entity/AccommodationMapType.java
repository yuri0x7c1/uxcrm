package org.apache.ofbiz.accounting.fixedasset.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Accommodation Map Type
 */
public class AccommodationMapType implements Serializable {

	public static final long serialVersionUID = 7874706421745187840L;
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

	public enum Fields {
		accommodationMapTypeId, description
	}

	public AccommodationMapType(GenericValue value) {
		accommodationMapTypeId = (String) value
				.get(Fields.accommodationMapTypeId.name());
		description = (String) value.get(Fields.description.name());
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