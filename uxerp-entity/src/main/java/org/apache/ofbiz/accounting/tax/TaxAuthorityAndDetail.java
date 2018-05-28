package org.apache.ofbiz.accounting.tax;

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

	public static final long serialVersionUID = 253508665456866304L;
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

	public enum Fields {
		taxAuthPartyId, requireTaxIdForExemption, includeTaxInPrice, taxAuthGeoId, taxIdFormatPattern, comments, tickerSymbol, logoImageUrl, groupName, groupNameLocal, numEmployees, partyId, officeSiteName, annualRevenue, geoName, geoTypeId, geoId, geoCode, abbreviation, geoSecCode, wellKnownText
	}

	public TaxAuthorityAndDetail(GenericValue value) {
		taxAuthPartyId = (String) value.get(Fields.taxAuthPartyId.name());
		requireTaxIdForExemption = (String) value
				.get(Fields.requireTaxIdForExemption.name());
		includeTaxInPrice = (String) value.get(Fields.includeTaxInPrice.name());
		taxAuthGeoId = (String) value.get(Fields.taxAuthGeoId.name());
		taxIdFormatPattern = (String) value.get(Fields.taxIdFormatPattern
				.name());
		comments = (String) value.get(Fields.comments.name());
		tickerSymbol = (String) value.get(Fields.tickerSymbol.name());
		logoImageUrl = (String) value.get(Fields.logoImageUrl.name());
		groupName = (String) value.get(Fields.groupName.name());
		groupNameLocal = (String) value.get(Fields.groupNameLocal.name());
		numEmployees = (Long) value.get(Fields.numEmployees.name());
		partyId = (String) value.get(Fields.partyId.name());
		officeSiteName = (String) value.get(Fields.officeSiteName.name());
		annualRevenue = (BigDecimal) value.get(Fields.annualRevenue.name());
		geoName = (String) value.get(Fields.geoName.name());
		geoTypeId = (String) value.get(Fields.geoTypeId.name());
		geoId = (String) value.get(Fields.geoId.name());
		geoCode = (String) value.get(Fields.geoCode.name());
		abbreviation = (String) value.get(Fields.abbreviation.name());
		geoSecCode = (String) value.get(Fields.geoSecCode.name());
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