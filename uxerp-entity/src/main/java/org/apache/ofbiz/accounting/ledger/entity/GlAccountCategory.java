package org.apache.ofbiz.accounting.ledger.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Gl Account Category
 */
public class GlAccountCategory implements Serializable {

	public static final long serialVersionUID = 1421324878290154496L;
	public static final String NAME = "GlAccountCategory";
	/**
	 * Gl Account Category Id
	 */
	@Getter
	@Setter
	private String glAccountCategoryId;
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
		glAccountCategoryId, glAccountCategoryTypeId, description
	}

	public GlAccountCategory(GenericValue value) {
		glAccountCategoryId = (String) value.get(Fields.glAccountCategoryId
				.name());
		glAccountCategoryTypeId = (String) value
				.get(Fields.glAccountCategoryTypeId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static GlAccountCategory fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new GlAccountCategory(value);
	}

	public static List<GlAccountCategory> fromValues(List<GenericValue> values) {
		List<GlAccountCategory> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GlAccountCategory(value));
		}
		return entities;
	}
}