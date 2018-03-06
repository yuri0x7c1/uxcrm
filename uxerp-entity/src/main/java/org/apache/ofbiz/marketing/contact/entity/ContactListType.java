package org.apache.ofbiz.marketing.contact.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Contact List Type
 */
public class ContactListType implements Serializable {

	public static final long serialVersionUID = 552721062249965568L;
	public static final String NAME = "ContactListType";
	/**
	 * Contact List Type Id
	 */
	@Getter
	@Setter
	private String contactListTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		contactListTypeId, description
	}

	public ContactListType(GenericValue value) {
		contactListTypeId = (String) value.get(Fields.contactListTypeId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static ContactListType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContactListType(value);
	}

	public static List<ContactListType> fromValues(List<GenericValue> values) {
		List<ContactListType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContactListType(value));
		}
		return entities;
	}
}