package org.apache.ofbiz.accounting.tax;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class ZipSalesRuleLookup implements Serializable {

	public static final long serialVersionUID = 4831647637506206720L;
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

	public ZipSalesRuleLookup(GenericValue value) {
		stateCode = (String) value.get(FIELD_STATE_CODE);
		city = (String) value.get(FIELD_CITY);
		county = (String) value.get(FIELD_COUNTY);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		idCode = (String) value.get(FIELD_ID_CODE);
		taxable = (String) value.get(FIELD_TAXABLE);
		shipCond = (String) value.get(FIELD_SHIP_COND);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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