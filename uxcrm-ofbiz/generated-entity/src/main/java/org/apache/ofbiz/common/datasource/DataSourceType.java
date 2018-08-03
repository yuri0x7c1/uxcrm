package org.apache.ofbiz.common.datasource;

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
public class DataSourceType implements Serializable {

	public static final long serialVersionUID = 4866691350566980608L;
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

	public enum Fields {
		dataSourceTypeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public DataSourceType(GenericValue value) {
		dataSourceTypeId = (String) value.get(Fields.dataSourceTypeId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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