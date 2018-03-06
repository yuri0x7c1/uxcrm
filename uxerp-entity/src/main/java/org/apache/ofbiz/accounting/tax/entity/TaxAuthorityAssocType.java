package org.apache.ofbiz.accounting.tax.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Tax Authority Assoc Type
 */
public class TaxAuthorityAssocType implements Serializable {

	public static final long serialVersionUID = 1885017211450355712L;
	public static final String NAME = "TaxAuthorityAssocType";
	/**
	 * Tax Authority Assoc Type Id
	 */
	@Getter
	@Setter
	private String taxAuthorityAssocTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		taxAuthorityAssocTypeId, description
	}

	public TaxAuthorityAssocType(GenericValue value) {
		taxAuthorityAssocTypeId = (String) value
				.get(Fields.taxAuthorityAssocTypeId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static TaxAuthorityAssocType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TaxAuthorityAssocType(value);
	}

	public static List<TaxAuthorityAssocType> fromValues(
			List<GenericValue> values) {
		List<TaxAuthorityAssocType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TaxAuthorityAssocType(value));
		}
		return entities;
	}
}