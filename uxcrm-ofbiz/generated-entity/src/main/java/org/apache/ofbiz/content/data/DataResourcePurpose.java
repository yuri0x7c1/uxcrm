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
 * Data Resource Purpose
 */
@FieldNameConstants
public class DataResourcePurpose implements Serializable {

	public static final long serialVersionUID = 1705118468638639104L;
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

	public DataResourcePurpose(GenericValue value) {
		dataResourceId = (String) value.get(FIELD_DATA_RESOURCE_ID);
		contentPurposeTypeId = (String) value
				.get(FIELD_CONTENT_PURPOSE_TYPE_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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