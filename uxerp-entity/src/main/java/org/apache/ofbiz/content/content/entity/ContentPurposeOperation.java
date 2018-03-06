package org.apache.ofbiz.content.content.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Content Purpose Operation
 */
public class ContentPurposeOperation implements Serializable {

	public static final long serialVersionUID = 3849521335676724224L;
	public static final String NAME = "ContentPurposeOperation";
	/**
	 * Content Purpose Type Id
	 */
	@Getter
	@Setter
	private String contentPurposeTypeId;
	/**
	 * Content Operation Id
	 */
	@Getter
	@Setter
	private String contentOperationId;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Privilege Enum Id
	 */
	@Getter
	@Setter
	private String privilegeEnumId;

	public enum Fields {
		contentPurposeTypeId, contentOperationId, roleTypeId, statusId, privilegeEnumId
	}

	public ContentPurposeOperation(GenericValue value) {
		contentPurposeTypeId = (String) value.get(Fields.contentPurposeTypeId
				.name());
		contentOperationId = (String) value.get(Fields.contentOperationId
				.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		statusId = (String) value.get(Fields.statusId.name());
		privilegeEnumId = (String) value.get(Fields.privilegeEnumId.name());
	}

	public static ContentPurposeOperation fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContentPurposeOperation(value);
	}

	public static List<ContentPurposeOperation> fromValues(
			List<GenericValue> values) {
		List<ContentPurposeOperation> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContentPurposeOperation(value));
		}
		return entities;
	}
}