package org.apache.ofbiz.content.document.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Document Type Attr
 */
public class DocumentTypeAttr implements Serializable {

	public static final long serialVersionUID = 1190766597109015552L;
	public static final String NAME = "DocumentTypeAttr";
	/**
	 * Document Type Id
	 */
	@Getter
	@Setter
	private String documentTypeId;
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
		documentTypeId, attrName, description
	}

	public DocumentTypeAttr(GenericValue value) {
		documentTypeId = (String) value.get(Fields.documentTypeId.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
	}

	public static DocumentTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new DocumentTypeAttr(value);
	}

	public static List<DocumentTypeAttr> fromValues(List<GenericValue> values) {
		List<DocumentTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new DocumentTypeAttr(value));
		}
		return entities;
	}
}