package org.apache.ofbiz.content.content.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Content Purpose Type
 */
public class ContentPurposeType implements Serializable {

	public static final long serialVersionUID = 2068409915839939584L;
	public static final String NAME = "ContentPurposeType";
	/**
	 * Content Purpose Type Id
	 */
	@Getter
	@Setter
	private String contentPurposeTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		contentPurposeTypeId, description
	}

	public ContentPurposeType(GenericValue value) {
		contentPurposeTypeId = (String) value.get(Fields.contentPurposeTypeId
				.name());
		description = (String) value.get(Fields.description.name());
	}

	public static ContentPurposeType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContentPurposeType(value);
	}

	public static List<ContentPurposeType> fromValues(List<GenericValue> values) {
		List<ContentPurposeType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContentPurposeType(value));
		}
		return entities;
	}
}