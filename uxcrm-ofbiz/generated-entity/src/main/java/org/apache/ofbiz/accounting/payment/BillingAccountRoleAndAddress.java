package org.apache.ofbiz.accounting.payment;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Billing Account Role And Address
 */
@FieldNameConstants
public class BillingAccountRoleAndAddress implements Serializable {

	public static final long serialVersionUID = 3462132535654998016L;
	public static final String NAME = "BillingAccountRoleAndAddress";
	/**
	 * Pcm From Date
	 */
	@Getter
	@Setter
	private Timestamp pcmFromDate;
	/**
	 * Pcm Thru Date
	 */
	@Getter
	@Setter
	private Timestamp pcmThruDate;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * Billing Account Id
	 */
	@Getter
	@Setter
	private String billingAccountId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Country Geo Id
	 */
	@Getter
	@Setter
	private String countryGeoId;
	/**
	 * House Number Ext
	 */
	@Getter
	@Setter
	private String houseNumberExt;
	/**
	 * Address 2
	 */
	@Getter
	@Setter
	private String address2;
	/**
	 * City
	 */
	@Getter
	@Setter
	private String city;
	/**
	 * Address 1
	 */
	@Getter
	@Setter
	private String address1;
	/**
	 * Postal Code
	 */
	@Getter
	@Setter
	private String postalCode;
	/**
	 * Postal Code Geo Id
	 */
	@Getter
	@Setter
	private String postalCodeGeoId;
	/**
	 * House Number
	 */
	@Getter
	@Setter
	private Long houseNumber;
	/**
	 * Postal Code Ext
	 */
	@Getter
	@Setter
	private String postalCodeExt;
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
	/**
	 * Attn Name
	 */
	@Getter
	@Setter
	private String attnName;
	/**
	 * Directions
	 */
	@Getter
	@Setter
	private String directions;
	/**
	 * County Geo Id
	 */
	@Getter
	@Setter
	private String countyGeoId;
	/**
	 * To Name
	 */
	@Getter
	@Setter
	private String toName;
	/**
	 * City Geo Id
	 */
	@Getter
	@Setter
	private String cityGeoId;
	/**
	 * Municipality Geo Id
	 */
	@Getter
	@Setter
	private String municipalityGeoId;
	/**
	 * State Province Geo Id
	 */
	@Getter
	@Setter
	private String stateProvinceGeoId;
	/**
	 * Geo Point Id
	 */
	@Getter
	@Setter
	private String geoPointId;

	public BillingAccountRoleAndAddress(GenericValue value) {
		pcmFromDate = (Timestamp) value.get(FIELD_PCM_FROM_DATE);
		pcmThruDate = (Timestamp) value.get(FIELD_PCM_THRU_DATE);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		billingAccountId = (String) value.get(FIELD_BILLING_ACCOUNT_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		countryGeoId = (String) value.get(FIELD_COUNTRY_GEO_ID);
		houseNumberExt = (String) value.get(FIELD_HOUSE_NUMBER_EXT);
		address2 = (String) value.get(FIELD_ADDRESS2);
		city = (String) value.get(FIELD_CITY);
		address1 = (String) value.get(FIELD_ADDRESS1);
		postalCode = (String) value.get(FIELD_POSTAL_CODE);
		postalCodeGeoId = (String) value.get(FIELD_POSTAL_CODE_GEO_ID);
		houseNumber = (Long) value.get(FIELD_HOUSE_NUMBER);
		postalCodeExt = (String) value.get(FIELD_POSTAL_CODE_EXT);
		contactMechId = (String) value.get(FIELD_CONTACT_MECH_ID);
		attnName = (String) value.get(FIELD_ATTN_NAME);
		directions = (String) value.get(FIELD_DIRECTIONS);
		countyGeoId = (String) value.get(FIELD_COUNTY_GEO_ID);
		toName = (String) value.get(FIELD_TO_NAME);
		cityGeoId = (String) value.get(FIELD_CITY_GEO_ID);
		municipalityGeoId = (String) value.get(FIELD_MUNICIPALITY_GEO_ID);
		stateProvinceGeoId = (String) value.get(FIELD_STATE_PROVINCE_GEO_ID);
		geoPointId = (String) value.get(FIELD_GEO_POINT_ID);
	}

	public static BillingAccountRoleAndAddress fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new BillingAccountRoleAndAddress(value);
	}

	public static List<BillingAccountRoleAndAddress> fromValues(
			List<GenericValue> values) {
		List<BillingAccountRoleAndAddress> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new BillingAccountRoleAndAddress(value));
		}
		return entities;
	}
}