package org.apache.ofbiz.content.data.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * File Extension
 */
public class FileExtension implements Serializable {

	public static final long serialVersionUID = 1941266037587554304L;
	public static final String NAME = "FileExtension";
	/**
	 * File Extension Id
	 */
	@Getter
	@Setter
	private String fileExtensionId;
	/**
	 * Mime Type Id
	 */
	@Getter
	@Setter
	private String mimeTypeId;

	public enum Fields {
		fileExtensionId, mimeTypeId
	}

	public FileExtension(GenericValue value) {
		fileExtensionId = (String) value.get(Fields.fileExtensionId.name());
		mimeTypeId = (String) value.get(Fields.mimeTypeId.name());
	}

	public static FileExtension fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FileExtension(value);
	}

	public static List<FileExtension> fromValues(List<GenericValue> values) {
		List<FileExtension> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FileExtension(value));
		}
		return entities;
	}
}