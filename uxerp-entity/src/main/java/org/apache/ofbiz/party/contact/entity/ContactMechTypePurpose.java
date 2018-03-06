package org.apache.ofbiz.party.contact.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Contact Mech Type Purpose
 */
public class ContactMechTypePurpose implements Serializable {

	public static final long serialVersionUID = 2084502982273055744L;
	public static final String NAME = "ContactMechTypePurpose";
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

	public enum Fields {
		contactMechTypeId, contactMechPurposeTypeId
	}

	public ContactMechTypePurpose(GenericValue value) {
		contactMechTypeId = (String) value.get(Fields.contactMechTypeId.name());
		contactMechPurposeTypeId = (String) value
				.get(Fields.contactMechPurposeTypeId.name());
	}

	public static ContactMechTypePurpose fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContactMechTypePurpose(value);
	}

	public static List<ContactMechTypePurpose> fromValues(
			List<GenericValue> values) {
		List<ContactMechTypePurpose> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContactMechTypePurpose(value));
		}
		return entities;
	}
}