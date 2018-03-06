package org.apache.ofbiz.common.geo.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Geo
 */
public class Geo implements Serializable {

	public static final long serialVersionUID = 7330082937411433472L;
	public static final String NAME = "Geo";
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

	public enum Fields {
		geoId, geoTypeId, geoName, geoCode, geoSecCode, abbreviation, wellKnownText
	}

	public Geo(GenericValue value) {
		geoId = (String) value.get(Fields.geoId.name());
		geoTypeId = (String) value.get(Fields.geoTypeId.name());
		geoName = (String) value.get(Fields.geoName.name());
		geoCode = (String) value.get(Fields.geoCode.name());
		geoSecCode = (String) value.get(Fields.geoSecCode.name());
		abbreviation = (String) value.get(Fields.abbreviation.name());
		wellKnownText = (String) value.get(Fields.wellKnownText.name());
	}

	public static Geo fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new Geo(value);
	}

	public static List<Geo> fromValues(List<GenericValue> values) {
		List<Geo> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new Geo(value));
		}
		return entities;
	}
}