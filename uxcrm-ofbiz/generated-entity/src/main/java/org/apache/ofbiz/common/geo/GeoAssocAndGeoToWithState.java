package org.apache.ofbiz.common.geo;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Geo Assoc And Geo To With State
 */
@FieldNameConstants
public class GeoAssocAndGeoToWithState implements Serializable {

	public static final long serialVersionUID = 5867222773397635072L;
	public static final String NAME = "GeoAssocAndGeoToWithState";
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

	public GeoAssocAndGeoToWithState(GenericValue value) {
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

	public static GeoAssocAndGeoToWithState fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new GeoAssocAndGeoToWithState(value);
	}

	public static List<GeoAssocAndGeoToWithState> fromValues(
			List<GenericValue> values) {
		List<GeoAssocAndGeoToWithState> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GeoAssocAndGeoToWithState(value));
		}
		return entities;
	}
}