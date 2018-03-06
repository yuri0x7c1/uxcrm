package org.apache.ofbiz.party.communication.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Comm Content Assoc Type
 */
public class CommContentAssocType implements Serializable {

	public static final long serialVersionUID = 7922980302676819968L;
	public static final String NAME = "CommContentAssocType";
	/**
	 * Comm Content Assoc Type Id
	 */
	@Getter
	@Setter
	private String commContentAssocTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		commContentAssocTypeId, description
	}

	public CommContentAssocType(GenericValue value) {
		commContentAssocTypeId = (String) value
				.get(Fields.commContentAssocTypeId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static CommContentAssocType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CommContentAssocType(value);
	}

	public static List<CommContentAssocType> fromValues(
			List<GenericValue> values) {
		List<CommContentAssocType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CommContentAssocType(value));
		}
		return entities;
	}
}