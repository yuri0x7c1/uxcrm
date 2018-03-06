package org.apache.ofbiz.manufacturing.mrp.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Mrp Event Type
 */
public class MrpEventType implements Serializable {

	public static final long serialVersionUID = 3937376415082323968L;
	public static final String NAME = "MrpEventType";
	/**
	 * Mrp Event Type Id
	 */
	@Getter
	@Setter
	private String mrpEventTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		mrpEventTypeId, description
	}

	public MrpEventType(GenericValue value) {
		mrpEventTypeId = (String) value.get(Fields.mrpEventTypeId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static MrpEventType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new MrpEventType(value);
	}

	public static List<MrpEventType> fromValues(List<GenericValue> values) {
		List<MrpEventType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new MrpEventType(value));
		}
		return entities;
	}
}