package org.apache.ofbiz.humanres.ability.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Qual Type
 */
public class PartyQualType implements Serializable {

	public static final long serialVersionUID = 4592276978621319168L;
	public static final String NAME = "PartyQualType";
	/**
	 * Party Qual Type Id
	 */
	@Getter
	@Setter
	private String partyQualTypeId;
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
		partyQualTypeId, parentTypeId, hasTable, description
	}

	public PartyQualType(GenericValue value) {
		partyQualTypeId = (String) value.get(Fields.partyQualTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static PartyQualType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyQualType(value);
	}

	public static List<PartyQualType> fromValues(List<GenericValue> values) {
		List<PartyQualType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyQualType(value));
		}
		return entities;
	}
}