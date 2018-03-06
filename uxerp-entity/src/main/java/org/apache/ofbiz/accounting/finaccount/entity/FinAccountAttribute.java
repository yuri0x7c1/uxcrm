package org.apache.ofbiz.accounting.finaccount.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Fin Account Attribute
 */
public class FinAccountAttribute implements Serializable {

	public static final long serialVersionUID = 2716891905596580864L;
	public static final String NAME = "FinAccountAttribute";
	/**
	 * Fin Account Id
	 */
	@Getter
	@Setter
	private String finAccountId;
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
		finAccountId, attrName, attrValue, attrDescription
	}

	public FinAccountAttribute(GenericValue value) {
		finAccountId = (String) value.get(Fields.finAccountId.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
		attrDescription = (String) value.get(Fields.attrDescription.name());
	}

	public static FinAccountAttribute fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FinAccountAttribute(value);
	}

	public static List<FinAccountAttribute> fromValues(List<GenericValue> values) {
		List<FinAccountAttribute> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FinAccountAttribute(value));
		}
		return entities;
	}
}