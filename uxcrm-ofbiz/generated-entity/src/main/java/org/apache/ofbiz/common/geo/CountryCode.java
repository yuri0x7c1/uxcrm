package org.apache.ofbiz.common.geo;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Country Code
 */
@FieldNameConstants
public class CountryCode implements Serializable {

	public static final long serialVersionUID = 4716489084848111616L;
	public static final String NAME = "CountryCode";
	/**
	 * Country Code
	 */
	@Getter
	@Setter
	private String countryCode;
	/**
	 * Country Abbr
	 */
	@Getter
	@Setter
	private String countryAbbr;
	/**
	 * Country Number
	 */
	@Getter
	@Setter
	private String countryNumber;
	/**
	 * Country Name
	 */
	@Getter
	@Setter
	private String countryName;
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

	public CountryCode(GenericValue value) {
		countryCode = (String) value.get(FIELD_COUNTRY_CODE);
		countryAbbr = (String) value.get(FIELD_COUNTRY_ABBR);
		countryNumber = (String) value.get(FIELD_COUNTRY_NUMBER);
		countryName = (String) value.get(FIELD_COUNTRY_NAME);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static CountryCode fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CountryCode(value);
	}

	public static List<CountryCode> fromValues(List<GenericValue> values) {
		List<CountryCode> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CountryCode(value));
		}
		return entities;
	}
}