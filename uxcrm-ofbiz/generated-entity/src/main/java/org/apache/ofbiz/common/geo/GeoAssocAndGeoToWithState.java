package org.apache.ofbiz.common.geo;

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

	public static final long serialVersionUID = 3087096516121166848L;
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

	public enum Fields {
		geoIdFrom, geoAssocTypeId, geoName, geoTypeId, geoId, geoCode, abbreviation, geoSecCode, wellKnownText
	}

	public GeoAssocAndGeoToWithState(GenericValue value) {
		geoIdFrom = (String) value.get(Fields.geoIdFrom.name());
		geoAssocTypeId = (String) value.get(Fields.geoAssocTypeId.name());
		geoName = (String) value.get(Fields.geoName.name());
		geoTypeId = (String) value.get(Fields.geoTypeId.name());
		geoId = (String) value.get(Fields.geoId.name());
		geoCode = (String) value.get(Fields.geoCode.name());
		abbreviation = (String) value.get(Fields.abbreviation.name());
		geoSecCode = (String) value.get(Fields.geoSecCode.name());
		wellKnownText = (String) value.get(Fields.wellKnownText.name());
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