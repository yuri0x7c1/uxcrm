package org.apache.ofbiz.accounting.tax.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Tax Authority Category
 */
public class TaxAuthorityCategory implements Serializable {

	public static final long serialVersionUID = 44257686798029824L;
	public static final String NAME = "TaxAuthorityCategory";
	/**
	 * Tax Auth Geo Id
	 */
	@Getter
	@Setter
	private String taxAuthGeoId;
	/**
	 * Tax Auth Party Id
	 */
	@Getter
	@Setter
	private String taxAuthPartyId;
	/**
	 * Product Category Id
	 */
	@Getter
	@Setter
	private String productCategoryId;

	public enum Fields {
		taxAuthGeoId, taxAuthPartyId, productCategoryId
	}

	public TaxAuthorityCategory(GenericValue value) {
		taxAuthGeoId = (String) value.get(Fields.taxAuthGeoId.name());
		taxAuthPartyId = (String) value.get(Fields.taxAuthPartyId.name());
		productCategoryId = (String) value.get(Fields.productCategoryId.name());
	}

	public static TaxAuthorityCategory fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TaxAuthorityCategory(value);
	}

	public static List<TaxAuthorityCategory> fromValues(
			List<GenericValue> values) {
		List<TaxAuthorityCategory> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TaxAuthorityCategory(value));
		}
		return entities;
	}
}