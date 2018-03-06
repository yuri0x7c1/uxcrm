package org.apache.ofbiz.party.contact.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Contact Mech Attribute
 */
public class ContactMechAttribute implements Serializable {

	public static final long serialVersionUID = 916600544389975040L;
	public static final String NAME = "ContactMechAttribute";
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Attr Value
	 */
	@Getter
	@Setter
	private String attrValue;
	/**
	 * Attr Description
	 */
	@Getter
	@Setter
	private String attrDescription;

	public enum Fields {
		contactMechId, attrName, attrValue, attrDescription
	}

	public ContactMechAttribute(GenericValue value) {
		contactMechId = (String) value.get(Fields.contactMechId.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
		attrDescription = (String) value.get(Fields.attrDescription.name());
	}

	public static ContactMechAttribute fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContactMechAttribute(value);
	}

	public static List<ContactMechAttribute> fromValues(
			List<GenericValue> values) {
		List<ContactMechAttribute> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContactMechAttribute(value));
		}
		return entities;
	}
}