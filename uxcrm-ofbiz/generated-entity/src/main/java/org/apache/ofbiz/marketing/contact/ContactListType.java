package org.apache.ofbiz.marketing.contact;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class ContactListType implements Serializable {

	public static final long serialVersionUID = 6104538200370381824L;
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

	public ContactListType(GenericValue value) {
		contactListTypeId = (String) value.get(FIELD_CONTACT_LIST_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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