package org.apache.ofbiz.party.contact;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Contact Mech Purpose Type
 */
public class ContactMechPurposeType implements Serializable {

	public static final long serialVersionUID = 951549075012480000L;
	public static final String NAME = "ContactMechPurposeType";
	/**
	 * Contact Mech Purpose Type Id
	 */
	@Getter
	@Setter
	private String contactMechPurposeTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
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
		contactMechPurposeTypeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ContactMechPurposeType(GenericValue value) {
		contactMechPurposeTypeId = (String) value
				.get(Fields.contactMechPurposeTypeId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ContactMechPurposeType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContactMechPurposeType(value);
	}

	public static List<ContactMechPurposeType> fromValues(
			List<GenericValue> values) {
		List<ContactMechPurposeType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContactMechPurposeType(value));
		}
		return entities;
	}
}