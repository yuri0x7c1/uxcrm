package org.apache.ofbiz.accounting.tax.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Tax Authority Assoc
 */
public class TaxAuthorityAssoc implements Serializable {

	public static final long serialVersionUID = 4149285935120384L;
	public static final String NAME = "TaxAuthorityAssoc";
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
	 * To Tax Auth Geo Id
	 */
	@Getter
	@Setter
	private String toTaxAuthGeoId;
	/**
	 * To Tax Auth Party Id
	 */
	@Getter
	@Setter
	private String toTaxAuthPartyId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Tax Authority Assoc Type Id
	 */
	@Getter
	@Setter
	private String taxAuthorityAssocTypeId;

	public enum Fields {
		taxAuthGeoId, taxAuthPartyId, toTaxAuthGeoId, toTaxAuthPartyId, fromDate, thruDate, taxAuthorityAssocTypeId
	}

	public TaxAuthorityAssoc(GenericValue value) {
		taxAuthGeoId = (String) value.get(Fields.taxAuthGeoId.name());
		taxAuthPartyId = (String) value.get(Fields.taxAuthPartyId.name());
		toTaxAuthGeoId = (String) value.get(Fields.toTaxAuthGeoId.name());
		toTaxAuthPartyId = (String) value.get(Fields.toTaxAuthPartyId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		taxAuthorityAssocTypeId = (String) value
				.get(Fields.taxAuthorityAssocTypeId.name());
	}

	public static TaxAuthorityAssoc fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TaxAuthorityAssoc(value);
	}

	public static List<TaxAuthorityAssoc> fromValues(List<GenericValue> values) {
		List<TaxAuthorityAssoc> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TaxAuthorityAssoc(value));
		}
		return entities;
	}
}