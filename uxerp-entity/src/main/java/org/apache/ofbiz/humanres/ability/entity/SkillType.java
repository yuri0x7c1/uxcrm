package org.apache.ofbiz.humanres.ability.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Skill Type
 */
public class SkillType implements Serializable {

	public static final long serialVersionUID = 6111299305109177344L;
	public static final String NAME = "SkillType";
	/**
	 * Skill Type Id
	 */
	@Getter
	@Setter
	private String skillTypeId;
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
		skillTypeId, parentTypeId, hasTable, description
	}

	public SkillType(GenericValue value) {
		skillTypeId = (String) value.get(Fields.skillTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static SkillType fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new SkillType(value);
	}

	public static List<SkillType> fromValues(List<GenericValue> values) {
		List<SkillType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SkillType(value));
		}
		return entities;
	}
}