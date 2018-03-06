package org.apache.ofbiz.common.period.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Period Type
 */
public class PeriodType implements Serializable {

	public static final long serialVersionUID = 2910934974507624448L;
	public static final String NAME = "PeriodType";
	/**
	 * Period Type Id
	 */
	@Getter
	@Setter
	private String periodTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Period Length
	 */
	@Getter
	@Setter
	private Long periodLength;
	/**
	 * Uom Id
	 */
	@Getter
	@Setter
	private String uomId;

	public enum Fields {
		periodTypeId, description, periodLength, uomId
	}

	public PeriodType(GenericValue value) {
		periodTypeId = (String) value.get(Fields.periodTypeId.name());
		description = (String) value.get(Fields.description.name());
		periodLength = (Long) value.get(Fields.periodLength.name());
		uomId = (String) value.get(Fields.uomId.name());
	}

	public static PeriodType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PeriodType(value);
	}

	public static List<PeriodType> fromValues(List<GenericValue> values) {
		List<PeriodType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PeriodType(value));
		}
		return entities;
	}
}