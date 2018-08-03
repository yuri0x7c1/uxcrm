package org.apache.ofbiz.common.geo;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Country Tele Code
 */
public class CountryTeleCode implements Serializable {

	public static final long serialVersionUID = 8218626270903358464L;
	public static final String NAME = "CountryTeleCode";
	/**
	 * Country Code
	 */
	@Getter
	@Setter
	private String countryCode;
	/**
	 * Tele Code
	 */
	@Getter
	@Setter
	private String teleCode;
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
		countryCode, teleCode, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public CountryTeleCode(GenericValue value) {
		countryCode = (String) value.get(Fields.countryCode.name());
		teleCode = (String) value.get(Fields.teleCode.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static CountryTeleCode fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CountryTeleCode(value);
	}

	public static List<CountryTeleCode> fromValues(List<GenericValue> values) {
		List<CountryTeleCode> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CountryTeleCode(value));
		}
		return entities;
	}
}