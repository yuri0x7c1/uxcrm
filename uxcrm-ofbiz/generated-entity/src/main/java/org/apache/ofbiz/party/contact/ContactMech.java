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
 * Contact Mech
 */
@FieldNameConstants
public class ContactMech implements Serializable {

	public static final long serialVersionUID = 7308011842022248448L;
	public static final String NAME = "ContactMech";
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
	/**
	 * Contact Mech Type Id
	 */
	@Getter
	@Setter
	private String contactMechTypeId;
	/**
	 * Info String
	 */
	@Getter
	@Setter
	private String infoString;
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

	public ContactMech(GenericValue value) {
		contactMechId = (String) value.get(FIELD_CONTACT_MECH_ID);
		contactMechTypeId = (String) value.get(FIELD_CONTACT_MECH_TYPE_ID);
		infoString = (String) value.get(FIELD_INFO_STRING);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ContactMech fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContactMech(value);
	}

	public static List<ContactMech> fromValues(List<GenericValue> values) {
		List<ContactMech> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContactMech(value));
		}
		return entities;
	}
}