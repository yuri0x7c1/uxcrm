package org.ofbiz.party.party.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Classification Group And Type
 */
public class PartyClassificationGroupAndType implements Serializable {

	public static final long serialVersionUID = 3366953109275959296L;
	public static final String NAME = "PartyClassificationGroupAndType";
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
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;

	public enum Fields {
		partyClassificationGroupId, partyClassificationTypeId, parentGroupId, description, parentTypeId
	}

	public PartyClassificationGroupAndType(GenericValue value) {
		partyClassificationGroupId = (String) value
				.get(Fields.partyClassificationGroupId.name());
		partyClassificationTypeId = (String) value
				.get(Fields.partyClassificationTypeId.name());
		parentGroupId = (String) value.get(Fields.parentGroupId.name());
		description = (String) value.get(Fields.description.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
	}

	public static PartyClassificationGroupAndType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyClassificationGroupAndType(value);
	}

	public static List<PartyClassificationGroupAndType> fromValues(
			List<GenericValue> values) {
		List<PartyClassificationGroupAndType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyClassificationGroupAndType(value));
		}
		return entities;
	}
}