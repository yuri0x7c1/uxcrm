package org.apache.ofbiz.party.contact;

import java.io.Serializable;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party And Telecom Number
 */
public class PartyAndTelecomNumber implements Serializable {

	public static final long serialVersionUID = 6463644341550791680L;
	public static final String NAME = "PartyAndTelecomNumber";
	/**
	 * Last Modified Date
	 */
	@Getter
	@Setter
	private Timestamp lastModifiedDate;
	/**
	 * External Id
	 */
	@Getter
	@Setter
	private String externalId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Is Unread
	 */
	@Getter
	@Setter
	private String isUnread;
	/**
	 * Party Type Id
	 */
	@Getter
	@Setter
	private String partyTypeId;
	/**
	 * Last Modified By User Login
	 */
	@Getter
	@Setter
	private String lastModifiedByUserLogin;
	/**
	 * Data Source Id
	 */
	@Getter
	@Setter
	private String dataSourceId;
	/**
	 * Created Date
	 */
	@Getter
	@Setter
	private Timestamp createdDate;
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
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Created By User Login
	 */
	@Getter
	@Setter
	private String createdByUserLogin;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * Extension
	 */
	@Getter
	@Setter
	private String extension;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Verified
	 */
	@Getter
	@Setter
	private String verified;
	/**
	 * Months With Contact Mech
	 */
	@Getter
	@Setter
	private Long monthsWithContactMech;
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Allow Solicitation
	 */
	@Getter
	@Setter
	private String allowSolicitation;
	/**
	 * Years With Contact Mech
	 */
	@Getter
	@Setter
	private Long yearsWithContactMech;
	/**
	 * Area Code
	 */
	@Getter
	@Setter
	private String areaCode;
	/**
	 * Ask For Name
	 */
	@Getter
	@Setter
	private String askForName;
	/**
	 * Country Code
	 */
	@Getter
	@Setter
	private String countryCode;
	/**
	 * Contact Number
	 */
	@Getter
	@Setter
	private String contactNumber;

	public enum Fields {
		lastModifiedDate, externalId, description, isUnread, partyTypeId, lastModifiedByUserLogin, dataSourceId, createdDate, statusId, preferredCurrencyUomId, partyId, createdByUserLogin, roleTypeId, extension, comments, verified, monthsWithContactMech, contactMechId, thruDate, fromDate, allowSolicitation, yearsWithContactMech, areaCode, askForName, countryCode, contactNumber
	}

	public PartyAndTelecomNumber(GenericValue value) {
		lastModifiedDate = (Timestamp) value
				.get(Fields.lastModifiedDate.name());
		externalId = (String) value.get(Fields.externalId.name());
		description = (String) value.get(Fields.description.name());
		isUnread = (String) value.get(Fields.isUnread.name());
		partyTypeId = (String) value.get(Fields.partyTypeId.name());
		lastModifiedByUserLogin = (String) value
				.get(Fields.lastModifiedByUserLogin.name());
		dataSourceId = (String) value.get(Fields.dataSourceId.name());
		createdDate = (Timestamp) value.get(Fields.createdDate.name());
		statusId = (String) value.get(Fields.statusId.name());
		preferredCurrencyUomId = (String) value
				.get(Fields.preferredCurrencyUomId.name());
		partyId = (String) value.get(Fields.partyId.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		extension = (String) value.get(Fields.extension.name());
		comments = (String) value.get(Fields.comments.name());
		verified = (String) value.get(Fields.verified.name());
		monthsWithContactMech = (Long) value.get(Fields.monthsWithContactMech
				.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		allowSolicitation = (String) value.get(Fields.allowSolicitation.name());
		yearsWithContactMech = (Long) value.get(Fields.yearsWithContactMech
				.name());
		areaCode = (String) value.get(Fields.areaCode.name());
		askForName = (String) value.get(Fields.askForName.name());
		countryCode = (String) value.get(Fields.countryCode.name());
		contactNumber = (String) value.get(Fields.contactNumber.name());
	}

	public static PartyAndTelecomNumber fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyAndTelecomNumber(value);
	}

	public static List<PartyAndTelecomNumber> fromValues(
			List<GenericValue> values) {
		List<PartyAndTelecomNumber> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyAndTelecomNumber(value));
		}
		return entities;
	}
}