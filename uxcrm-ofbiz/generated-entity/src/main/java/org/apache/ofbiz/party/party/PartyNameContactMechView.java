package org.apache.ofbiz.party.party;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Name Contact Mech View
 */
@FieldNameConstants
public class PartyNameContactMechView implements Serializable {

	public static final long serialVersionUID = 7233836611575398400L;
	public static final String NAME = "PartyNameContactMechView";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Party Type Id
	 */
	@Getter
	@Setter
	private String partyTypeId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
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
	 * First Name Local
	 */
	@Getter
	@Setter
	private String firstNameLocal;
	/**
	 * Last Name Local
	 */
	@Getter
	@Setter
	private String lastNameLocal;
	/**
	 * Personal Title
	 */
	@Getter
	@Setter
	private String personalTitle;
	/**
	 * Suffix
	 */
	@Getter
	@Setter
	private String suffix;
	/**
	 * Group Name
	 */
	@Getter
	@Setter
	private String groupName;
	/**
	 * Group Name Local
	 */
	@Getter
	@Setter
	private String groupNameLocal;
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
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
	 * Contact Mech Type Id
	 */
	@Getter
	@Setter
	private String contactMechTypeId;
	/**
	 * Info String
	 */
	@Getter
	@Setter
	private String infoString;

	public PartyNameContactMechView(GenericValue value) {
		partyId = (String) value.get(FIELD_PARTY_ID);
		partyTypeId = (String) value.get(FIELD_PARTY_TYPE_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		firstName = (String) value.get(FIELD_FIRST_NAME);
		middleName = (String) value.get(FIELD_MIDDLE_NAME);
		lastName = (String) value.get(FIELD_LAST_NAME);
		firstNameLocal = (String) value.get(FIELD_FIRST_NAME_LOCAL);
		lastNameLocal = (String) value.get(FIELD_LAST_NAME_LOCAL);
		personalTitle = (String) value.get(FIELD_PERSONAL_TITLE);
		suffix = (String) value.get(FIELD_SUFFIX);
		groupName = (String) value.get(FIELD_GROUP_NAME);
		groupNameLocal = (String) value.get(FIELD_GROUP_NAME_LOCAL);
		contactMechId = (String) value.get(FIELD_CONTACT_MECH_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		contactMechTypeId = (String) value.get(FIELD_CONTACT_MECH_TYPE_ID);
		infoString = (String) value.get(FIELD_INFO_STRING);
	}

	public static PartyNameContactMechView fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyNameContactMechView(value);
	}

	public static List<PartyNameContactMechView> fromValues(
			List<GenericValue> values) {
		List<PartyNameContactMechView> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyNameContactMechView(value));
		}
		return entities;
	}
}