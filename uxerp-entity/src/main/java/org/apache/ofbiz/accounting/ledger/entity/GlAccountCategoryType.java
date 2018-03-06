package org.apache.ofbiz.accounting.ledger.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Gl Account Category Type
 */
public class GlAccountCategoryType implements Serializable {

	public static final long serialVersionUID = 2834371230903878656L;
	public static final String NAME = "GlAccountCategoryType";
	/**
	 * Gl Account Category Type Id
	 */
	@Getter
	@Setter
	private String glAccountCategoryTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		glAccountCategoryTypeId, description
	}

	public GlAccountCategoryType(GenericValue value) {
		glAccountCategoryTypeId = (String) value
				.get(Fields.glAccountCategoryTypeId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static GlAccountCategoryType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new GlAccountCategoryType(value);
	}

	public static List<GlAccountCategoryType> fromValues(
			List<GenericValue> values) {
		List<GlAccountCategoryType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GlAccountCategoryType(value));
		}
		return entities;
	}
}