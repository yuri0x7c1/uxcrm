package org.apache.ofbiz.humanres.employment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Termination Type
 */
public class TerminationType implements Serializable {

	public static final long serialVersionUID = 2516028260894839808L;
	public static final String NAME = "TerminationType";
	/**
	 * Termination Type Id
	 */
	@Getter
	@Setter
	private String terminationTypeId;
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
		terminationTypeId, parentTypeId, hasTable, description
	}

	public TerminationType(GenericValue value) {
		terminationTypeId = (String) value.get(Fields.terminationTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static TerminationType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TerminationType(value);
	}

	public static List<TerminationType> fromValues(List<GenericValue> values) {
		List<TerminationType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TerminationType(value));
		}
		return entities;
	}
}