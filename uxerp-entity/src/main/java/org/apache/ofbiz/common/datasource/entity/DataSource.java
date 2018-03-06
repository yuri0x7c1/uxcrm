package org.apache.ofbiz.common.datasource.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Data Source
 */
public class DataSource implements Serializable {

	public static final long serialVersionUID = 7357909210737008640L;
	public static final String NAME = "DataSource";
	/**
	 * Data Source Id
	 */
	@Getter
	@Setter
	private String dataSourceId;
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
		dataSourceId, dataSourceTypeId, description
	}

	public DataSource(GenericValue value) {
		dataSourceId = (String) value.get(Fields.dataSourceId.name());
		dataSourceTypeId = (String) value.get(Fields.dataSourceTypeId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static DataSource fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new DataSource(value);
	}

	public static List<DataSource> fromValues(List<GenericValue> values) {
		List<DataSource> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new DataSource(value));
		}
		return entities;
	}
}