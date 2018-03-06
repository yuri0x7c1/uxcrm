package org.apache.ofbiz.party.need.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Need Type
 */
public class NeedType implements Serializable {

	public static final long serialVersionUID = 3154209026864883712L;
	public static final String NAME = "NeedType";
	/**
	 * Need Type Id
	 */
	@Getter
	@Setter
	private String needTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		needTypeId, description
	}

	public NeedType(GenericValue value) {
		needTypeId = (String) value.get(Fields.needTypeId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static NeedType fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new NeedType(value);
	}

	public static List<NeedType> fromValues(List<GenericValue> values) {
		List<NeedType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new NeedType(value));
		}
		return entities;
	}
}