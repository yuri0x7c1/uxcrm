package org.apache.ofbiz.party.contact.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Contact Mech Type Attr
 */
public class ContactMechTypeAttr implements Serializable {

	public static final long serialVersionUID = 2930200104644789248L;
	public static final String NAME = "ContactMechTypeAttr";
	/**
	 * Contact Mech Type Id
	 */
	@Getter
	@Setter
	private String contactMechTypeId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		contactMechTypeId, attrName, description
	}

	public ContactMechTypeAttr(GenericValue value) {
		contactMechTypeId = (String) value.get(Fields.contactMechTypeId.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
	}

	public static ContactMechTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContactMechTypeAttr(value);
	}

	public static List<ContactMechTypeAttr> fromValues(List<GenericValue> values) {
		List<ContactMechTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContactMechTypeAttr(value));
		}
		return entities;
	}
}