package org.apache.ofbiz.common.geo.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Geo Assoc
 */
public class GeoAssoc implements Serializable {

	public static final long serialVersionUID = 6045172611437659136L;
	public static final String NAME = "GeoAssoc";
	/**
	 * Geo Id
	 */
	@Getter
	@Setter
	private String geoId;
	/**
	 * Geo Id To
	 */
	@Getter
	@Setter
	private String geoIdTo;
	/**
	 * Geo Assoc Type Id
	 */
	@Getter
	@Setter
	private String geoAssocTypeId;

	public enum Fields {
		geoId, geoIdTo, geoAssocTypeId
	}

	public GeoAssoc(GenericValue value) {
		geoId = (String) value.get(Fields.geoId.name());
		geoIdTo = (String) value.get(Fields.geoIdTo.name());
		geoAssocTypeId = (String) value.get(Fields.geoAssocTypeId.name());
	}

	public static GeoAssoc fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new GeoAssoc(value);
	}

	public static List<GeoAssoc> fromValues(List<GenericValue> values) {
		List<GeoAssoc> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GeoAssoc(value));
		}
		return entities;
	}
}