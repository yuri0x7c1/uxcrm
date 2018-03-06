package org.apache.ofbiz.party.party.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Classification Group
 */
public class PartyClassificationGroup implements Serializable {

	public static final long serialVersionUID = 1097655493520077824L;
	public static final String NAME = "PartyClassificationGroup";
	/**
	 * Party Classification Group Id
	 */
	@Getter
	@Setter
	private String partyClassificationGroupId;
	/**
	 * Party Classification Type Id
	 */
	@Getter
	@Setter
	private String partyClassificationTypeId;
	/**
	 * Parent Group Id
	 */
	@Getter
	@Setter
	private String parentGroupId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		partyClassificationGroupId, partyClassificationTypeId, parentGroupId, description
	}

	public PartyClassificationGroup(GenericValue value) {
		partyClassificationGroupId = (String) value
				.get(Fields.partyClassificationGroupId.name());
		partyClassificationTypeId = (String) value
				.get(Fields.partyClassificationTypeId.name());
		parentGroupId = (String) value.get(Fields.parentGroupId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static PartyClassificationGroup fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyClassificationGroup(value);
	}

	public static List<PartyClassificationGroup> fromValues(
			List<GenericValue> values) {
		List<PartyClassificationGroup> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyClassificationGroup(value));
		}
		return entities;
	}
}