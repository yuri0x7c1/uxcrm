package org.apache.ofbiz.content.content.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Content Type
 */
public class ContentType implements Serializable {

	public static final long serialVersionUID = 6003401772755530752L;
	public static final String NAME = "ContentType";
	/**
	 * Content Type Id
	 */
	@Getter
	@Setter
	private String contentTypeId;
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
		contentTypeId, parentTypeId, hasTable, description
	}

	public ContentType(GenericValue value) {
		contentTypeId = (String) value.get(Fields.contentTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static ContentType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContentType(value);
	}

	public static List<ContentType> fromValues(List<GenericValue> values) {
		List<ContentType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContentType(value));
		}
		return entities;
	}
}