package org.apache.ofbiz.accounting.ledger.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Gl Fiscal Type
 */
public class GlFiscalType implements Serializable {

	public static final long serialVersionUID = 9001189271743550464L;
	public static final String NAME = "GlFiscalType";
	/**
	 * Gl Fiscal Type Id
	 */
	@Getter
	@Setter
	private String glFiscalTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		glFiscalTypeId, description
	}

	public GlFiscalType(GenericValue value) {
		glFiscalTypeId = (String) value.get(Fields.glFiscalTypeId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static GlFiscalType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new GlFiscalType(value);
	}

	public static List<GlFiscalType> fromValues(List<GenericValue> values) {
		List<GlFiscalType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GlFiscalType(value));
		}
		return entities;
	}
}