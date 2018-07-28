package org.apache.ofbiz.common.geo;

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
public class CountryCode implements Serializable {

	public static final long serialVersionUID = 6991355352345795584L;
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

	public enum Fields {
		countryCode, countryAbbr, countryNumber, countryName, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public CountryCode(GenericValue value) {
		countryCode = (String) value.get(Fields.countryCode.name());
		countryAbbr = (String) value.get(Fields.countryAbbr.name());
		countryNumber = (String) value.get(Fields.countryNumber.name());
		countryName = (String) value.get(Fields.countryName.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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