package org.apache.ofbiz.common.geo;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Country Tele Code And Name
 */
public class CountryTeleCodeAndName implements Serializable {

	public static final long serialVersionUID = 272700613146916864L;
	public static final String NAME = "CountryTeleCodeAndName";
	/**
	 * Tele Code
	 */
	@Getter
	@Setter
	private String teleCode;
	/**
	 * Country Code
	 */
	@Getter
	@Setter
	private String countryCode;
	/**
	 * Country Name
	 */
	@Getter
	@Setter
	private String countryName;

	public enum Fields {
		teleCode, countryCode, countryName
	}

	public CountryTeleCodeAndName(GenericValue value) {
		teleCode = (String) value.get(Fields.teleCode.name());
		countryCode = (String) value.get(Fields.countryCode.name());
		countryName = (String) value.get(Fields.countryName.name());
	}

	public static CountryTeleCodeAndName fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CountryTeleCodeAndName(value);
	}

	public static List<CountryTeleCodeAndName> fromValues(
			List<GenericValue> values) {
		List<CountryTeleCodeAndName> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CountryTeleCodeAndName(value));
		}
		return entities;
	}
}