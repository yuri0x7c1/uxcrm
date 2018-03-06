package org.apache.ofbiz.content.content.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Content Operation
 */
public class ContentOperation implements Serializable {

	public static final long serialVersionUID = 3975490009957662720L;
	public static final String NAME = "ContentOperation";
	/**
	 * Content Operation Id
	 */
	@Getter
	@Setter
	private String contentOperationId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		contentOperationId, description
	}

	public ContentOperation(GenericValue value) {
		contentOperationId = (String) value.get(Fields.contentOperationId
				.name());
		description = (String) value.get(Fields.description.name());
	}

	public static ContentOperation fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContentOperation(value);
	}

	public static List<ContentOperation> fromValues(List<GenericValue> values) {
		List<ContentOperation> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContentOperation(value));
		}
		return entities;
	}
}