package org.apache.ofbiz.common.geo;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Geo Assoc And Geo To
 */
@FieldNameConstants
public class GeoAssocAndGeoTo implements Serializable {

	public static final long serialVersionUID = 1605888990279467008L;
	public static final String NAME = "GeoAssocAndGeoTo";
	/**
	 * Geo Id From
	 */
	@Getter
	@Setter
	private String geoIdFrom;
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

	public GeoAssocAndGeoTo(GenericValue value) {
		geoIdFrom = (String) value.get(FIELD_GEO_ID_FROM);
		geoAssocTypeId = (String) value.get(FIELD_GEO_ASSOC_TYPE_ID);
		geoName = (String) value.get(FIELD_GEO_NAME);
		geoTypeId = (String) value.get(FIELD_GEO_TYPE_ID);
		geoId = (String) value.get(FIELD_GEO_ID);
		geoCode = (String) value.get(FIELD_GEO_CODE);
		abbreviation = (String) value.get(FIELD_ABBREVIATION);
		geoSecCode = (String) value.get(FIELD_GEO_SEC_CODE);
		wellKnownText = (String) value.get(FIELD_WELL_KNOWN_TEXT);
	}

	public static GeoAssocAndGeoTo fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new GeoAssocAndGeoTo(value);
	}

	public static List<GeoAssocAndGeoTo> fromValues(List<GenericValue> values) {
		List<GeoAssocAndGeoTo> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GeoAssocAndGeoTo(value));
		}
		return entities;
	}
}