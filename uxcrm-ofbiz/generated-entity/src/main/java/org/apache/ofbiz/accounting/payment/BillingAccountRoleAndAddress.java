package org.apache.ofbiz.accounting.payment;

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
public class BillingAccountRoleAndAddress implements Serializable {

	public static final long serialVersionUID = 3722508990510989312L;
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

	public enum Fields {
		pcmFromDate, pcmThruDate, fromDate, roleTypeId, billingAccountId, partyId, thruDate, countryGeoId, houseNumberExt, address2, city, address1, postalCode, postalCodeGeoId, houseNumber, postalCodeExt, contactMechId, attnName, directions, countyGeoId, toName, cityGeoId, municipalityGeoId, stateProvinceGeoId, geoPointId
	}

	public BillingAccountRoleAndAddress(GenericValue value) {
		pcmFromDate = (Timestamp) value.get(Fields.pcmFromDate.name());
		pcmThruDate = (Timestamp) value.get(Fields.pcmThruDate.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		billingAccountId = (String) value.get(Fields.billingAccountId.name());
		partyId = (String) value.get(Fields.partyId.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		countryGeoId = (String) value.get(Fields.countryGeoId.name());
		houseNumberExt = (String) value.get(Fields.houseNumberExt.name());
		address2 = (String) value.get(Fields.address2.name());
		city = (String) value.get(Fields.city.name());
		address1 = (String) value.get(Fields.address1.name());
		postalCode = (String) value.get(Fields.postalCode.name());
		postalCodeGeoId = (String) value.get(Fields.postalCodeGeoId.name());
		houseNumber = (Long) value.get(Fields.houseNumber.name());
		postalCodeExt = (String) value.get(Fields.postalCodeExt.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
		attnName = (String) value.get(Fields.attnName.name());
		directions = (String) value.get(Fields.directions.name());
		countyGeoId = (String) value.get(Fields.countyGeoId.name());
		toName = (String) value.get(Fields.toName.name());
		cityGeoId = (String) value.get(Fields.cityGeoId.name());
		municipalityGeoId = (String) value.get(Fields.municipalityGeoId.name());
		stateProvinceGeoId = (String) value.get(Fields.stateProvinceGeoId
				.name());
		geoPointId = (String) value.get(Fields.geoPointId.name());
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