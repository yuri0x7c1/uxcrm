package org.apache.ofbiz.accounting.fixedasset.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Accommodation Map
 */
public class AccommodationMap implements Serializable {

	public static final long serialVersionUID = 6106044228666783744L;
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

	public enum Fields {
		accommodationMapId, accommodationClassId, fixedAssetId, accommodationMapTypeId, numberOfSpaces
	}

	public AccommodationMap(GenericValue value) {
		accommodationMapId = (String) value.get(Fields.accommodationMapId
				.name());
		accommodationClassId = (String) value.get(Fields.accommodationClassId
				.name());
		fixedAssetId = (String) value.get(Fields.fixedAssetId.name());
		accommodationMapTypeId = (String) value
				.get(Fields.accommodationMapTypeId.name());
		numberOfSpaces = (Long) value.get(Fields.numberOfSpaces.name());
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