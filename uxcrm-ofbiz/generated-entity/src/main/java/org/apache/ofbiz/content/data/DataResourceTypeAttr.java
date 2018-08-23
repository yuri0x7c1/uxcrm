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
 * Data Resource Type Attr
 */
@FieldNameConstants
public class DataResourceTypeAttr implements Serializable {

	public static final long serialVersionUID = 6242549346562193408L;
	public static final String NAME = "DataResourceTypeAttr";
	/**
	 * Data Resource Type Id
	 */
	@Getter
	@Setter
	private String dataResourceTypeId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
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

	public DataResourceTypeAttr(GenericValue value) {
		dataResourceTypeId = (String) value.get(FIELD_DATA_RESOURCE_TYPE_ID);
		attrName = (String) value.get(FIELD_ATTR_NAME);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static DataResourceTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new DataResourceTypeAttr(value);
	}

	public static List<DataResourceTypeAttr> fromValues(
			List<GenericValue> values) {
		List<DataResourceTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new DataResourceTypeAttr(value));
		}
		return entities;
	}
}