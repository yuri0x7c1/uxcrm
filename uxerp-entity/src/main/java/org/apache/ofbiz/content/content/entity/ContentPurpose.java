package org.apache.ofbiz.content.content.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Content Purpose
 */
public class ContentPurpose implements Serializable {

	public static final long serialVersionUID = 278190841905334272L;
	public static final String NAME = "ContentPurpose";
	/**
	 * Content Id
	 */
	@Getter
	@Setter
	private String contentId;
	/**
	 * Content Purpose Type Id
	 */
	@Getter
	@Setter
	private String contentPurposeTypeId;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;

	public enum Fields {
		contentId, contentPurposeTypeId, sequenceNum
	}

	public ContentPurpose(GenericValue value) {
		contentId = (String) value.get(Fields.contentId.name());
		contentPurposeTypeId = (String) value.get(Fields.contentPurposeTypeId
				.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
	}

	public static ContentPurpose fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContentPurpose(value);
	}

	public static List<ContentPurpose> fromValues(List<GenericValue> values) {
		List<ContentPurpose> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContentPurpose(value));
		}
		return entities;
	}
}