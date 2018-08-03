package org.apache.ofbiz.common.geo;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Geo Assoc And Geo From
 */
public class GeoAssocAndGeoFrom implements Serializable {

	public static final long serialVersionUID = 5486516566955844608L;
	public static final String NAME = "GeoAssocAndGeoFrom";
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
	/**
	 * Geo Name
	 */
	@Getter
	@Setter
	private String geoName;
	/**
	 * Geo Type Id
	 */
	@Getter
	@Setter
	private String geoTypeId;
	/**
	 * Geo Id
	 */
	@Getter
	@Setter
	private String geoId;
	/**
	 * Geo Code
	 */
	@Getter
	@Setter
	private String geoCode;
	/**
	 * Abbreviation
	 */
	@Getter
	@Setter
	private String abbreviation;
	/**
	 * Geo Sec Code
	 */
	@Getter
	@Setter
	private String geoSecCode;
	/**
	 * Well Known Text
	 */
	@Getter
	@Setter
	private String wellKnownText;

	public enum Fields {
		geoIdTo, geoAssocTypeId, geoName, geoTypeId, geoId, geoCode, abbreviation, geoSecCode, wellKnownText
	}

	public GeoAssocAndGeoFrom(GenericValue value) {
		geoIdTo = (String) value.get(Fields.geoIdTo.name());
		geoAssocTypeId = (String) value.get(Fields.geoAssocTypeId.name());
		geoName = (String) value.get(Fields.geoName.name());
		geoTypeId = (String) value.get(Fields.geoTypeId.name());
		geoId = (String) value.get(Fields.geoId.name());
		geoCode = (String) value.get(Fields.geoCode.name());
		abbreviation = (String) value.get(Fields.abbreviation.name());
		geoSecCode = (String) value.get(Fields.geoSecCode.name());
		wellKnownText = (String) value.get(Fields.wellKnownText.name());
	}

	public static GeoAssocAndGeoFrom fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new GeoAssocAndGeoFrom(value);
	}

	public static List<GeoAssocAndGeoFrom> fromValues(List<GenericValue> values) {
		List<GeoAssocAndGeoFrom> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GeoAssocAndGeoFrom(value));
		}
		return entities;
	}
}