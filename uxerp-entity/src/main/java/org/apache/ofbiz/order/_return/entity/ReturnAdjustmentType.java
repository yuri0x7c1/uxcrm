package org.apache.ofbiz.order._return.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Return Adjustment Type
 */
public class ReturnAdjustmentType implements Serializable {

	public static final long serialVersionUID = 4220915001092356096L;
	public static final String NAME = "ReturnAdjustmentType";
	/**
	 * Return Adjustment Type Id
	 */
	@Getter
	@Setter
	private String returnAdjustmentTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Has Table
	 */
	@Getter
	@Setter
	private String hasTable;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		returnAdjustmentTypeId, parentTypeId, hasTable, description
	}

	public ReturnAdjustmentType(GenericValue value) {
		returnAdjustmentTypeId = (String) value
				.get(Fields.returnAdjustmentTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static ReturnAdjustmentType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ReturnAdjustmentType(value);
	}

	public static List<ReturnAdjustmentType> fromValues(
			List<GenericValue> values) {
		List<ReturnAdjustmentType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ReturnAdjustmentType(value));
		}
		return entities;
	}
}