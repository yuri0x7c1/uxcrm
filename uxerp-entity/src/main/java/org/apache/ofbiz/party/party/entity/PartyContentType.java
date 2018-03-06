package org.apache.ofbiz.party.party.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Content Type
 */
public class PartyContentType implements Serializable {

	public static final long serialVersionUID = 3973453849936070656L;
	public static final String NAME = "PartyContentType";
	/**
	 * Party Content Type Id
	 */
	@Getter
	@Setter
	private String partyContentTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		partyContentTypeId, parentTypeId, description
	}

	public PartyContentType(GenericValue value) {
		partyContentTypeId = (String) value.get(Fields.partyContentTypeId
				.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static PartyContentType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyContentType(value);
	}

	public static List<PartyContentType> fromValues(List<GenericValue> values) {
		List<PartyContentType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyContentType(value));
		}
		return entities;
	}
}