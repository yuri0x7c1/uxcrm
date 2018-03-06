package org.apache.ofbiz.content.data.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Data Resource Type Attr
 */
public class DataResourceTypeAttr implements Serializable {

	public static final long serialVersionUID = 3165471831850294272L;
	public static final String NAME = "DataResourceTypeAttr";
	/**
	 * Data Resource Type Id
	 */
	@Getter
	@Setter
	private String dataResourceTypeId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		dataResourceTypeId, attrName, description
	}

	public DataResourceTypeAttr(GenericValue value) {
		dataResourceTypeId = (String) value.get(Fields.dataResourceTypeId
				.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
	}

	public static DataResourceTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new DataResourceTypeAttr(value);
	}

	public static List<DataResourceTypeAttr> fromValues(
			List<GenericValue> values) {
		List<DataResourceTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new DataResourceTypeAttr(value));
		}
		return entities;
	}
}