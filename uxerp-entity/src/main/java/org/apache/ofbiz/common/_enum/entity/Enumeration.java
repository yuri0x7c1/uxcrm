package org.apache.ofbiz.common._enum.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Enumeration
 */
public class Enumeration implements Serializable {

	public static final long serialVersionUID = 2480138244863923200L;
	public static final String NAME = "Enumeration";
	/**
	 * Enum Id
	 */
	@Getter
	@Setter
	private String enumId;
	/**
	 * Enum Type Id
	 */
	@Getter
	@Setter
	private String enumTypeId;
	/**
	 * Enum Code
	 */
	@Getter
	@Setter
	private String enumCode;
	/**
	 * Sequence Id
	 */
	@Getter
	@Setter
	private String sequenceId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		enumId, enumTypeId, enumCode, sequenceId, description
	}

	public Enumeration(GenericValue value) {
		enumId = (String) value.get(Fields.enumId.name());
		enumTypeId = (String) value.get(Fields.enumTypeId.name());
		enumCode = (String) value.get(Fields.enumCode.name());
		sequenceId = (String) value.get(Fields.sequenceId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static Enumeration fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new Enumeration(value);
	}

	public static List<Enumeration> fromValues(List<GenericValue> values) {
		List<Enumeration> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new Enumeration(value));
		}
		return entities;
	}
}