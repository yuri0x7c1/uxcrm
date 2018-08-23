package org.apache.ofbiz.accounting.reports;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Export
 */
@FieldNameConstants
public class PartyExport implements Serializable {

	public static final long serialVersionUID = 3960784987833135104L;
	public static final String NAME = "PartyExport";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Preferred Currency Uom Id
	 */
	@Getter
	@Setter
	private String preferredCurrencyUomId;
	/**
	 * Group Name
	 */
	@Getter
	@Setter
	private String groupName;
	/**
	 * First Name
	 */
	@Getter
	@Setter
	private String firstName;
	/**
	 * Middle Name
	 */
	@Getter
	@Setter
	private String middleName;
	/**
	 * Last Name
	 */
	@Getter
	@Setter
	private String lastName;
	/**
	 * Company Party Id
	 */
	@Getter
	@Setter
	private String companyPartyId;
	/**
	 * Company Name
	 */
	@Getter
	@Setter
	private String companyName;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * Contact Mech Type Id
	 */
	@Getter
	@Setter
	private String contactMechTypeId;
	/**
	 * Contact Mech Purpose Type Id
	 */
	@Getter
	@Setter
	private String contactMechPurposeTypeId;
	/**
	 * Email Address
	 */
	@Getter
	@Setter
	private String emailAddress;
	/**
	 * Tel Country Code
	 */
	@Getter
	@Setter
	private String telCountryCode;
	/**
	 * Tel Area Code
	 */
	@Getter
	@Setter
	private String telAreaCode;
	/**
	 * Tel Contact Number
	 */
	@Getter
	@Setter
	private String telContactNumber;
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
	 * City
	 */
	@Getter
	@Setter
	private String city;
	/**
	 * State Province Geo Id
	 */
	@Getter
	@Setter
	private String stateProvinceGeoId;
	/**
	 * Postal Code
	 */
	@Getter
	@Setter
	private String postalCode;
	/**
	 * Country Geo Id
	 */
	@Getter
	@Setter
	private String countryGeoId;
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

	public PartyExport(GenericValue value) {
		partyId = (String) value.get(FIELD_PARTY_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		preferredCurrencyUomId = (String) value
				.get(FIELD_PREFERRED_CURRENCY_UOM_ID);
		groupName = (String) value.get(FIELD_GROUP_NAME);
		firstName = (String) value.get(FIELD_FIRST_NAME);
		middleName = (String) value.get(FIELD_MIDDLE_NAME);
		lastName = (String) value.get(FIELD_LAST_NAME);
		companyPartyId = (String) value.get(FIELD_COMPANY_PARTY_ID);
		companyName = (String) value.get(FIELD_COMPANY_NAME);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		contactMechTypeId = (String) value.get(FIELD_CONTACT_MECH_TYPE_ID);
		contactMechPurposeTypeId = (String) value
				.get(FIELD_CONTACT_MECH_PURPOSE_TYPE_ID);
		emailAddress = (String) value.get(FIELD_EMAIL_ADDRESS);
		telCountryCode = (String) value.get(FIELD_TEL_COUNTRY_CODE);
		telAreaCode = (String) value.get(FIELD_TEL_AREA_CODE);
		telContactNumber = (String) value.get(FIELD_TEL_CONTACT_NUMBER);
		address1 = (String) value.get(FIELD_ADDRESS1);
		address2 = (String) value.get(FIELD_ADDRESS2);
		city = (String) value.get(FIELD_CITY);
		stateProvinceGeoId = (String) value.get(FIELD_STATE_PROVINCE_GEO_ID);
		postalCode = (String) value.get(FIELD_POSTAL_CODE);
		countryGeoId = (String) value.get(FIELD_COUNTRY_GEO_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
	}

	public static PartyExport fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyExport(value);
	}

	public static List<PartyExport> fromValues(List<GenericValue> values) {
		List<PartyExport> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyExport(value));
		}
		return entities;
	}
}