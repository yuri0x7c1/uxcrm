package org.apache.ofbiz.common.geo.entity.view;

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

	public static final long serialVersionUID = 4661447266584047616L;
	public static final String NAME = "GeoAssocAndGeoFrom";
	/**
	 * Geo Id
	 */
	@Getter
	@Setter
	private String geoId;
	/**
	 * Geo Type Id
	 */
	@Getter
	@Setter
	private String geoTypeId;
	/**
	 * Geo Name
	 */
	@Getter
	@Setter
	private String geoName;
	/**
	 * Geo Code
	 */
	@Getter
	@Setter
	private String geoCode;
	/**
	 * Geo Sec Code
	 */
	@Getter
	@Setter
	private String geoSecCode;
	/**
	 * Abbreviation
	 */
	@Getter
	@Setter
	private String abbreviation;
	/**
	 * Well Known Text
	 */
	@Getter
	@Setter
	private String wellKnownText;
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
		geoId, geoTypeId, geoName, geoCode, geoSecCode, abbreviation, wellKnownText, geoIdTo, geoAssocTypeId
	}

	public GeoAssocAndGeoFrom(GenericValue value) {
		geoId = (String) value.get(Fields.geoId.name());
		geoTypeId = (String) value.get(Fields.geoTypeId.name());
		geoName = (String) value.get(Fields.geoName.name());
		geoCode = (String) value.get(Fields.geoCode.name());
		geoSecCode = (String) value.get(Fields.geoSecCode.name());
		abbreviation = (String) value.get(Fields.abbreviation.name());
		wellKnownText = (String) value.get(Fields.wellKnownText.name());
		geoIdTo = (String) value.get(Fields.geoIdTo.name());
		geoAssocTypeId = (String) value.get(Fields.geoAssocTypeId.name());
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