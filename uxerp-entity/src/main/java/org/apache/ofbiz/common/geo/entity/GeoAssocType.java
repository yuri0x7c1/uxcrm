package org.apache.ofbiz.common.geo.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Geo Assoc Type
 */
public class GeoAssocType implements Serializable {

	public static final long serialVersionUID = 8953856328442517504L;
	public static final String NAME = "GeoAssocType";
	/**
	 * Geo Assoc Type Id
	 */
	@Getter
	@Setter
	private String geoAssocTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		geoAssocTypeId, description
	}

	public GeoAssocType(GenericValue value) {
		geoAssocTypeId = (String) value.get(Fields.geoAssocTypeId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static GeoAssocType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new GeoAssocType(value);
	}

	public static List<GeoAssocType> fromValues(List<GenericValue> values) {
		List<GeoAssocType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GeoAssocType(value));
		}
		return entities;
	}
}