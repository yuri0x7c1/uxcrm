package org.apache.ofbiz.party.party.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Attribute
 */
public class PartyAttribute implements Serializable {

	public static final long serialVersionUID = 9200610956024889344L;
	public static final String NAME = "PartyAttribute";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
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
		partyId, attrName, attrValue, attrDescription
	}

	public PartyAttribute(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
		attrDescription = (String) value.get(Fields.attrDescription.name());
	}

	public static PartyAttribute fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyAttribute(value);
	}

	public static List<PartyAttribute> fromValues(List<GenericValue> values) {
		List<PartyAttribute> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyAttribute(value));
		}
		return entities;
	}
}