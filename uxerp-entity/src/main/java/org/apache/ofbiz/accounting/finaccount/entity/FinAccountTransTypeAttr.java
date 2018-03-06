package org.apache.ofbiz.accounting.finaccount.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Fin Account Trans Type Attr
 */
public class FinAccountTransTypeAttr implements Serializable {

	public static final long serialVersionUID = 859008436721813504L;
	public static final String NAME = "FinAccountTransTypeAttr";
	/**
	 * Fin Account Trans Type Id
	 */
	@Getter
	@Setter
	private String finAccountTransTypeId;
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
		finAccountTransTypeId, attrName, description
	}

	public FinAccountTransTypeAttr(GenericValue value) {
		finAccountTransTypeId = (String) value.get(Fields.finAccountTransTypeId
				.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
	}

	public static FinAccountTransTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FinAccountTransTypeAttr(value);
	}

	public static List<FinAccountTransTypeAttr> fromValues(
			List<GenericValue> values) {
		List<FinAccountTransTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FinAccountTransTypeAttr(value));
		}
		return entities;
	}
}