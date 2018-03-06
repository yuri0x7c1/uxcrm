package org.apache.ofbiz.party.party.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Identification Type
 */
public class PartyIdentificationType implements Serializable {

	public static final long serialVersionUID = 5945325202473823232L;
	public static final String NAME = "PartyIdentificationType";
	/**
	 * Party Identification Type Id
	 */
	@Getter
	@Setter
	private String partyIdentificationTypeId;
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
		partyIdentificationTypeId, parentTypeId, hasTable, description
	}

	public PartyIdentificationType(GenericValue value) {
		partyIdentificationTypeId = (String) value
				.get(Fields.partyIdentificationTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static PartyIdentificationType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyIdentificationType(value);
	}

	public static List<PartyIdentificationType> fromValues(
			List<GenericValue> values) {
		List<PartyIdentificationType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyIdentificationType(value));
		}
		return entities;
	}
}