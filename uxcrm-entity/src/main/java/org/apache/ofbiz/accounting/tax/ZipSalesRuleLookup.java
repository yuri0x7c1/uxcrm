package org.apache.ofbiz.accounting.tax;

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

	public static final long serialVersionUID = 5985714470416849920L;
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
		stateCode, city, county, fromDate, idCode, taxable, shipCond, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ZipSalesRuleLookup(GenericValue value) {
		stateCode = (String) value.get(Fields.stateCode.name());
		city = (String) value.get(Fields.city.name());
		county = (String) value.get(Fields.county.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		idCode = (String) value.get(Fields.idCode.name());
		taxable = (String) value.get(Fields.taxable.name());
		shipCond = (String) value.get(Fields.shipCond.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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