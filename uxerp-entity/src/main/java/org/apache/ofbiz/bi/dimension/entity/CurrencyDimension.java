package org.apache.ofbiz.bi.dimension.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Currency Dimension
 */
public class CurrencyDimension implements Serializable {

	public static final long serialVersionUID = 1554717541876572160L;
	public static final String NAME = "CurrencyDimension";
	/**
	 * Dimension Id
	 */
	@Getter
	@Setter
	private String dimensionId;
	/**
	 * Currency Id
	 */
	@Getter
	@Setter
	private String currencyId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		dimensionId, currencyId, description
	}

	public CurrencyDimension(GenericValue value) {
		dimensionId = (String) value.get(Fields.dimensionId.name());
		currencyId = (String) value.get(Fields.currencyId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static CurrencyDimension fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CurrencyDimension(value);
	}

	public static List<CurrencyDimension> fromValues(List<GenericValue> values) {
		List<CurrencyDimension> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CurrencyDimension(value));
		}
		return entities;
	}
}