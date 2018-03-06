package org.apache.ofbiz.content.content.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Content Keyword
 */
public class ContentKeyword implements Serializable {

	public static final long serialVersionUID = 2415559958031642624L;
	public static final String NAME = "ContentKeyword";
	/**
	 * Content Id
	 */
	@Getter
	@Setter
	private String contentId;
	/**
	 * Keyword
	 */
	@Getter
	@Setter
	private String keyword;
	/**
	 * Relevancy Weight
	 */
	@Getter
	@Setter
	private Long relevancyWeight;

	public enum Fields {
		contentId, keyword, relevancyWeight
	}

	public ContentKeyword(GenericValue value) {
		contentId = (String) value.get(Fields.contentId.name());
		keyword = (String) value.get(Fields.keyword.name());
		relevancyWeight = (Long) value.get(Fields.relevancyWeight.name());
	}

	public static ContentKeyword fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContentKeyword(value);
	}

	public static List<ContentKeyword> fromValues(List<GenericValue> values) {
		List<ContentKeyword> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContentKeyword(value));
		}
		return entities;
	}
}