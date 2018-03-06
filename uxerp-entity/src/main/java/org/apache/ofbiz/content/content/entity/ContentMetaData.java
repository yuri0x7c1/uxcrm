package org.apache.ofbiz.content.content.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Content Meta Data
 */
public class ContentMetaData implements Serializable {

	public static final long serialVersionUID = 3291838248422136832L;
	public static final String NAME = "ContentMetaData";
	/**
	 * Content Id
	 */
	@Getter
	@Setter
	private String contentId;
	/**
	 * Meta Data Predicate Id
	 */
	@Getter
	@Setter
	private String metaDataPredicateId;
	/**
	 * Meta Data Value
	 */
	@Getter
	@Setter
	private String metaDataValue;
	/**
	 * Data Source Id
	 */
	@Getter
	@Setter
	private String dataSourceId;

	public enum Fields {
		contentId, metaDataPredicateId, metaDataValue, dataSourceId
	}

	public ContentMetaData(GenericValue value) {
		contentId = (String) value.get(Fields.contentId.name());
		metaDataPredicateId = (String) value.get(Fields.metaDataPredicateId
				.name());
		metaDataValue = (String) value.get(Fields.metaDataValue.name());
		dataSourceId = (String) value.get(Fields.dataSourceId.name());
	}

	public static ContentMetaData fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContentMetaData(value);
	}

	public static List<ContentMetaData> fromValues(List<GenericValue> values) {
		List<ContentMetaData> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContentMetaData(value));
		}
		return entities;
	}
}