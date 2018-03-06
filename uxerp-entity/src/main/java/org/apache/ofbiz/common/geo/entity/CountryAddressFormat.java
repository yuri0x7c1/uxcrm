package org.apache.ofbiz.common.geo.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Country Address Format
 */
public class CountryAddressFormat implements Serializable {

	public static final long serialVersionUID = 858565708137374720L;
	public static final String NAME = "CountryAddressFormat";
	/**
	 * Geo Id
	 */
	@Getter
	@Setter
	private String geoId;
	/**
	 * Geo Assoc Type Id
	 */
	@Getter
	@Setter
	private String geoAssocTypeId;
	/**
	 * Require State Province Id
	 */
	@Getter
	@Setter
	private String requireStateProvinceId;
	/**
	 * Require Postal Code
	 */
	@Getter
	@Setter
	private String requirePostalCode;
	/**
	 * Postal Code Regex
	 */
	@Getter
	@Setter
	private String postalCodeRegex;
	/**
	 * Has Postal Code Ext
	 */
	@Getter
	@Setter
	private String hasPostalCodeExt;
	/**
	 * Require Postal Code Ext
	 */
	@Getter
	@Setter
	private String requirePostalCodeExt;
	/**
	 * Address Format
	 */
	@Getter
	@Setter
	private String addressFormat;

	public enum Fields {
		geoId, geoAssocTypeId, requireStateProvinceId, requirePostalCode, postalCodeRegex, hasPostalCodeExt, requirePostalCodeExt, addressFormat
	}

	public CountryAddressFormat(GenericValue value) {
		geoId = (String) value.get(Fields.geoId.name());
		geoAssocTypeId = (String) value.get(Fields.geoAssocTypeId.name());
		requireStateProvinceId = (String) value
				.get(Fields.requireStateProvinceId.name());
		requirePostalCode = (String) value.get(Fields.requirePostalCode.name());
		postalCodeRegex = (String) value.get(Fields.postalCodeRegex.name());
		hasPostalCodeExt = (String) value.get(Fields.hasPostalCodeExt.name());
		requirePostalCodeExt = (String) value.get(Fields.requirePostalCodeExt
				.name());
		addressFormat = (String) value.get(Fields.addressFormat.name());
	}

	public static CountryAddressFormat fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CountryAddressFormat(value);
	}

	public static List<CountryAddressFormat> fromValues(
			List<GenericValue> values) {
		List<CountryAddressFormat> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CountryAddressFormat(value));
		}
		return entities;
	}
}