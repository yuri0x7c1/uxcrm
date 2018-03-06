package org.apache.ofbiz.content.content.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Content Type Attr
 */
public class ContentTypeAttr implements Serializable {

	public static final long serialVersionUID = 5504415442741634048L;
	public static final String NAME = "ContentTypeAttr";
	/**
	 * Content Type Id
	 */
	@Getter
	@Setter
	private String contentTypeId;
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
		contentTypeId, attrName, description
	}

	public ContentTypeAttr(GenericValue value) {
		contentTypeId = (String) value.get(Fields.contentTypeId.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
	}

	public static ContentTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContentTypeAttr(value);
	}

	public static List<ContentTypeAttr> fromValues(List<GenericValue> values) {
		List<ContentTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContentTypeAttr(value));
		}
		return entities;
	}
}