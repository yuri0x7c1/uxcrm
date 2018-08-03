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
 * Zip Sales Tax Lookup
 */
public class ZipSalesTaxLookup implements Serializable {

	public static final long serialVersionUID = 2598237077574574080L;
	public static final String NAME = "ZipSalesTaxLookup";
	/**
	 * Zip Code
	 */
	@Getter
	@Setter
	private String zipCode;
	/**
	 * State Code
	 */
	@Getter
	@Setter
	private String stateCode;
	/**
	 * City
	 */
	@Getter
	@Setter
	private String city;
	/**
	 * County
	 */
	@Getter
	@Setter
	private String county;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * County Fips
	 */
	@Getter
	@Setter
	private String countyFips;
	/**
	 * County Default
	 */
	@Getter
	@Setter
	private String countyDefault;
	/**
	 * General Default
	 */
	@Getter
	@Setter
	private String generalDefault;
	/**
	 * Inside City
	 */
	@Getter
	@Setter
	private String insideCity;
	/**
	 * Geo Code
	 */
	@Getter
	@Setter
	private String geoCode;
	/**
	 * State Sales Tax
	 */
	@Getter
	@Setter
	private BigDecimal stateSalesTax;
	/**
	 * City Sales Tax
	 */
	@Getter
	@Setter
	private BigDecimal citySalesTax;
	/**
	 * City Local Sales Tax
	 */
	@Getter
	@Setter
	private BigDecimal cityLocalSalesTax;
	/**
	 * County Sales Tax
	 */
	@Getter
	@Setter
	private BigDecimal countySalesTax;
	/**
	 * County Local Sales Tax
	 */
	@Getter
	@Setter
	private BigDecimal countyLocalSalesTax;
	/**
	 * Combo Sales Tax
	 */
	@Getter
	@Setter
	private BigDecimal comboSalesTax;
	/**
	 * State Use Tax
	 */
	@Getter
	@Setter
	private BigDecimal stateUseTax;
	/**
	 * City Use Tax
	 */
	@Getter
	@Setter
	private BigDecimal cityUseTax;
	/**
	 * City Local Use Tax
	 */
	@Getter
	@Setter
	private BigDecimal cityLocalUseTax;
	/**
	 * County Use Tax
	 */
	@Getter
	@Setter
	private BigDecimal countyUseTax;
	/**
	 * County Local Use Tax
	 */
	@Getter
	@Setter
	private BigDecimal countyLocalUseTax;
	/**
	 * Combo Use Tax
	 */
	@Getter
	@Setter
	private BigDecimal comboUseTax;
	/**
	 * Last Updated Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedStamp;
	/**
	 * Last Updated Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedTxStamp;
	/**
	 * Created Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdStamp;
	/**
	 * Created Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdTxStamp;

	public enum Fields {
		zipCode, stateCode, city, county, fromDate, countyFips, countyDefault, generalDefault, insideCity, geoCode, stateSalesTax, citySalesTax, cityLocalSalesTax, countySalesTax, countyLocalSalesTax, comboSalesTax, stateUseTax, cityUseTax, cityLocalUseTax, countyUseTax, countyLocalUseTax, comboUseTax, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ZipSalesTaxLookup(GenericValue value) {
		zipCode = (String) value.get(Fields.zipCode.name());
		stateCode = (String) value.get(Fields.stateCode.name());
		city = (String) value.get(Fields.city.name());
		county = (String) value.get(Fields.county.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		countyFips = (String) value.get(Fields.countyFips.name());
		countyDefault = (String) value.get(Fields.countyDefault.name());
		generalDefault = (String) value.get(Fields.generalDefault.name());
		insideCity = (String) value.get(Fields.insideCity.name());
		geoCode = (String) value.get(Fields.geoCode.name());
		stateSalesTax = (BigDecimal) value.get(Fields.stateSalesTax.name());
		citySalesTax = (BigDecimal) value.get(Fields.citySalesTax.name());
		cityLocalSalesTax = (BigDecimal) value.get(Fields.cityLocalSalesTax
				.name());
		countySalesTax = (BigDecimal) value.get(Fields.countySalesTax.name());
		countyLocalSalesTax = (BigDecimal) value.get(Fields.countyLocalSalesTax
				.name());
		comboSalesTax = (BigDecimal) value.get(Fields.comboSalesTax.name());
		stateUseTax = (BigDecimal) value.get(Fields.stateUseTax.name());
		cityUseTax = (BigDecimal) value.get(Fields.cityUseTax.name());
		cityLocalUseTax = (BigDecimal) value.get(Fields.cityLocalUseTax.name());
		countyUseTax = (BigDecimal) value.get(Fields.countyUseTax.name());
		countyLocalUseTax = (BigDecimal) value.get(Fields.countyLocalUseTax
				.name());
		comboUseTax = (BigDecimal) value.get(Fields.comboUseTax.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ZipSalesTaxLookup fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ZipSalesTaxLookup(value);
	}

	public static List<ZipSalesTaxLookup> fromValues(List<GenericValue> values) {
		List<ZipSalesTaxLookup> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ZipSalesTaxLookup(value));
		}
		return entities;
	}
}