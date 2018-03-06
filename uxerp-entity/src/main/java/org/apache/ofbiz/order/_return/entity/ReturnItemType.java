package org.apache.ofbiz.order._return.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Return Item Type
 */
public class ReturnItemType implements Serializable {

	public static final long serialVersionUID = 2713906602645249024L;
	public static final String NAME = "ReturnItemType";
	/**
	 * Return Item Type Id
	 */
	@Getter
	@Setter
	private String returnItemTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		returnItemTypeId, parentTypeId, description
	}

	public ReturnItemType(GenericValue value) {
		returnItemTypeId = (String) value.get(Fields.returnItemTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static ReturnItemType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ReturnItemType(value);
	}

	public static List<ReturnItemType> fromValues(List<GenericValue> values) {
		List<ReturnItemType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ReturnItemType(value));
		}
		return entities;
	}
}