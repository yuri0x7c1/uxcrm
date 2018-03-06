package org.apache.ofbiz.order._return.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Return Type
 */
public class ReturnType implements Serializable {

	public static final long serialVersionUID = 8236422324992764928L;
	public static final String NAME = "ReturnType";
	/**
	 * Return Type Id
	 */
	@Getter
	@Setter
	private String returnTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Sequence Id
	 */
	@Getter
	@Setter
	private String sequenceId;

	public enum Fields {
		returnTypeId, description, sequenceId
	}

	public ReturnType(GenericValue value) {
		returnTypeId = (String) value.get(Fields.returnTypeId.name());
		description = (String) value.get(Fields.description.name());
		sequenceId = (String) value.get(Fields.sequenceId.name());
	}

	public static ReturnType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ReturnType(value);
	}

	public static List<ReturnType> fromValues(List<GenericValue> values) {
		List<ReturnType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ReturnType(value));
		}
		return entities;
	}
}