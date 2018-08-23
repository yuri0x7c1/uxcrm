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
 * Country Capital
 */
@FieldNameConstants
public class CountryCapital implements Serializable {

	public static final long serialVersionUID = 9134144448278509568L;
	public static final String NAME = "CountryCapital";
	/**
	 * Country Code
	 */
	@Getter
	@Setter
	private String countryCode;
	/**
	 * Country Capital
	 */
	@Getter
	@Setter
	private String countryCapital;
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

	public CountryCapital(GenericValue value) {
		countryCode = (String) value.get(FIELD_COUNTRY_CODE);
		countryCapital = (String) value.get(FIELD_COUNTRY_CAPITAL);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static CountryCapital fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CountryCapital(value);
	}

	public static List<CountryCapital> fromValues(List<GenericValue> values) {
		List<CountryCapital> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CountryCapital(value));
		}
		return entities;
	}
}