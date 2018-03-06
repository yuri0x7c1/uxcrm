package org.apache.ofbiz.content.data.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Mime Type
 */
public class MimeType implements Serializable {

	public static final long serialVersionUID = 2719533152158177280L;
	public static final String NAME = "MimeType";
	/**
	 * Mime Type Id
	 */
	@Getter
	@Setter
	private String mimeTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		mimeTypeId, description
	}

	public MimeType(GenericValue value) {
		mimeTypeId = (String) value.get(Fields.mimeTypeId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static MimeType fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new MimeType(value);
	}

	public static List<MimeType> fromValues(List<GenericValue> values) {
		List<MimeType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new MimeType(value));
		}
		return entities;
	}
}