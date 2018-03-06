package org.apache.ofbiz.content.data.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Data Category
 */
public class DataCategory implements Serializable {

	public static final long serialVersionUID = 7830937367708338176L;
	public static final String NAME = "DataCategory";
	/**
	 * Data Category Id
	 */
	@Getter
	@Setter
	private String dataCategoryId;
	/**
	 * Parent Category Id
	 */
	@Getter
	@Setter
	private String parentCategoryId;
	/**
	 * Category Name
	 */
	@Getter
	@Setter
	private String categoryName;

	public enum Fields {
		dataCategoryId, parentCategoryId, categoryName
	}

	public DataCategory(GenericValue value) {
		dataCategoryId = (String) value.get(Fields.dataCategoryId.name());
		parentCategoryId = (String) value.get(Fields.parentCategoryId.name());
		categoryName = (String) value.get(Fields.categoryName.name());
	}

	public static DataCategory fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new DataCategory(value);
	}

	public static List<DataCategory> fromValues(List<GenericValue> values) {
		List<DataCategory> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new DataCategory(value));
		}
		return entities;
	}
}