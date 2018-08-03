package org.apache.ofbiz.party.contact;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Contact Mech Type Purpose
 */
public class ContactMechTypePurpose implements Serializable {

	public static final long serialVersionUID = 4496493388216317952L;
	public static final String NAME = "ContactMechTypePurpose";
	/**
	 * Contact Mech Type Id
	 */
	@Getter
	@Setter
	private String contactMechTypeId;
	/**
	 * Contact Mech Purpose Type Id
	 */
	@Getter
	@Setter
	private String contactMechPurposeTypeId;
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
		contactMechTypeId, contactMechPurposeTypeId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ContactMechTypePurpose(GenericValue value) {
		contactMechTypeId = (String) value.get(Fields.contactMechTypeId.name());
		contactMechPurposeTypeId = (String) value
				.get(Fields.contactMechPurposeTypeId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ContactMechTypePurpose fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContactMechTypePurpose(value);
	}

	public static List<ContactMechTypePurpose> fromValues(
			List<GenericValue> values) {
		List<ContactMechTypePurpose> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContactMechTypePurpose(value));
		}
		return entities;
	}
}