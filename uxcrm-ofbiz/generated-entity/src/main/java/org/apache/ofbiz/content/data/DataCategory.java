package org.apache.ofbiz.content.data;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class DataCategory implements Serializable {

	public static final long serialVersionUID = 4840853878073762816L;
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

	public DataCategory(GenericValue value) {
		dataCategoryId = (String) value.get(FIELD_DATA_CATEGORY_ID);
		parentCategoryId = (String) value.get(FIELD_PARENT_CATEGORY_ID);
		categoryName = (String) value.get(FIELD_CATEGORY_NAME);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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