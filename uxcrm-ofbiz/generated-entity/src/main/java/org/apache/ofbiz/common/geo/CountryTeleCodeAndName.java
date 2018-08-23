package org.apache.ofbiz.common.geo;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Country Tele Code And Name
 */
@FieldNameConstants
public class CountryTeleCodeAndName implements Serializable {

	public static final long serialVersionUID = 8389382363914057728L;
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

	public CountryTeleCodeAndName(GenericValue value) {
		teleCode = (String) value.get(FIELD_TELE_CODE);
		countryCode = (String) value.get(FIELD_COUNTRY_CODE);
		countryName = (String) value.get(FIELD_COUNTRY_NAME);
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