package org.apache.ofbiz.accounting.tax.entity.view;

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

	public static final long serialVersionUID = 8721385642465566720L;
	public static final String NAME = "TaxAuthorityGlAccountBalance";
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
	 * Organization Party Id
	 */
	@Getter
	@Setter
	private String organizationPartyId;
	/**
	 * Gl Account Id
	 */
	@Getter
	@Setter
	private String glAccountId;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
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
	 * Base Currency Uom Id
	 */
	@Getter
	@Setter
	private String baseCurrencyUomId;

	public enum Fields {
		taxAuthGeoId, taxAuthPartyId, organizationPartyId, glAccountId, roleTypeId, fromDate, thruDate, baseCurrencyUomId
	}

	public TaxAuthorityGlAccountBalance(GenericValue value) {
		taxAuthGeoId = (String) value.get(Fields.taxAuthGeoId.name());
		taxAuthPartyId = (String) value.get(Fields.taxAuthPartyId.name());
		organizationPartyId = (String) value.get(Fields.organizationPartyId
				.name());
		glAccountId = (String) value.get(Fields.glAccountId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		baseCurrencyUomId = (String) value.get(Fields.baseCurrencyUomId.name());
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