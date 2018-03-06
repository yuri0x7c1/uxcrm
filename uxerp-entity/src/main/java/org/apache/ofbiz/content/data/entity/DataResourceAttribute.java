package org.apache.ofbiz.content.data.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Data Resource Attribute
 */
public class DataResourceAttribute implements Serializable {

	public static final long serialVersionUID = 1724166487456388096L;
	public static final String NAME = "DataResourceAttribute";
	/**
	 * Data Resource Id
	 */
	@Getter
	@Setter
	private String dataResourceId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Attr Value
	 */
	@Getter
	@Setter
	private String attrValue;
	/**
	 * Attr Description
	 */
	@Getter
	@Setter
	private String attrDescription;

	public enum Fields {
		dataResourceId, attrName, attrValue, attrDescription
	}

	public DataResourceAttribute(GenericValue value) {
		dataResourceId = (String) value.get(Fields.dataResourceId.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
		attrDescription = (String) value.get(Fields.attrDescription.name());
	}

	public static DataResourceAttribute fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new DataResourceAttribute(value);
	}

	public static List<DataResourceAttribute> fromValues(
			List<GenericValue> values) {
		List<DataResourceAttribute> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new DataResourceAttribute(value));
		}
		return entities;
	}
}