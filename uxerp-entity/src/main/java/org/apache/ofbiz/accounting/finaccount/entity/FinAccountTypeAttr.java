package org.apache.ofbiz.accounting.finaccount.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Fin Account Type Attr
 */
public class FinAccountTypeAttr implements Serializable {

	public static final long serialVersionUID = 4638269620758193152L;
	public static final String NAME = "FinAccountTypeAttr";
	/**
	 * Fin Account Type Id
	 */
	@Getter
	@Setter
	private String finAccountTypeId;
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
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		finAccountTypeId, attrName, attrValue, description
	}

	public FinAccountTypeAttr(GenericValue value) {
		finAccountTypeId = (String) value.get(Fields.finAccountTypeId.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
		description = (String) value.get(Fields.description.name());
	}

	public static FinAccountTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FinAccountTypeAttr(value);
	}

	public static List<FinAccountTypeAttr> fromValues(List<GenericValue> values) {
		List<FinAccountTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FinAccountTypeAttr(value));
		}
		return entities;
	}
}