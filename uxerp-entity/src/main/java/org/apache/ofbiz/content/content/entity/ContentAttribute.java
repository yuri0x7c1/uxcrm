package org.apache.ofbiz.content.content.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Content Attribute
 */
public class ContentAttribute implements Serializable {

	public static final long serialVersionUID = 4401496513444380672L;
	public static final String NAME = "ContentAttribute";
	/**
	 * Content Id
	 */
	@Getter
	@Setter
	private String contentId;
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
		contentId, attrName, attrValue, attrDescription
	}

	public ContentAttribute(GenericValue value) {
		contentId = (String) value.get(Fields.contentId.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
		attrDescription = (String) value.get(Fields.attrDescription.name());
	}

	public static ContentAttribute fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContentAttribute(value);
	}

	public static List<ContentAttribute> fromValues(List<GenericValue> values) {
		List<ContentAttribute> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContentAttribute(value));
		}
		return entities;
	}
}