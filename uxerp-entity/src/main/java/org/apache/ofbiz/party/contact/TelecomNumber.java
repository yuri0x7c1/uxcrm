package org.apache.ofbiz.party.contact;

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
public class TelecomNumber implements Serializable {

	public static final long serialVersionUID = 6989731986619582464L;
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

	public enum Fields {
		contactMechId, countryCode, areaCode, contactNumber, askForName, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public TelecomNumber(GenericValue value) {
		contactMechId = (String) value.get(Fields.contactMechId.name());
		countryCode = (String) value.get(Fields.countryCode.name());
		areaCode = (String) value.get(Fields.areaCode.name());
		contactNumber = (String) value.get(Fields.contactNumber.name());
		askForName = (String) value.get(Fields.askForName.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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