package org.apache.ofbiz.service.schedule;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Runtime Data
 */
@FieldNameConstants
public class RuntimeData implements Serializable {

	public static final long serialVersionUID = 2665734172237636608L;
	public static final String NAME = "RuntimeData";
	/**
	 * Runtime Data Id
	 */
	@Getter
	@Setter
	private String runtimeDataId;
	/**
	 * Runtime Info
	 */
	@Getter
	@Setter
	private String runtimeInfo;
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

	public RuntimeData(GenericValue value) {
		runtimeDataId = (String) value.get(FIELD_RUNTIME_DATA_ID);
		runtimeInfo = (String) value.get(FIELD_RUNTIME_INFO);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static RuntimeData fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new RuntimeData(value);
	}

	public static List<RuntimeData> fromValues(List<GenericValue> values) {
		List<RuntimeData> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new RuntimeData(value));
		}
		return entities;
	}
}