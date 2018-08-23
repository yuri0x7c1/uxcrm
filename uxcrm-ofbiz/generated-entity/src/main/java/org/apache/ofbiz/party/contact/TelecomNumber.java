package org.apache.ofbiz.party.contact;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Telecom Number
 */
@FieldNameConstants
public class TelecomNumber implements Serializable {

	public static final long serialVersionUID = 3550708586819301376L;
	public static final String NAME = "TelecomNumber";
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
	/**
	 * Country Code
	 */
	@Getter
	@Setter
	private String countryCode;
	/**
	 * Area Code
	 */
	@Getter
	@Setter
	private String areaCode;
	/**
	 * Contact Number
	 */
	@Getter
	@Setter
	private String contactNumber;
	/**
	 * Ask For Name
	 */
	@Getter
	@Setter
	private String askForName;
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

	public TelecomNumber(GenericValue value) {
		contactMechId = (String) value.get(FIELD_CONTACT_MECH_ID);
		countryCode = (String) value.get(FIELD_COUNTRY_CODE);
		areaCode = (String) value.get(FIELD_AREA_CODE);
		contactNumber = (String) value.get(FIELD_CONTACT_NUMBER);
		askForName = (String) value.get(FIELD_ASK_FOR_NAME);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static TelecomNumber fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TelecomNumber(value);
	}

	public static List<TelecomNumber> fromValues(List<GenericValue> values) {
		List<TelecomNumber> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TelecomNumber(value));
		}
		return entities;
	}
}