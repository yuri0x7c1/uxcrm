package org.apache.ofbiz.content.document.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Document Type
 */
public class DocumentType implements Serializable {

	public static final long serialVersionUID = 3227658708490667008L;
	public static final String NAME = "DocumentType";
	/**
	 * Document Type Id
	 */
	@Getter
	@Setter
	private String documentTypeId;
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
		documentTypeId, parentTypeId, hasTable, description
	}

	public DocumentType(GenericValue value) {
		documentTypeId = (String) value.get(Fields.documentTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static DocumentType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new DocumentType(value);
	}

	public static List<DocumentType> fromValues(List<GenericValue> values) {
		List<DocumentType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new DocumentType(value));
		}
		return entities;
	}
}