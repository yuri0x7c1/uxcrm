package org.apache.ofbiz.common.uom.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Uom
 */
public class Uom implements Serializable {

	public static final long serialVersionUID = 2618812694123898880L;
	public static final String NAME = "Uom";
	/**
	 * Uom Id
	 */
	@Getter
	@Setter
	private String uomId;
	/**
	 * Uom Type Id
	 */
	@Getter
	@Setter
	private String uomTypeId;
	/**
	 * Abbreviation
	 */
	@Getter
	@Setter
	private String abbreviation;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		uomId, uomTypeId, abbreviation, description
	}

	public Uom(GenericValue value) {
		uomId = (String) value.get(Fields.uomId.name());
		uomTypeId = (String) value.get(Fields.uomTypeId.name());
		abbreviation = (String) value.get(Fields.abbreviation.name());
		description = (String) value.get(Fields.description.name());
	}

	public static Uom fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new Uom(value);
	}

	public static List<Uom> fromValues(List<GenericValue> values) {
		List<Uom> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new Uom(value));
		}
		return entities;
	}
}