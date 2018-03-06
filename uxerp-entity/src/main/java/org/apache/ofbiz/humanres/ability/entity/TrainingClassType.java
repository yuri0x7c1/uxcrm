package org.apache.ofbiz.humanres.ability.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Training Class Type
 */
public class TrainingClassType implements Serializable {

	public static final long serialVersionUID = 6626664773124899840L;
	public static final String NAME = "TrainingClassType";
	/**
	 * Training Class Type Id
	 */
	@Getter
	@Setter
	private String trainingClassTypeId;
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
		trainingClassTypeId, parentTypeId, hasTable, description
	}

	public TrainingClassType(GenericValue value) {
		trainingClassTypeId = (String) value.get(Fields.trainingClassTypeId
				.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static TrainingClassType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TrainingClassType(value);
	}

	public static List<TrainingClassType> fromValues(List<GenericValue> values) {
		List<TrainingClassType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TrainingClassType(value));
		}
		return entities;
	}
}