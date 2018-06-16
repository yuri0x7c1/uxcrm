package org.apache.ofbiz.accounting.tax;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Tax Authority Gl Account Balance
 */
public class TaxAuthorityGlAccountBalance implements Serializable {

	public static final long serialVersionUID = 3375934305959989248L;
	public static final String NAME = "TaxAuthorityGlAccountBalance";
	/**
	 * Base Currency Uom Id
	 */
	@Getter
	@Setter
	private String baseCurrencyUomId;
	/**
	 * Tax Auth Party Id
	 */
	@Getter
	@Setter
	private String taxAuthPartyId;
	/**
	 * Gl Account Id
	 */
	@Getter
	@Setter
	private String glAccountId;
	/**
	 * Tax Auth Geo Id
	 */
	@Getter
	@Setter
	private String taxAuthGeoId;
	/**
	 * Organization Party Id
	 */
	@Getter
	@Setter
	private String organizationPartyId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;

	public enum Fields {
		baseCurrencyUomId, taxAuthPartyId, glAccountId, taxAuthGeoId, organizationPartyId, fromDate, roleTypeId, thruDate
	}

	public TaxAuthorityGlAccountBalance(GenericValue value) {
		baseCurrencyUomId = (String) value.get(Fields.baseCurrencyUomId.name());
		taxAuthPartyId = (String) value.get(Fields.taxAuthPartyId.name());
		glAccountId = (String) value.get(Fields.glAccountId.name());
		taxAuthGeoId = (String) value.get(Fields.taxAuthGeoId.name());
		organizationPartyId = (String) value.get(Fields.organizationPartyId
				.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
	}

	public static TaxAuthorityGlAccountBalance fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TaxAuthorityGlAccountBalance(value);
	}

	public static List<TaxAuthorityGlAccountBalance> fromValues(
			List<GenericValue> values) {
		List<TaxAuthorityGlAccountBalance> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TaxAuthorityGlAccountBalance(value));
		}
		return entities;
	}
}