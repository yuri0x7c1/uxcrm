package org.ofbiz.party.party;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Classification Group And Type
 */
@FieldNameConstants
public class PartyClassificationGroupAndType implements Serializable {

	public static final long serialVersionUID = 4381895261826851840L;
	public static final String NAME = "PartyClassificationGroupAndType";
	/**
	 * Type Description
	 */
	@Getter
	@Setter
	private String typeDescription;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Party Classification Group Id
	 */
	@Getter
	@Setter
	private String partyClassificationGroupId;
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
	 * Party Classification Type Id
	 */
	@Getter
	@Setter
	private String partyClassificationTypeId;

	public PartyClassificationGroupAndType(GenericValue value) {
		typeDescription = (String) value.get(FIELD_TYPE_DESCRIPTION);
		parentTypeId = (String) value.get(FIELD_PARENT_TYPE_ID);
		partyClassificationGroupId = (String) value
				.get(FIELD_PARTY_CLASSIFICATION_GROUP_ID);
		parentGroupId = (String) value.get(FIELD_PARENT_GROUP_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		partyClassificationTypeId = (String) value
				.get(FIELD_PARTY_CLASSIFICATION_TYPE_ID);
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