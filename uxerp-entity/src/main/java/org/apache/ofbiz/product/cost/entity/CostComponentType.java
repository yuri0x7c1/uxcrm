package org.apache.ofbiz.product.cost.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Cost Component Type
 */
public class CostComponentType implements Serializable {

	public static final long serialVersionUID = 6419639735144206336L;
	public static final String NAME = "CostComponentType";
	/**
	 * Cost Component Type Id
	 */
	@Getter
	@Setter
	private String costComponentTypeId;
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
		costComponentTypeId, parentTypeId, hasTable, description
	}

	public CostComponentType(GenericValue value) {
		costComponentTypeId = (String) value.get(Fields.costComponentTypeId
				.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static CostComponentType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CostComponentType(value);
	}

	public static List<CostComponentType> fromValues(List<GenericValue> values) {
		List<CostComponentType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CostComponentType(value));
		}
		return entities;
	}
}