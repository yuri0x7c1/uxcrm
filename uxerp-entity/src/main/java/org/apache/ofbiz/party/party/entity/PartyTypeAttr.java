package org.apache.ofbiz.party.party.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Type Attr
 */
public class PartyTypeAttr implements Serializable {

	public static final long serialVersionUID = 2721539823852794880L;
	public static final String NAME = "PartyTypeAttr";
	/**
	 * Party Type Id
	 */
	@Getter
	@Setter
	private String partyTypeId;
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
		partyTypeId, attrName, description
	}

	public PartyTypeAttr(GenericValue value) {
		partyTypeId = (String) value.get(Fields.partyTypeId.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
	}

	public static PartyTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyTypeAttr(value);
	}

	public static List<PartyTypeAttr> fromValues(List<GenericValue> values) {
		List<PartyTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyTypeAttr(value));
		}
		return entities;
	}
}