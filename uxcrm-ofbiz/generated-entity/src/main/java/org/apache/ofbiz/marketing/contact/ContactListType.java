package org.apache.ofbiz.marketing.contact;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Contact List Type
 */
public class ContactListType implements Serializable {

	public static final long serialVersionUID = 2831746676158170112L;
	public static final String NAME = "ContactListType";
	/**
	 * Contact List Type Id
	 */
	@Getter
	@Setter
	private String contactListTypeId;
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
		contactListTypeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ContactListType(GenericValue value) {
		contactListTypeId = (String) value.get(Fields.contactListTypeId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ContactListType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContactListType(value);
	}

	public static List<ContactListType> fromValues(List<GenericValue> values) {
		List<ContactListType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContactListType(value));
		}
		return entities;
	}
}