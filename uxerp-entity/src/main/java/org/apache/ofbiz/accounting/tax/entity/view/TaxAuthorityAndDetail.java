package org.apache.ofbiz.accounting.tax.entity.view;

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
public class TaxAuthorityAndDetail implements Serializable {

	public static final long serialVersionUID = 5135532691105122304L;
	public static final String NAME = "TaxAuthorityAndDetail";
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
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
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
	 * Num Employees
	 */
	@Getter
	@Setter
	private Long numEmployees;
	/**
	 * Ticker Symbol
	 */
	@Getter
	@Setter
	private String tickerSymbol;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Logo Image Url
	 */
	@Getter
	@Setter
	private String logoImageUrl;
	/**
	 * Geo Id
	 */
	@Getter
	@Setter
	private String geoId;
	/**
	 * Geo Type Id
	 */
	@Getter
	@Setter
	private String geoTypeId;
	/**
	 * Geo Name
	 */
	@Getter
	@Setter
	private String geoName;
	/**
	 * Geo Code
	 */
	@Getter
	@Setter
	private String geoCode;
	/**
	 * Geo Sec Code
	 */
	@Getter
	@Setter
	private String geoSecCode;
	/**
	 * Abbreviation
	 */
	@Getter
	@Setter
	private String abbreviation;
	/**
	 * Well Known Text
	 */
	@Getter
	@Setter
	private String wellKnownText;

	public enum Fields {
		taxAuthGeoId, taxAuthPartyId, requireTaxIdForExemption, taxIdFormatPattern, includeTaxInPrice, partyId, groupName, groupNameLocal, officeSiteName, annualRevenue, numEmployees, tickerSymbol, comments, logoImageUrl, geoId, geoTypeId, geoName, geoCode, geoSecCode, abbreviation, wellKnownText
	}

	public TaxAuthorityAndDetail(GenericValue value) {
		taxAuthGeoId = (String) value.get(Fields.taxAuthGeoId.name());
		taxAuthPartyId = (String) value.get(Fields.taxAuthPartyId.name());
		requireTaxIdForExemption = (String) value
				.get(Fields.requireTaxIdForExemption.name());
		taxIdFormatPattern = (String) value.get(Fields.taxIdFormatPattern
				.name());
		includeTaxInPrice = (String) value.get(Fields.includeTaxInPrice.name());
		partyId = (String) value.get(Fields.partyId.name());
		groupName = (String) value.get(Fields.groupName.name());
		groupNameLocal = (String) value.get(Fields.groupNameLocal.name());
		officeSiteName = (String) value.get(Fields.officeSiteName.name());
		annualRevenue = (BigDecimal) value.get(Fields.annualRevenue.name());
		numEmployees = (Long) value.get(Fields.numEmployees.name());
		tickerSymbol = (String) value.get(Fields.tickerSymbol.name());
		comments = (String) value.get(Fields.comments.name());
		logoImageUrl = (String) value.get(Fields.logoImageUrl.name());
		geoId = (String) value.get(Fields.geoId.name());
		geoTypeId = (String) value.get(Fields.geoTypeId.name());
		geoName = (String) value.get(Fields.geoName.name());
		geoCode = (String) value.get(Fields.geoCode.name());
		geoSecCode = (String) value.get(Fields.geoSecCode.name());
		abbreviation = (String) value.get(Fields.abbreviation.name());
		wellKnownText = (String) value.get(Fields.wellKnownText.name());
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