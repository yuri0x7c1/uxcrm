package org.apache.ofbiz.common.geo.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Geo Type
 */
public class GeoType implements Serializable {

	public static final long serialVersionUID = 5986835073491005440L;
	public static final String NAME = "GeoType";
	/**
	 * Geo Type Id
	 */
	@Getter
	@Setter
	private String geoTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Has Table
	 */
	@Getter
	@Setter
	private String hasTable;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		geoTypeId, parentTypeId, hasTable, description
	}

	public GeoType(GenericValue value) {
		geoTypeId = (String) value.get(Fields.geoTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static GeoType fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new GeoType(value);
	}

	public static List<GeoType> fromValues(List<GenericValue> values) {
		List<GeoType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GeoType(value));
		}
		return entities;
	}
}