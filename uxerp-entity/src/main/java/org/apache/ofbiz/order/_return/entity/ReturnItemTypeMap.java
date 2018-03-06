package org.apache.ofbiz.order._return.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Return Item Type Map
 */
public class ReturnItemTypeMap implements Serializable {

	public static final long serialVersionUID = 9089594035154467840L;
	public static final String NAME = "ReturnItemTypeMap";
	/**
	 * Return Item Map Key
	 */
	@Getter
	@Setter
	private String returnItemMapKey;
	/**
	 * Return Header Type Id
	 */
	@Getter
	@Setter
	private String returnHeaderTypeId;
	/**
	 * Return Item Type Id
	 */
	@Getter
	@Setter
	private String returnItemTypeId;

	public enum Fields {
		returnItemMapKey, returnHeaderTypeId, returnItemTypeId
	}

	public ReturnItemTypeMap(GenericValue value) {
		returnItemMapKey = (String) value.get(Fields.returnItemMapKey.name());
		returnHeaderTypeId = (String) value.get(Fields.returnHeaderTypeId
				.name());
		returnItemTypeId = (String) value.get(Fields.returnItemTypeId.name());
	}

	public static ReturnItemTypeMap fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ReturnItemTypeMap(value);
	}

	public static List<ReturnItemTypeMap> fromValues(List<GenericValue> values) {
		List<ReturnItemTypeMap> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ReturnItemTypeMap(value));
		}
		return entities;
	}
}