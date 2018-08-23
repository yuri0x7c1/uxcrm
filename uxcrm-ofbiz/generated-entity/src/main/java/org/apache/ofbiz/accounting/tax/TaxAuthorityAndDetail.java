package org.apache.ofbiz.accounting.tax;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Tax Authority And Detail
 */
@FieldNameConstants
public class TaxAuthorityAndDetail implements Serializable {

	public static final long serialVersionUID = 547095983503593472L;
	public static final String NAME = "TaxAuthorityAndDetail";
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
	 * Include Tax In Price
	 */
	@Getter
	@Setter
	private String includeTaxInPrice;
	/**
	 * Tax Auth Geo Id
	 */
	@Getter
	@Setter
	private String taxAuthGeoId;
	/**
	 * Tax Id Format Pattern
	 */
	@Getter
	@Setter
	private String taxIdFormatPattern;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Ticker Symbol
	 */
	@Getter
	@Setter
	private String tickerSymbol;
	/**
	 * Logo Image Url
	 */
	@Getter
	@Setter
	private String logoImageUrl;
	/**
	 * Group Name
	 */
	@Getter
	@Setter
	private String groupName;
	/**
	 * Group Name Local
	 */
	@Getter
	@Setter
	private String groupNameLocal;
	/**
	 * Num Employees
	 */
	@Getter
	@Setter
	private Long numEmployees;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Office Site Name
	 */
	@Getter
	@Setter
	private String officeSiteName;
	/**
	 * Annual Revenue
	 */
	@Getter
	@Setter
	private BigDecimal annualRevenue;
	/**
	 * Geo Name
	 */
	@Getter
	@Setter
	private String geoName;
	/**
	 * Geo Type Id
	 */
	@Getter
	@Setter
	private String geoTypeId;
	/**
	 * Geo Id
	 */
	@Getter
	@Setter
	private String geoId;
	/**
	 * Geo Code
	 */
	@Getter
	@Setter
	private String geoCode;
	/**
	 * Abbreviation
	 */
	@Getter
	@Setter
	private String abbreviation;
	/**
	 * Geo Sec Code
	 */
	@Getter
	@Setter
	private String geoSecCode;
	/**
	 * Well Known Text
	 */
	@Getter
	@Setter
	private String wellKnownText;

	public TaxAuthorityAndDetail(GenericValue value) {
		taxAuthPartyId = (String) value.get(FIELD_TAX_AUTH_PARTY_ID);
		requireTaxIdForExemption = (String) value
				.get(FIELD_REQUIRE_TAX_ID_FOR_EXEMPTION);
		includeTaxInPrice = (String) value.get(FIELD_INCLUDE_TAX_IN_PRICE);
		taxAuthGeoId = (String) value.get(FIELD_TAX_AUTH_GEO_ID);
		taxIdFormatPattern = (String) value.get(FIELD_TAX_ID_FORMAT_PATTERN);
		comments = (String) value.get(FIELD_COMMENTS);
		tickerSymbol = (String) value.get(FIELD_TICKER_SYMBOL);
		logoImageUrl = (String) value.get(FIELD_LOGO_IMAGE_URL);
		groupName = (String) value.get(FIELD_GROUP_NAME);
		groupNameLocal = (String) value.get(FIELD_GROUP_NAME_LOCAL);
		numEmployees = (Long) value.get(FIELD_NUM_EMPLOYEES);
		partyId = (String) value.get(FIELD_PARTY_ID);
		officeSiteName = (String) value.get(FIELD_OFFICE_SITE_NAME);
		annualRevenue = (BigDecimal) value.get(FIELD_ANNUAL_REVENUE);
		geoName = (String) value.get(FIELD_GEO_NAME);
		geoTypeId = (String) value.get(FIELD_GEO_TYPE_ID);
		geoId = (String) value.get(FIELD_GEO_ID);
		geoCode = (String) value.get(FIELD_GEO_CODE);
		abbreviation = (String) value.get(FIELD_ABBREVIATION);
		geoSecCode = (String) value.get(FIELD_GEO_SEC_CODE);
		wellKnownText = (String) value.get(FIELD_WELL_KNOWN_TEXT);
	}

	public static TaxAuthorityAndDetail fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TaxAuthorityAndDetail(value);
	}

	public static List<TaxAuthorityAndDetail> fromValues(
			List<GenericValue> values) {
		List<TaxAuthorityAndDetail> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TaxAuthorityAndDetail(value));
		}
		return entities;
	}
}