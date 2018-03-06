package org.apache.ofbiz.accounting.tax.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Tax Authority Rate Type
 */
public class TaxAuthorityRateType implements Serializable {

	public static final long serialVersionUID = 5390253145211484160L;
	public static final String NAME = "TaxAuthorityRateType";
	/**
	 * Tax Authority Rate Type Id
	 */
	@Getter
	@Setter
	private String taxAuthorityRateTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		taxAuthorityRateTypeId, description
	}

	public TaxAuthorityRateType(GenericValue value) {
		taxAuthorityRateTypeId = (String) value
				.get(Fields.taxAuthorityRateTypeId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static TaxAuthorityRateType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TaxAuthorityRateType(value);
	}

	public static List<TaxAuthorityRateType> fromValues(
			List<GenericValue> values) {
		List<TaxAuthorityRateType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TaxAuthorityRateType(value));
		}
		return entities;
	}
}