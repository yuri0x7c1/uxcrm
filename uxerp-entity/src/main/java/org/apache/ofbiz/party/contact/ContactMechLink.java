package org.apache.ofbiz.party.contact;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Contact Mech Link
 */
public class ContactMechLink implements Serializable {

	public static final long serialVersionUID = 7624809101789884416L;
	public static final String NAME = "ContactMechLink";
	/**
	 * Contact Mech Id From
	 */
	@Getter
	@Setter
	private String contactMechIdFrom;
	/**
	 * Contact Mech Id To
	 */
	@Getter
	@Setter
	private String contactMechIdTo;
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
		contactMechIdFrom, contactMechIdTo, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ContactMechLink(GenericValue value) {
		contactMechIdFrom = (String) value.get(Fields.contactMechIdFrom.name());
		contactMechIdTo = (String) value.get(Fields.contactMechIdTo.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ContactMechLink fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContactMechLink(value);
	}

	public static List<ContactMechLink> fromValues(List<GenericValue> values) {
		List<ContactMechLink> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContactMechLink(value));
		}
		return entities;
	}
}