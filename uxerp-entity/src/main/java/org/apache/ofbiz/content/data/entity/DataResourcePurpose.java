package org.apache.ofbiz.content.data.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Data Resource Purpose
 */
public class DataResourcePurpose implements Serializable {

	public static final long serialVersionUID = 4389706022851570688L;
	public static final String NAME = "DataResourcePurpose";
	/**
	 * Data Resource Id
	 */
	@Getter
	@Setter
	private String dataResourceId;
	/**
	 * Content Purpose Type Id
	 */
	@Getter
	@Setter
	private String contentPurposeTypeId;

	public enum Fields {
		dataResourceId, contentPurposeTypeId
	}

	public DataResourcePurpose(GenericValue value) {
		dataResourceId = (String) value.get(Fields.dataResourceId.name());
		contentPurposeTypeId = (String) value.get(Fields.contentPurposeTypeId
				.name());
	}

	public static DataResourcePurpose fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new DataResourcePurpose(value);
	}

	public static List<DataResourcePurpose> fromValues(List<GenericValue> values) {
		List<DataResourcePurpose> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new DataResourcePurpose(value));
		}
		return entities;
	}
}