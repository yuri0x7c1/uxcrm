package org.apache.ofbiz.common.geo.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Country Tele Code
 */
public class CountryTeleCode implements Serializable {

	public static final long serialVersionUID = 7082064283180567552L;
	public static final String NAME = "CountryTeleCode";
	/**
	 * Country Code
	 */
	@Getter
	@Setter
	private String countryCode;
	/**
	 * Tele Code
	 */
	@Getter
	@Setter
	private String teleCode;

	public enum Fields {
		countryCode, teleCode
	}

	public CountryTeleCode(GenericValue value) {
		countryCode = (String) value.get(Fields.countryCode.name());
		teleCode = (String) value.get(Fields.teleCode.name());
	}

	public static CountryTeleCode fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CountryTeleCode(value);
	}

	public static List<CountryTeleCode> fromValues(List<GenericValue> values) {
		List<CountryTeleCode> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CountryTeleCode(value));
		}
		return entities;
	}
}