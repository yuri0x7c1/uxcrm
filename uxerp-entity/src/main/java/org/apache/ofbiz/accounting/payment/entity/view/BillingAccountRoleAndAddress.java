package org.apache.ofbiz.accounting.payment.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Billing Account Role And Address
 */
public class BillingAccountRoleAndAddress implements Serializable {

	public static final long serialVersionUID = 4725882725044807680L;
	public static final String NAME = "BillingAccountRoleAndAddress";
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
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
	/**
	 * To Name
	 */
	@Getter
	@Setter
	private String toName;
	/**
	 * Attn Name
	 */
	@Getter
	@Setter
	private String attnName;
	/**
	 * Address 1
	 */
	@Getter
	@Setter
	private String address1;
	/**
	 * Address 2
	 */
	@Getter
	@Setter
	private String address2;
	/**
	 * House Number
	 */
	@Getter
	@Setter
	private Long houseNumber;
	/**
	 * House Number Ext
	 */
	@Getter
	@Setter
	private String houseNumberExt;
	/**
	 * Directions
	 */
	@Getter
	@Setter
	private String directions;
	/**
	 * City
	 */
	@Getter
	@Setter
	private String city;
	/**
	 * City Geo Id
	 */
	@Getter
	@Setter
	private String cityGeoId;
	/**
	 * Postal Code
	 */
	@Getter
	@Setter
	private String postalCode;
	/**
	 * Postal Code Ext
	 */
	@Getter
	@Setter
	private String postalCodeExt;
	/**
	 * Country Geo Id
	 */
	@Getter
	@Setter
	private String countryGeoId;
	/**
	 * State Province Geo Id
	 */
	@Getter
	@Setter
	private String stateProvinceGeoId;
	/**
	 * County Geo Id
	 */
	@Getter
	@Setter
	private String countyGeoId;
	/**
	 * Municipality Geo Id
	 */
	@Getter
	@Setter
	private String municipalityGeoId;
	/**
	 * Postal Code Geo Id
	 */
	@Getter
	@Setter
	private String postalCodeGeoId;
	/**
	 * Geo Point Id
	 */
	@Getter
	@Setter
	private String geoPointId;

	public enum Fields {
		billingAccountId, partyId, roleTypeId, fromDate, thruDate, contactMechId, toName, attnName, address1, address2, houseNumber, houseNumberExt, directions, city, cityGeoId, postalCode, postalCodeExt, countryGeoId, stateProvinceGeoId, countyGeoId, municipalityGeoId, postalCodeGeoId, geoPointId
	}

	public BillingAccountRoleAndAddress(GenericValue value) {
		billingAccountId = (String) value.get(Fields.billingAccountId.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
		toName = (String) value.get(Fields.toName.name());
		attnName = (String) value.get(Fields.attnName.name());
		address1 = (String) value.get(Fields.address1.name());
		address2 = (String) value.get(Fields.address2.name());
		houseNumber = (Long) value.get(Fields.houseNumber.name());
		houseNumberExt = (String) value.get(Fields.houseNumberExt.name());
		directions = (String) value.get(Fields.directions.name());
		city = (String) value.get(Fields.city.name());
		cityGeoId = (String) value.get(Fields.cityGeoId.name());
		postalCode = (String) value.get(Fields.postalCode.name());
		postalCodeExt = (String) value.get(Fields.postalCodeExt.name());
		countryGeoId = (String) value.get(Fields.countryGeoId.name());
		stateProvinceGeoId = (String) value.get(Fields.stateProvinceGeoId
				.name());
		countyGeoId = (String) value.get(Fields.countyGeoId.name());
		municipalityGeoId = (String) value.get(Fields.municipalityGeoId.name());
		postalCodeGeoId = (String) value.get(Fields.postalCodeGeoId.name());
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