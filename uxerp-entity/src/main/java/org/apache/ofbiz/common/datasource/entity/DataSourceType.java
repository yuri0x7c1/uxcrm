package org.apache.ofbiz.common.datasource.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Data Source Type
 */
public class DataSourceType implements Serializable {

	public static final long serialVersionUID = 2240283202134042624L;
	public static final String NAME = "DataSourceType";
	/**
	 * Data Source Type Id
	 */
	@Getter
	@Setter
	private String dataSourceTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		dataSourceTypeId, description
	}

	public DataSourceType(GenericValue value) {
		dataSourceTypeId = (String) value.get(Fields.dataSourceTypeId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static DataSourceType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new DataSourceType(value);
	}

	public static List<DataSourceType> fromValues(List<GenericValue> values) {
		List<DataSourceType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new DataSourceType(value));
		}
		return entities;
	}
}