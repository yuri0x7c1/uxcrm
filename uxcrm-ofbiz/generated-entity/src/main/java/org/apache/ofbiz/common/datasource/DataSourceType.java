package org.apache.ofbiz.common.datasource;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Data Source Type
 */
@FieldNameConstants
public class DataSourceType implements Serializable {

	public static final long serialVersionUID = 4253065088843961344L;
	public static final String NAME = "DataSourceType";
	/**
	 * Data Source Type Id
	 */
	@Getter
	@Setter
	private String dataSourceTypeId;
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

	public DataSourceType(GenericValue value) {
		dataSourceTypeId = (String) value.get(FIELD_DATA_SOURCE_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static DataSourceType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new DataSourceType(value);
	}

	public static List<DataSourceType> fromValues(List<GenericValue> values) {
		List<DataSourceType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new DataSourceType(value));
		}
		return entities;
	}
}