package org.apache.ofbiz.accounting.reports;

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
public class PartyExport implements Serializable {

	public static final long serialVersionUID = 5082632416754518016L;
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

	public enum Fields {
		partyId, statusId, preferredCurrencyUomId, groupName, firstName, middleName, lastName, companyPartyId, companyName, roleTypeId, contactMechTypeId, contactMechPurposeTypeId, emailAddress, telCountryCode, telAreaCode, telContactNumber, address1, address2, city, stateProvinceGeoId, postalCode, countryGeoId, fromDate, thruDate
	}

	public PartyExport(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		statusId = (String) value.get(Fields.statusId.name());
		preferredCurrencyUomId = (String) value
				.get(Fields.preferredCurrencyUomId.name());
		groupName = (String) value.get(Fields.groupName.name());
		firstName = (String) value.get(Fields.firstName.name());
		middleName = (String) value.get(Fields.middleName.name());
		lastName = (String) value.get(Fields.lastName.name());
		companyPartyId = (String) value.get(Fields.companyPartyId.name());
		companyName = (String) value.get(Fields.companyName.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		contactMechTypeId = (String) value.get(Fields.contactMechTypeId.name());
		contactMechPurposeTypeId = (String) value
				.get(Fields.contactMechPurposeTypeId.name());
		emailAddress = (String) value.get(Fields.emailAddress.name());
		telCountryCode = (String) value.get(Fields.telCountryCode.name());
		telAreaCode = (String) value.get(Fields.telAreaCode.name());
		telContactNumber = (String) value.get(Fields.telContactNumber.name());
		address1 = (String) value.get(Fields.address1.name());
		address2 = (String) value.get(Fields.address2.name());
		city = (String) value.get(Fields.city.name());
		stateProvinceGeoId = (String) value.get(Fields.stateProvinceGeoId
				.name());
		postalCode = (String) value.get(Fields.postalCode.name());
		countryGeoId = (String) value.get(Fields.countryGeoId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
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