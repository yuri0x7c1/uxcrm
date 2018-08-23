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
 * Zip Sales Tax Lookup
 */
@FieldNameConstants
public class ZipSalesTaxLookup implements Serializable {

	public static final long serialVersionUID = 7876368813223415808L;
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

	public ZipSalesTaxLookup(GenericValue value) {
		zipCode = (String) value.get(FIELD_ZIP_CODE);
		stateCode = (String) value.get(FIELD_STATE_CODE);
		city = (String) value.get(FIELD_CITY);
		county = (String) value.get(FIELD_COUNTY);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		countyFips = (String) value.get(FIELD_COUNTY_FIPS);
		countyDefault = (String) value.get(FIELD_COUNTY_DEFAULT);
		generalDefault = (String) value.get(FIELD_GENERAL_DEFAULT);
		insideCity = (String) value.get(FIELD_INSIDE_CITY);
		geoCode = (String) value.get(FIELD_GEO_CODE);
		stateSalesTax = (BigDecimal) value.get(FIELD_STATE_SALES_TAX);
		citySalesTax = (BigDecimal) value.get(FIELD_CITY_SALES_TAX);
		cityLocalSalesTax = (BigDecimal) value.get(FIELD_CITY_LOCAL_SALES_TAX);
		countySalesTax = (BigDecimal) value.get(FIELD_COUNTY_SALES_TAX);
		countyLocalSalesTax = (BigDecimal) value
				.get(FIELD_COUNTY_LOCAL_SALES_TAX);
		comboSalesTax = (BigDecimal) value.get(FIELD_COMBO_SALES_TAX);
		stateUseTax = (BigDecimal) value.get(FIELD_STATE_USE_TAX);
		cityUseTax = (BigDecimal) value.get(FIELD_CITY_USE_TAX);
		cityLocalUseTax = (BigDecimal) value.get(FIELD_CITY_LOCAL_USE_TAX);
		countyUseTax = (BigDecimal) value.get(FIELD_COUNTY_USE_TAX);
		countyLocalUseTax = (BigDecimal) value.get(FIELD_COUNTY_LOCAL_USE_TAX);
		comboUseTax = (BigDecimal) value.get(FIELD_COMBO_USE_TAX);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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