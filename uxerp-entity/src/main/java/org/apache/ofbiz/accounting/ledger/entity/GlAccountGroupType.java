package org.apache.ofbiz.accounting.ledger.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Gl Account Group Type
 */
public class GlAccountGroupType implements Serializable {

	public static final long serialVersionUID = 8193613804602261504L;
	public static final String NAME = "GlAccountGroupType";
	/**
	 * Gl Account Group Type Id
	 */
	@Getter
	@Setter
	private String glAccountGroupTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		glAccountGroupTypeId, description
	}

	public GlAccountGroupType(GenericValue value) {
		glAccountGroupTypeId = (String) value.get(Fields.glAccountGroupTypeId
				.name());
		description = (String) value.get(Fields.description.name());
	}

	public static GlAccountGroupType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new GlAccountGroupType(value);
	}

	public static List<GlAccountGroupType> fromValues(List<GenericValue> values) {
		List<GlAccountGroupType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GlAccountGroupType(value));
		}
		return entities;
	}
}