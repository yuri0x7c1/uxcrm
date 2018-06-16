package org.apache.ofbiz.service.schedule;

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
public class RuntimeData implements Serializable {

	public static final long serialVersionUID = 8724410719730970624L;
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

	public enum Fields {
		runtimeDataId, runtimeInfo, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public RuntimeData(GenericValue value) {
		runtimeDataId = (String) value.get(Fields.runtimeDataId.name());
		runtimeInfo = (String) value.get(Fields.runtimeInfo.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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