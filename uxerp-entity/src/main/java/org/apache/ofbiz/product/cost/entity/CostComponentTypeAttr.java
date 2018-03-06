package org.apache.ofbiz.product.cost.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Cost Component Type Attr
 */
public class CostComponentTypeAttr implements Serializable {

	public static final long serialVersionUID = 2810457613535371264L;
	public static final String NAME = "CostComponentTypeAttr";
	/**
	 * Cost Component Type Id
	 */
	@Getter
	@Setter
	private String costComponentTypeId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		costComponentTypeId, attrName, description
	}

	public CostComponentTypeAttr(GenericValue value) {
		costComponentTypeId = (String) value.get(Fields.costComponentTypeId
				.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
	}

	public static CostComponentTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CostComponentTypeAttr(value);
	}

	public static List<CostComponentTypeAttr> fromValues(
			List<GenericValue> values) {
		List<CostComponentTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CostComponentTypeAttr(value));
		}
		return entities;
	}
}