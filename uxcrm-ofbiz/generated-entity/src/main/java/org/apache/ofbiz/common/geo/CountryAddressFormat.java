package org.apache.ofbiz.common.geo;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Country Address Format
 */
public class CountryAddressFormat implements Serializable {

	public static final long serialVersionUID = 3103952328272839680L;
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
	/**
	 * Last Updated Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedStamp;
	/**
	 * Last Updated Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedTxStamp;
	/**
	 * Created Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdStamp;
	/**
	 * Created Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdTxStamp;

	public enum Fields {
		geoId, geoAssocTypeId, requireStateProvinceId, requirePostalCode, postalCodeRegex, hasPostalCodeExt, requirePostalCodeExt, addressFormat, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
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
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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