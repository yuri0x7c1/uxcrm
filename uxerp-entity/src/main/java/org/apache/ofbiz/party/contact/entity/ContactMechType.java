package org.apache.ofbiz.party.contact.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Contact Mech Type
 */
public class ContactMechType implements Serializable {

	public static final long serialVersionUID = 7626117539202371584L;
	public static final String NAME = "ContactMechType";
	/**
	 * Contact Mech Type Id
	 */
	@Getter
	@Setter
	private String contactMechTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Has Table
	 */
	@Getter
	@Setter
	private String hasTable;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		contactMechTypeId, parentTypeId, hasTable, description
	}

	public ContactMechType(GenericValue value) {
		contactMechTypeId = (String) value.get(Fields.contactMechTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static ContactMechType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContactMechType(value);
	}

	public static List<ContactMechType> fromValues(List<GenericValue> values) {
		List<ContactMechType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContactMechType(value));
		}
		return entities;
	}
}