package org.apache.ofbiz.order._return.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Return Header Type
 */
public class ReturnHeaderType implements Serializable {

	public static final long serialVersionUID = 6112056377249551360L;
	public static final String NAME = "ReturnHeaderType";
	/**
	 * Return Header Type Id
	 */
	@Getter
	@Setter
	private String returnHeaderTypeId;
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
		returnHeaderTypeId, parentTypeId, description
	}

	public ReturnHeaderType(GenericValue value) {
		returnHeaderTypeId = (String) value.get(Fields.returnHeaderTypeId
				.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static ReturnHeaderType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ReturnHeaderType(value);
	}

	public static List<ReturnHeaderType> fromValues(List<GenericValue> values) {
		List<ReturnHeaderType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ReturnHeaderType(value));
		}
		return entities;
	}
}