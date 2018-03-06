package org.apache.ofbiz.humanres.employment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Employment App Source Type
 */
public class EmploymentAppSourceType implements Serializable {

	public static final long serialVersionUID = 3133843023533593600L;
	public static final String NAME = "EmploymentAppSourceType";
	/**
	 * Employment App Source Type Id
	 */
	@Getter
	@Setter
	private String employmentAppSourceTypeId;
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
		employmentAppSourceTypeId, parentTypeId, hasTable, description
	}

	public EmploymentAppSourceType(GenericValue value) {
		employmentAppSourceTypeId = (String) value
				.get(Fields.employmentAppSourceTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static EmploymentAppSourceType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new EmploymentAppSourceType(value);
	}

	public static List<EmploymentAppSourceType> fromValues(
			List<GenericValue> values) {
		List<EmploymentAppSourceType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new EmploymentAppSourceType(value));
		}
		return entities;
	}
}