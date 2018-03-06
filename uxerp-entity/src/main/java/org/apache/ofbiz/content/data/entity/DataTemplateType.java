package org.apache.ofbiz.content.data.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Data Template Type
 */
public class DataTemplateType implements Serializable {

	public static final long serialVersionUID = 1685448648890718208L;
	public static final String NAME = "DataTemplateType";
	/**
	 * Data Template Type Id
	 */
	@Getter
	@Setter
	private String dataTemplateTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Extension
	 */
	@Getter
	@Setter
	private String extension;

	public enum Fields {
		dataTemplateTypeId, description, extension
	}

	public DataTemplateType(GenericValue value) {
		dataTemplateTypeId = (String) value.get(Fields.dataTemplateTypeId
				.name());
		description = (String) value.get(Fields.description.name());
		extension = (String) value.get(Fields.extension.name());
	}

	public static DataTemplateType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new DataTemplateType(value);
	}

	public static List<DataTemplateType> fromValues(List<GenericValue> values) {
		List<DataTemplateType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new DataTemplateType(value));
		}
		return entities;
	}
}