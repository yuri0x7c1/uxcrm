package org.apache.ofbiz.content.data;

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
public class DataResourceMetaData implements Serializable {

	public static final long serialVersionUID = 6685188977180515328L;
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

	public enum Fields {
		dataResourceId, metaDataPredicateId, metaDataValue, dataSourceId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public DataResourceMetaData(GenericValue value) {
		dataResourceId = (String) value.get(Fields.dataResourceId.name());
		metaDataPredicateId = (String) value.get(Fields.metaDataPredicateId
				.name());
		metaDataValue = (String) value.get(Fields.metaDataValue.name());
		dataSourceId = (String) value.get(Fields.dataSourceId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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