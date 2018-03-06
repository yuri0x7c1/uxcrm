package org.apache.ofbiz.product.cost.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Cost Component Attribute
 */
public class CostComponentAttribute implements Serializable {

	public static final long serialVersionUID = 1461474509931864064L;
	public static final String NAME = "CostComponentAttribute";
	/**
	 * Cost Component Id
	 */
	@Getter
	@Setter
	private String costComponentId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Attr Value
	 */
	@Getter
	@Setter
	private String attrValue;
	/**
	 * Attr Description
	 */
	@Getter
	@Setter
	private String attrDescription;

	public enum Fields {
		costComponentId, attrName, attrValue, attrDescription
	}

	public CostComponentAttribute(GenericValue value) {
		costComponentId = (String) value.get(Fields.costComponentId.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
		attrDescription = (String) value.get(Fields.attrDescription.name());
	}

	public static CostComponentAttribute fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CostComponentAttribute(value);
	}

	public static List<CostComponentAttribute> fromValues(
			List<GenericValue> values) {
		List<CostComponentAttribute> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CostComponentAttribute(value));
		}
		return entities;
	}
}