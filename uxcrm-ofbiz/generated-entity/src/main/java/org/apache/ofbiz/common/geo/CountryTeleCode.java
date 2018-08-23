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
 * Country Tele Code
 */
@FieldNameConstants
public class CountryTeleCode implements Serializable {

	public static final long serialVersionUID = 5473972544253072384L;
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

	public CountryTeleCode(GenericValue value) {
		countryCode = (String) value.get(FIELD_COUNTRY_CODE);
		teleCode = (String) value.get(FIELD_TELE_CODE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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