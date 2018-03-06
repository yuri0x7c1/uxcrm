package org.apache.ofbiz.accounting.ledger.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Gl Xbrl Class
 */
public class GlXbrlClass implements Serializable {

	public static final long serialVersionUID = 2724508866969744384L;
	public static final String NAME = "GlXbrlClass";
	/**
	 * Gl Xbrl Class Id
	 */
	@Getter
	@Setter
	private String glXbrlClassId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		glXbrlClassId, description
	}

	public GlXbrlClass(GenericValue value) {
		glXbrlClassId = (String) value.get(Fields.glXbrlClassId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static GlXbrlClass fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new GlXbrlClass(value);
	}

	public static List<GlXbrlClass> fromValues(List<GenericValue> values) {
		List<GlXbrlClass> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GlXbrlClass(value));
		}
		return entities;
	}
}