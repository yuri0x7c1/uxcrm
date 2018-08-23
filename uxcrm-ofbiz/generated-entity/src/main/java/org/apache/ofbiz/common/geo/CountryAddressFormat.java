package org.apache.ofbiz.common.geo;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class CountryAddressFormat implements Serializable {

	public static final long serialVersionUID = 5819550582279304192L;
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

	public CountryAddressFormat(GenericValue value) {
		geoId = (String) value.get(FIELD_GEO_ID);
		geoAssocTypeId = (String) value.get(FIELD_GEO_ASSOC_TYPE_ID);
		requireStateProvinceId = (String) value
				.get(FIELD_REQUIRE_STATE_PROVINCE_ID);
		requirePostalCode = (String) value.get(FIELD_REQUIRE_POSTAL_CODE);
		postalCodeRegex = (String) value.get(FIELD_POSTAL_CODE_REGEX);
		hasPostalCodeExt = (String) value.get(FIELD_HAS_POSTAL_CODE_EXT);
		requirePostalCodeExt = (String) value
				.get(FIELD_REQUIRE_POSTAL_CODE_EXT);
		addressFormat = (String) value.get(FIELD_ADDRESS_FORMAT);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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