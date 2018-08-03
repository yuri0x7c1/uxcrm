package org.apache.ofbiz.common.geo;

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
public class CountryCapital implements Serializable {

	public static final long serialVersionUID = 4169292467239867392L;
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

	public enum Fields {
		countryCode, countryCapital, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public CountryCapital(GenericValue value) {
		countryCode = (String) value.get(Fields.countryCode.name());
		countryCapital = (String) value.get(Fields.countryCapital.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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