package org.apache.ofbiz.party.contact;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Contact Mech Attribute
 */
public class ContactMechAttribute implements Serializable {

	public static final long serialVersionUID = 6695703836032992256L;
	public static final String NAME = "ContactMechAttribute";
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Attr Value
	 */
	@Getter
	@Setter
	private String attrValue;
	/**
	 * Attr Description
	 */
	@Getter
	@Setter
	private String attrDescription;
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
		contactMechId, attrName, attrValue, attrDescription, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ContactMechAttribute(GenericValue value) {
		contactMechId = (String) value.get(Fields.contactMechId.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
		attrDescription = (String) value.get(Fields.attrDescription.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ContactMechAttribute fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContactMechAttribute(value);
	}

	public static List<ContactMechAttribute> fromValues(
			List<GenericValue> values) {
		List<ContactMechAttribute> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContactMechAttribute(value));
		}
		return entities;
	}
}