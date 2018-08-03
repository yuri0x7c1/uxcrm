package org.apache.ofbiz.common.geo;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Geo Assoc And Geo To
 */
public class GeoAssocAndGeoTo implements Serializable {

	public static final long serialVersionUID = 5969419571671340032L;
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

	public enum Fields {
		geoIdFrom, geoAssocTypeId, geoName, geoTypeId, geoId, geoCode, abbreviation, geoSecCode, wellKnownText
	}

	public GeoAssocAndGeoTo(GenericValue value) {
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