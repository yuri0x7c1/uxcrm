package org.apache.ofbiz.accounting.tax;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class TaxAuthorityGlAccountBalance implements Serializable {

	public static final long serialVersionUID = 8362349612899846144L;
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

	public TaxAuthorityGlAccountBalance(GenericValue value) {
		baseCurrencyUomId = (String) value.get(FIELD_BASE_CURRENCY_UOM_ID);
		taxAuthPartyId = (String) value.get(FIELD_TAX_AUTH_PARTY_ID);
		glAccountId = (String) value.get(FIELD_GL_ACCOUNT_ID);
		taxAuthGeoId = (String) value.get(FIELD_TAX_AUTH_GEO_ID);
		organizationPartyId = (String) value.get(FIELD_ORGANIZATION_PARTY_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
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