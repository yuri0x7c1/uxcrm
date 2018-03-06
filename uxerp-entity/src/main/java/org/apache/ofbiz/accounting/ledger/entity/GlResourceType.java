package org.apache.ofbiz.accounting.ledger.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Gl Resource Type
 */
public class GlResourceType implements Serializable {

	public static final long serialVersionUID = 5921105707398753280L;
	public static final String NAME = "GlResourceType";
	/**
	 * Gl Resource Type Id
	 */
	@Getter
	@Setter
	private String glResourceTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		glResourceTypeId, description
	}

	public GlResourceType(GenericValue value) {
		glResourceTypeId = (String) value.get(Fields.glResourceTypeId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static GlResourceType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new GlResourceType(value);
	}

	public static List<GlResourceType> fromValues(List<GenericValue> values) {
		List<GlResourceType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GlResourceType(value));
		}
		return entities;
	}
}