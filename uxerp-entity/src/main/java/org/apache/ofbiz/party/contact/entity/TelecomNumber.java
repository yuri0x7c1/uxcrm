package org.apache.ofbiz.party.contact.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Telecom Number
 */
public class TelecomNumber implements Serializable {

	public static final long serialVersionUID = 7866745277622544384L;
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

	public enum Fields {
		contactMechId, countryCode, areaCode, contactNumber, askForName
	}

	public TelecomNumber(GenericValue value) {
		contactMechId = (String) value.get(Fields.contactMechId.name());
		countryCode = (String) value.get(Fields.countryCode.name());
		areaCode = (String) value.get(Fields.areaCode.name());
		contactNumber = (String) value.get(Fields.contactNumber.name());
		askForName = (String) value.get(Fields.askForName.name());
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