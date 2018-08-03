package org.apache.ofbiz.content.data;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Data Category
 */
public class DataCategory implements Serializable {

	public static final long serialVersionUID = 1658797583441411072L;
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
	/**
	 * Last Updated Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedStamp;
	/**
	 * Last Updated Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedTxStamp;
	/**
	 * Created Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdStamp;
	/**
	 * Created Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdTxStamp;

	public enum Fields {
		dataCategoryId, parentCategoryId, categoryName, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public DataCategory(GenericValue value) {
		dataCategoryId = (String) value.get(Fields.dataCategoryId.name());
		parentCategoryId = (String) value.get(Fields.parentCategoryId.name());
		categoryName = (String) value.get(Fields.categoryName.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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