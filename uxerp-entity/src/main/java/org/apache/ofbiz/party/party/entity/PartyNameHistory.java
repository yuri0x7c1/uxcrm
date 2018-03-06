package org.apache.ofbiz.party.party.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Name History
 */
public class PartyNameHistory implements Serializable {

	public static final long serialVersionUID = 6733881172462583808L;
	public static final String NAME = "PartyNameHistory";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Change Date
	 */
	@Getter
	@Setter
	private Timestamp changeDate;
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

	public enum Fields {
		partyId, changeDate, groupName, firstName, middleName, lastName, personalTitle, suffix
	}

	public PartyNameHistory(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		changeDate = (Timestamp) value.get(Fields.changeDate.name());
		groupName = (String) value.get(Fields.groupName.name());
		firstName = (String) value.get(Fields.firstName.name());
		middleName = (String) value.get(Fields.middleName.name());
		lastName = (String) value.get(Fields.lastName.name());
		personalTitle = (String) value.get(Fields.personalTitle.name());
		suffix = (String) value.get(Fields.suffix.name());
	}

	public static PartyNameHistory fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyNameHistory(value);
	}

	public static List<PartyNameHistory> fromValues(List<GenericValue> values) {
		List<PartyNameHistory> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyNameHistory(value));
		}
		return entities;
	}
}