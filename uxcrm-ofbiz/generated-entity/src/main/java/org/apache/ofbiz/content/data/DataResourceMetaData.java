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
 * Data Resource Meta Data
 */
@FieldNameConstants
public class DataResourceMetaData implements Serializable {

	public static final long serialVersionUID = 6085008183400934400L;
	public static final String NAME = "DataResourceMetaData";
	/**
	 * Data Resource Id
	 */
	@Getter
	@Setter
	private String dataResourceId;
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

	public DataResourceMetaData(GenericValue value) {
		dataResourceId = (String) value.get(FIELD_DATA_RESOURCE_ID);
		metaDataPredicateId = (String) value.get(FIELD_META_DATA_PREDICATE_ID);
		metaDataValue = (String) value.get(FIELD_META_DATA_VALUE);
		dataSourceId = (String) value.get(FIELD_DATA_SOURCE_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static DataResourceMetaData fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new DataResourceMetaData(value);
	}

	public static List<DataResourceMetaData> fromValues(
			List<GenericValue> values) {
		List<DataResourceMetaData> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new DataResourceMetaData(value));
		}
		return entities;
	}
}