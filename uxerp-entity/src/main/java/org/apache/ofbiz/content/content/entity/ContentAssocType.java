package org.apache.ofbiz.content.content.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Content Assoc Type
 */
public class ContentAssocType implements Serializable {

	public static final long serialVersionUID = 2531691385514842112L;
	public static final String NAME = "ContentAssocType";
	/**
	 * Content Assoc Type Id
	 */
	@Getter
	@Setter
	private String contentAssocTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		contentAssocTypeId, description
	}

	public ContentAssocType(GenericValue value) {
		contentAssocTypeId = (String) value.get(Fields.contentAssocTypeId
				.name());
		description = (String) value.get(Fields.description.name());
	}

	public static ContentAssocType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContentAssocType(value);
	}

	public static List<ContentAssocType> fromValues(List<GenericValue> values) {
		List<ContentAssocType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContentAssocType(value));
		}
		return entities;
	}
}