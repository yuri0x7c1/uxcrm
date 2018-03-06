package org.apache.ofbiz.accounting.finaccount.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Fin Account Trans Attribute
 */
public class FinAccountTransAttribute implements Serializable {

	public static final long serialVersionUID = 6333462934563172352L;
	public static final String NAME = "FinAccountTransAttribute";
	/**
	 * Fin Account Trans Id
	 */
	@Getter
	@Setter
	private String finAccountTransId;
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
		finAccountTransId, attrName, attrValue, attrDescription
	}

	public FinAccountTransAttribute(GenericValue value) {
		finAccountTransId = (String) value.get(Fields.finAccountTransId.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
		attrDescription = (String) value.get(Fields.attrDescription.name());
	}

	public static FinAccountTransAttribute fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FinAccountTransAttribute(value);
	}

	public static List<FinAccountTransAttribute> fromValues(
			List<GenericValue> values) {
		List<FinAccountTransAttribute> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FinAccountTransAttribute(value));
		}
		return entities;
	}
}