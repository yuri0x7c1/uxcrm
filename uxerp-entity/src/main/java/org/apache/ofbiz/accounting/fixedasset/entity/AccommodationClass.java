package org.apache.ofbiz.accounting.fixedasset.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Accommodation Class
 */
public class AccommodationClass implements Serializable {

	public static final long serialVersionUID = 6945608475472978944L;
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

	public enum Fields {
		accommodationClassId, parentClassId, description
	}

	public AccommodationClass(GenericValue value) {
		accommodationClassId = (String) value.get(Fields.accommodationClassId
				.name());
		parentClassId = (String) value.get(Fields.parentClassId.name());
		description = (String) value.get(Fields.description.name());
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