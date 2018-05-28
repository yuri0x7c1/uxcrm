package org.apache.ofbiz.accounting.tax;

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

	public static final long serialVersionUID = 794386127627736064L;
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

	public enum Fields {
		taxAuthPartyId, fromDate, partyTaxId, isNexus, taxAuthGeoId, isExempt, partyId, thruDate, comments, tickerSymbol, logoImageUrl, groupName, groupNameLocal, numEmployees, officeSiteName, annualRevenue, geoName, geoTypeId, geoId, geoCode, abbreviation, geoSecCode, wellKnownText
	}

	public PartyTaxAuthInfoAndDetail(GenericValue value) {
		taxAuthPartyId = (String) value.get(Fields.taxAuthPartyId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		partyTaxId = (String) value.get(Fields.partyTaxId.name());
		isNexus = (String) value.get(Fields.isNexus.name());
		taxAuthGeoId = (String) value.get(Fields.taxAuthGeoId.name());
		isExempt = (String) value.get(Fields.isExempt.name());
		partyId = (String) value.get(Fields.partyId.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		comments = (String) value.get(Fields.comments.name());
		tickerSymbol = (String) value.get(Fields.tickerSymbol.name());
		logoImageUrl = (String) value.get(Fields.logoImageUrl.name());
		groupName = (String) value.get(Fields.groupName.name());
		groupNameLocal = (String) value.get(Fields.groupNameLocal.name());
		numEmployees = (Long) value.get(Fields.numEmployees.name());
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