package org.apache.ofbiz.common.geo.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Geo Assoc And Geo To With State
 */
public class GeoAssocAndGeoToWithState implements Serializable {

	public static final long serialVersionUID = 8068887658164025344L;
	public static final String NAME = "GeoAssocAndGeoToWithState";
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
	 * Geo Assoc Type Id
	 */
	@Getter
	@Setter
	private String geoAssocTypeId;

	public enum Fields {
		geoId, geoTypeId, geoName, geoCode, geoSecCode, abbreviation, wellKnownText, geoAssocTypeId
	}

	public GeoAssocAndGeoToWithState(GenericValue value) {
		geoId = (String) value.get(Fields.geoId.name());
		geoTypeId = (String) value.get(Fields.geoTypeId.name());
		geoName = (String) value.get(Fields.geoName.name());
		geoCode = (String) value.get(Fields.geoCode.name());
		geoSecCode = (String) value.get(Fields.geoSecCode.name());
		abbreviation = (String) value.get(Fields.abbreviation.name());
		wellKnownText = (String) value.get(Fields.wellKnownText.name());
		geoAssocTypeId = (String) value.get(Fields.geoAssocTypeId.name());
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