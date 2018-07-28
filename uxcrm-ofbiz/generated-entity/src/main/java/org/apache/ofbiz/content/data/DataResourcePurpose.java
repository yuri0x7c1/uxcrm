package org.apache.ofbiz.content.data;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Data Resource Purpose
 */
public class DataResourcePurpose implements Serializable {

	public static final long serialVersionUID = 2024252431836484608L;
	public static final String NAME = "DataResourcePurpose";
	/**
	 * Data Resource Id
	 */
	@Getter
	@Setter
	private String dataResourceId;
	/**
	 * Content Purpose Type Id
	 */
	@Getter
	@Setter
	private String contentPurposeTypeId;
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
		dataResourceId, contentPurposeTypeId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public DataResourcePurpose(GenericValue value) {
		dataResourceId = (String) value.get(Fields.dataResourceId.name());
		contentPurposeTypeId = (String) value.get(Fields.contentPurposeTypeId
				.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static DataResourcePurpose fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new DataResourcePurpose(value);
	}

	public static List<DataResourcePurpose> fromValues(List<GenericValue> values) {
		List<DataResourcePurpose> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new DataResourcePurpose(value));
		}
		return entities;
	}
}