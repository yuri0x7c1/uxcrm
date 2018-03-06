package org.apache.ofbiz.content.data.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Data Resource Type
 */
public class DataResourceType implements Serializable {

	public static final long serialVersionUID = 3758661772579823616L;
	public static final String NAME = "DataResourceType";
	/**
	 * Data Resource Type Id
	 */
	@Getter
	@Setter
	private String dataResourceTypeId;
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
		dataResourceTypeId, parentTypeId, hasTable, description
	}

	public DataResourceType(GenericValue value) {
		dataResourceTypeId = (String) value.get(Fields.dataResourceTypeId
				.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static DataResourceType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new DataResourceType(value);
	}

	public static List<DataResourceType> fromValues(List<GenericValue> values) {
		List<DataResourceType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new DataResourceType(value));
		}
		return entities;
	}
}