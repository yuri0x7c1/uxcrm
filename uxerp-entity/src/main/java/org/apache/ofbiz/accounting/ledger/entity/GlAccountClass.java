package org.apache.ofbiz.accounting.ledger.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Gl Account Class
 */
public class GlAccountClass implements Serializable {

	public static final long serialVersionUID = 2400273187748063232L;
	public static final String NAME = "GlAccountClass";
	/**
	 * Gl Account Class Id
	 */
	@Getter
	@Setter
	private String glAccountClassId;
	/**
	 * Parent Class Id
	 */
	@Getter
	@Setter
	private String parentClassId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Is Asset Class
	 */
	@Getter
	@Setter
	private String isAssetClass;

	public enum Fields {
		glAccountClassId, parentClassId, description, isAssetClass
	}

	public GlAccountClass(GenericValue value) {
		glAccountClassId = (String) value.get(Fields.glAccountClassId.name());
		parentClassId = (String) value.get(Fields.parentClassId.name());
		description = (String) value.get(Fields.description.name());
		isAssetClass = (String) value.get(Fields.isAssetClass.name());
	}

	public static GlAccountClass fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new GlAccountClass(value);
	}

	public static List<GlAccountClass> fromValues(List<GenericValue> values) {
		List<GlAccountClass> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GlAccountClass(value));
		}
		return entities;
	}
}