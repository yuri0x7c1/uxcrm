package org.apache.ofbiz.common.geo;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Geo Assoc And Geo From
 */
@FieldNameConstants
public class GeoAssocAndGeoFrom implements Serializable {

	public static final long serialVersionUID = 3411615931055816704L;
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

	public GeoAssocAndGeoFrom(GenericValue value) {
		geoIdTo = (String) value.get(FIELD_GEO_ID_TO);
		geoAssocTypeId = (String) value.get(FIELD_GEO_ASSOC_TYPE_ID);
		geoName = (String) value.get(FIELD_GEO_NAME);
		geoTypeId = (String) value.get(FIELD_GEO_TYPE_ID);
		geoId = (String) value.get(FIELD_GEO_ID);
		geoCode = (String) value.get(FIELD_GEO_CODE);
		abbreviation = (String) value.get(FIELD_ABBREVIATION);
		geoSecCode = (String) value.get(FIELD_GEO_SEC_CODE);
		wellKnownText = (String) value.get(FIELD_WELL_KNOWN_TEXT);
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