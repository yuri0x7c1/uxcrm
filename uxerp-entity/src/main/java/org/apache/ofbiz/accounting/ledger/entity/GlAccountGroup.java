package org.apache.ofbiz.accounting.ledger.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Gl Account Group
 */
public class GlAccountGroup implements Serializable {

	public static final long serialVersionUID = 4005237808803340288L;
	public static final String NAME = "GlAccountGroup";
	/**
	 * Gl Account Group Id
	 */
	@Getter
	@Setter
	private String glAccountGroupId;
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
		glAccountGroupId, glAccountGroupTypeId, description
	}

	public GlAccountGroup(GenericValue value) {
		glAccountGroupId = (String) value.get(Fields.glAccountGroupId.name());
		glAccountGroupTypeId = (String) value.get(Fields.glAccountGroupTypeId
				.name());
		description = (String) value.get(Fields.description.name());
	}

	public static GlAccountGroup fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new GlAccountGroup(value);
	}

	public static List<GlAccountGroup> fromValues(List<GenericValue> values) {
		List<GlAccountGroup> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GlAccountGroup(value));
		}
		return entities;
	}
}