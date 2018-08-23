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
 * Contact Mech Link
 */
@FieldNameConstants
public class ContactMechLink implements Serializable {

	public static final long serialVersionUID = 3570572387496243200L;
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

	public ContactMechLink(GenericValue value) {
		contactMechIdFrom = (String) value.get(FIELD_CONTACT_MECH_ID_FROM);
		contactMechIdTo = (String) value.get(FIELD_CONTACT_MECH_ID_TO);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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