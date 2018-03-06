package org.apache.ofbiz.content.data.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Data Resource Meta Data
 */
public class DataResourceMetaData implements Serializable {

	public static final long serialVersionUID = 146777916114558976L;
	public static final String NAME = "DataResourceMetaData";
	/**
	 * Data Resource Id
	 */
	@Getter
	@Setter
	private String dataResourceId;
	/**
	 * Meta Data Predicate Id
	 */
	@Getter
	@Setter
	private String metaDataPredicateId;
	/**
	 * Meta Data Value
	 */
	@Getter
	@Setter
	private String metaDataValue;
	/**
	 * Data Source Id
	 */
	@Getter
	@Setter
	private String dataSourceId;

	public enum Fields {
		dataResourceId, metaDataPredicateId, metaDataValue, dataSourceId
	}

	public DataResourceMetaData(GenericValue value) {
		dataResourceId = (String) value.get(Fields.dataResourceId.name());
		metaDataPredicateId = (String) value.get(Fields.metaDataPredicateId
				.name());
		metaDataValue = (String) value.get(Fields.metaDataValue.name());
		dataSourceId = (String) value.get(Fields.dataSourceId.name());
	}

	public static DataResourceMetaData fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new DataResourceMetaData(value);
	}

	public static List<DataResourceMetaData> fromValues(
			List<GenericValue> values) {
		List<DataResourceMetaData> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new DataResourceMetaData(value));
		}
		return entities;
	}
}