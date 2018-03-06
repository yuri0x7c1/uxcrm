package org.apache.ofbiz.common.geo.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Country Capital
 */
public class CountryCapital implements Serializable {

	public static final long serialVersionUID = 3167544970167674880L;
	public static final String NAME = "CountryCapital";
	/**
	 * Country Code
	 */
	@Getter
	@Setter
	private String countryCode;
	/**
	 * Country Capital
	 */
	@Getter
	@Setter
	private String countryCapital;

	public enum Fields {
		countryCode, countryCapital
	}

	public CountryCapital(GenericValue value) {
		countryCode = (String) value.get(Fields.countryCode.name());
		countryCapital = (String) value.get(Fields.countryCapital.name());
	}

	public static CountryCapital fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CountryCapital(value);
	}

	public static List<CountryCapital> fromValues(List<GenericValue> values) {
		List<CountryCapital> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CountryCapital(value));
		}
		return entities;
	}
}