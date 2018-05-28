package org.apache.ofbiz.party.contact;

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
public class ContactMech implements Serializable {

	public static final long serialVersionUID = 147762660085161984L;
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

	public enum Fields {
		contactMechId, contactMechTypeId, infoString, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ContactMech(GenericValue value) {
		contactMechId = (String) value.get(Fields.contactMechId.name());
		contactMechTypeId = (String) value.get(Fields.contactMechTypeId.name());
		infoString = (String) value.get(Fields.infoString.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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