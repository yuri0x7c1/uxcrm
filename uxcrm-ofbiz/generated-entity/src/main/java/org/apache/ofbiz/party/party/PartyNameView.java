package org.apache.ofbiz.party.party;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Name View
 */
@FieldNameConstants
public class PartyNameView implements Serializable {

	public static final long serialVersionUID = 9136728363854332928L;
	public static final String NAME = "PartyNameView";
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
	 * Description
	 */
	@Getter
	@Setter
	private String description;
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

	public PartyNameView(GenericValue value) {
		partyId = (String) value.get(FIELD_PARTY_ID);
		partyTypeId = (String) value.get(FIELD_PARTY_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
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
	}

	public static PartyNameView fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyNameView(value);
	}

	public static List<PartyNameView> fromValues(List<GenericValue> values) {
		List<PartyNameView> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyNameView(value));
		}
		return entities;
	}
}