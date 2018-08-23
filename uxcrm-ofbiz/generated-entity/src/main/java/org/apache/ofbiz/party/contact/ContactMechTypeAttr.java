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
 * Contact Mech Type Attr
 */
@FieldNameConstants
public class ContactMechTypeAttr implements Serializable {

	public static final long serialVersionUID = 4645453205349400576L;
	public static final String NAME = "ContactMechTypeAttr";
	/**
	 * Contact Mech Type Id
	 */
	@Getter
	@Setter
	private String contactMechTypeId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
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

	public ContactMechTypeAttr(GenericValue value) {
		contactMechTypeId = (String) value.get(FIELD_CONTACT_MECH_TYPE_ID);
		attrName = (String) value.get(FIELD_ATTR_NAME);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ContactMechTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContactMechTypeAttr(value);
	}

	public static List<ContactMechTypeAttr> fromValues(List<GenericValue> values) {
		List<ContactMechTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContactMechTypeAttr(value));
		}
		return entities;
	}
}