package org.apache.ofbiz.service.schedule.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Runtime Data
 */
public class RuntimeData implements Serializable {

	public static final long serialVersionUID = 6913207155279313920L;
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

	public enum Fields {
		runtimeDataId, runtimeInfo
	}

	public RuntimeData(GenericValue value) {
		runtimeDataId = (String) value.get(Fields.runtimeDataId.name());
		runtimeInfo = (String) value.get(Fields.runtimeInfo.name());
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