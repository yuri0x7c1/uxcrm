package org.apache.ofbiz.accounting.tax.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Zip Sales Rule Lookup
 */
public class ZipSalesRuleLookup implements Serializable {

	public static final long serialVersionUID = 1170988994391601152L;
	public static final String NAME = "ZipSalesRuleLookup";
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
	 * Id Code
	 */
	@Getter
	@Setter
	private String idCode;
	/**
	 * Taxable
	 */
	@Getter
	@Setter
	private String taxable;
	/**
	 * Ship Cond
	 */
	@Getter
	@Setter
	private String shipCond;

	public enum Fields {
		stateCode, city, county, fromDate, idCode, taxable, shipCond
	}

	public ZipSalesRuleLookup(GenericValue value) {
		stateCode = (String) value.get(Fields.stateCode.name());
		city = (String) value.get(Fields.city.name());
		county = (String) value.get(Fields.county.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		idCode = (String) value.get(Fields.idCode.name());
		taxable = (String) value.get(Fields.taxable.name());
		shipCond = (String) value.get(Fields.shipCond.name());
	}

	public static ZipSalesRuleLookup fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ZipSalesRuleLookup(value);
	}

	public static List<ZipSalesRuleLookup> fromValues(List<GenericValue> values) {
		List<ZipSalesRuleLookup> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ZipSalesRuleLookup(value));
		}
		return entities;
	}
}