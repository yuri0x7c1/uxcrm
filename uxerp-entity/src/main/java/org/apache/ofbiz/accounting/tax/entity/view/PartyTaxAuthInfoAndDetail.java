package org.apache.ofbiz.accounting.tax.entity.view;

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
public class PartyTaxAuthInfoAndDetail implements Serializable {

	public static final long serialVersionUID = 1304621783512092672L;
	public static final String NAME = "PartyTaxAuthInfoAndDetail";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
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
	 * Party Tax Id
	 */
	@Getter
	@Setter
	private String partyTaxId;
	/**
	 * Is Exempt
	 */
	@Getter
	@Setter
	private String isExempt;
	/**
	 * Is Nexus
	 */
	@Getter
	@Setter
	private String isNexus;
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
		partyId, taxAuthGeoId, taxAuthPartyId, fromDate, thruDate, partyTaxId, isExempt, isNexus, groupName, groupNameLocal, officeSiteName, annualRevenue, numEmployees, tickerSymbol, comments, logoImageUrl, geoId, geoTypeId, geoName, geoCode, geoSecCode, abbreviation, wellKnownText
	}

	public PartyTaxAuthInfoAndDetail(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		taxAuthGeoId = (String) value.get(Fields.taxAuthGeoId.name());
		taxAuthPartyId = (String) value.get(Fields.taxAuthPartyId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		partyTaxId = (String) value.get(Fields.partyTaxId.name());
		isExempt = (String) value.get(Fields.isExempt.name());
		isNexus = (String) value.get(Fields.isNexus.name());
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