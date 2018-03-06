package org.apache.ofbiz.party.contact.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Contact Mech
 */
public class ContactMech implements Serializable {

	public static final long serialVersionUID = 276400133076245504L;
	public static final String NAME = "ContactMech";
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
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

	public enum Fields {
		contactMechId, contactMechTypeId, infoString
	}

	public ContactMech(GenericValue value) {
		contactMechId = (String) value.get(Fields.contactMechId.name());
		contactMechTypeId = (String) value.get(Fields.contactMechTypeId.name());
		infoString = (String) value.get(Fields.infoString.name());
	}

	public static ContactMech fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContactMech(value);
	}

	public static List<ContactMech> fromValues(List<GenericValue> values) {
		List<ContactMech> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContactMech(value));
		}
		return entities;
	}
}