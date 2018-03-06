package org.apache.ofbiz.accounting.rate.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Rate Type
 */
public class RateType implements Serializable {

	public static final long serialVersionUID = 5920236479751305216L;
	public static final String NAME = "RateType";
	/**
	 * Rate Type Id
	 */
	@Getter
	@Setter
	private String rateTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		rateTypeId, description
	}

	public RateType(GenericValue value) {
		rateTypeId = (String) value.get(Fields.rateTypeId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static RateType fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new RateType(value);
	}

	public static List<RateType> fromValues(List<GenericValue> values) {
		List<RateType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new RateType(value));
		}
		return entities;
	}
}