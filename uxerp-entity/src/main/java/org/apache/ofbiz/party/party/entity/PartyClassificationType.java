package org.apache.ofbiz.party.party.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Classification Type
 */
public class PartyClassificationType implements Serializable {

	public static final long serialVersionUID = 3941288107511322624L;
	public static final String NAME = "PartyClassificationType";
	/**
	 * Party Classification Type Id
	 */
	@Getter
	@Setter
	private String partyClassificationTypeId;
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
		partyClassificationTypeId, parentTypeId, hasTable, description
	}

	public PartyClassificationType(GenericValue value) {
		partyClassificationTypeId = (String) value
				.get(Fields.partyClassificationTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static PartyClassificationType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyClassificationType(value);
	}

	public static List<PartyClassificationType> fromValues(
			List<GenericValue> values) {
		List<PartyClassificationType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyClassificationType(value));
		}
		return entities;
	}
}