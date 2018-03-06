package org.apache.ofbiz.content.data.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Character Set
 */
public class CharacterSet implements Serializable {

	public static final long serialVersionUID = 7890725984302913536L;
	public static final String NAME = "CharacterSet";
	/**
	 * Character Set Id
	 */
	@Getter
	@Setter
	private String characterSetId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		characterSetId, description
	}

	public CharacterSet(GenericValue value) {
		characterSetId = (String) value.get(Fields.characterSetId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static CharacterSet fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CharacterSet(value);
	}

	public static List<CharacterSet> fromValues(List<GenericValue> values) {
		List<CharacterSet> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CharacterSet(value));
		}
		return entities;
	}
}