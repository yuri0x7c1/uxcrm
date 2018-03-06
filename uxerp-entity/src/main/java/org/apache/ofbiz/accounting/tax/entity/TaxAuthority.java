package org.apache.ofbiz.accounting.tax.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Tax Authority
 */
public class TaxAuthority implements Serializable {

	public static final long serialVersionUID = 4057233953681947648L;
	public static final String NAME = "TaxAuthority";
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
	 * Require Tax Id For Exemption
	 */
	@Getter
	@Setter
	private String requireTaxIdForExemption;
	/**
	 * Tax Id Format Pattern
	 */
	@Getter
	@Setter
	private String taxIdFormatPattern;
	/**
	 * Include Tax In Price
	 */
	@Getter
	@Setter
	private String includeTaxInPrice;

	public enum Fields {
		taxAuthGeoId, taxAuthPartyId, requireTaxIdForExemption, taxIdFormatPattern, includeTaxInPrice
	}

	public TaxAuthority(GenericValue value) {
		taxAuthGeoId = (String) value.get(Fields.taxAuthGeoId.name());
		taxAuthPartyId = (String) value.get(Fields.taxAuthPartyId.name());
		requireTaxIdForExemption = (String) value
				.get(Fields.requireTaxIdForExemption.name());
		taxIdFormatPattern = (String) value.get(Fields.taxIdFormatPattern
				.name());
		includeTaxInPrice = (String) value.get(Fields.includeTaxInPrice.name());
	}

	public static TaxAuthority fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TaxAuthority(value);
	}

	public static List<TaxAuthority> fromValues(List<GenericValue> values) {
		List<TaxAuthority> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TaxAuthority(value));
		}
		return entities;
	}
}