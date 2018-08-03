package org.apache.ofbiz.common.datasource;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Data Source
 */
public class DataSource implements Serializable {

	public static final long serialVersionUID = 1519640089929925632L;
	public static final String NAME = "DataSource";
	/**
	 * Data Source Id
	 */
	@Getter
	@Setter
	private String dataSourceId;
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
		dataSourceId, dataSourceTypeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public DataSource(GenericValue value) {
		dataSourceId = (String) value.get(Fields.dataSourceId.name());
		dataSourceTypeId = (String) value.get(Fields.dataSourceTypeId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static DataSource fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new DataSource(value);
	}

	public static List<DataSource> fromValues(List<GenericValue> values) {
		List<DataSource> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new DataSource(value));
		}
		return entities;
	}
}