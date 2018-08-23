package org.apache.ofbiz.accounting.tax;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Tax Auth Info And Detail
 */
@FieldNameConstants
public class PartyTaxAuthInfoAndDetail implements Serializable {

	public static final long serialVersionUID = 3400235834960694272L;
	public static final String NAME = "PartyTaxAuthInfoAndDetail";
	/**
	 * Tax Auth Party Id
	 */
	@Getter
	@Setter
	private String taxAuthPartyId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Party Tax Id
	 */
	@Getter
	@Setter
	private String partyTaxId;
	/**
	 * Is Nexus
	 */
	@Getter
	@Setter
	private String isNexus;
	/**
	 * Tax Auth Geo Id
	 */
	@Getter
	@Setter
	private String taxAuthGeoId;
	/**
	 * Is Exempt
	 */
	@Getter
	@Setter
	private String isExempt;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
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

	public PartyTaxAuthInfoAndDetail(GenericValue value) {
		taxAuthPartyId = (String) value.get(FIELD_TAX_AUTH_PARTY_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		partyTaxId = (String) value.get(FIELD_PARTY_TAX_ID);
		isNexus = (String) value.get(FIELD_IS_NEXUS);
		taxAuthGeoId = (String) value.get(FIELD_TAX_AUTH_GEO_ID);
		isExempt = (String) value.get(FIELD_IS_EXEMPT);
		partyId = (String) value.get(FIELD_PARTY_ID);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		comments = (String) value.get(FIELD_COMMENTS);
		tickerSymbol = (String) value.get(FIELD_TICKER_SYMBOL);
		logoImageUrl = (String) value.get(FIELD_LOGO_IMAGE_URL);
		groupName = (String) value.get(FIELD_GROUP_NAME);
		groupNameLocal = (String) value.get(FIELD_GROUP_NAME_LOCAL);
		numEmployees = (Long) value.get(FIELD_NUM_EMPLOYEES);
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

	public static PartyTaxAuthInfoAndDetail fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyTaxAuthInfoAndDetail(value);
	}

	public static List<PartyTaxAuthInfoAndDetail> fromValues(
			List<GenericValue> values) {
		List<PartyTaxAuthInfoAndDetail> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyTaxAuthInfoAndDetail(value));
		}
		return entities;
	}
}