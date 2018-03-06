package org.apache.ofbiz.party.contact.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Contact Mech Purpose Type
 */
public class ContactMechPurposeType implements Serializable {

	public static final long serialVersionUID = 4470827060165755904L;
	public static final String NAME = "ContactMechPurposeType";
	/**
	 * Contact Mech Purpose Type Id
	 */
	@Getter
	@Setter
	private String contactMechPurposeTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		contactMechPurposeTypeId, description
	}

	public ContactMechPurposeType(GenericValue value) {
		contactMechPurposeTypeId = (String) value
				.get(Fields.contactMechPurposeTypeId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static ContactMechPurposeType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContactMechPurposeType(value);
	}

	public static List<ContactMechPurposeType> fromValues(
			List<GenericValue> values) {
		List<ContactMechPurposeType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContactMechPurposeType(value));
		}
		return entities;
	}
}