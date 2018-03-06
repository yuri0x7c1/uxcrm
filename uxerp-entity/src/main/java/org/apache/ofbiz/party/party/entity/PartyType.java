package org.apache.ofbiz.party.party.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Type
 */
public class PartyType implements Serializable {

	public static final long serialVersionUID = 3503742536175887360L;
	public static final String NAME = "PartyType";
	/**
	 * Party Type Id
	 */
	@Getter
	@Setter
	private String partyTypeId;
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
		partyTypeId, parentTypeId, hasTable, description
	}

	public PartyType(GenericValue value) {
		partyTypeId = (String) value.get(Fields.partyTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static PartyType fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new PartyType(value);
	}

	public static List<PartyType> fromValues(List<GenericValue> values) {
		List<PartyType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyType(value));
		}
		return entities;
	}
}