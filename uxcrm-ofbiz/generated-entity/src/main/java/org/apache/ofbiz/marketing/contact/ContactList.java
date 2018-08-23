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
 * Contact List
 */
@FieldNameConstants
public class ContactList implements Serializable {

	public static final long serialVersionUID = 5775252207729024000L;
	public static final String NAME = "ContactList";
	/**
	 * Contact List Id
	 */
	@Getter
	@Setter
	private String contactListId;
	/**
	 * Contact List Type Id
	 */
	@Getter
	@Setter
	private String contactListTypeId;
	/**
	 * Contact Mech Type Id
	 */
	@Getter
	@Setter
	private String contactMechTypeId;
	/**
	 * Marketing Campaign Id
	 */
	@Getter
	@Setter
	private String marketingCampaignId;
	/**
	 * Contact List Name
	 */
	@Getter
	@Setter
	private String contactListName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Is Public
	 */
	@Getter
	@Setter
	private String isPublic;
	/**
	 * Single Use
	 */
	@Getter
	@Setter
	private String singleUse;
	/**
	 * Owner Party Id
	 */
	@Getter
	@Setter
	private String ownerPartyId;
	/**
	 * Verify Email From
	 */
	@Getter
	@Setter
	private String verifyEmailFrom;
	/**
	 * Verify Email Screen
	 */
	@Getter
	@Setter
	private String verifyEmailScreen;
	/**
	 * Verify Email Subject
	 */
	@Getter
	@Setter
	private String verifyEmailSubject;
	/**
	 * Verify Email Web Site Id
	 */
	@Getter
	@Setter
	private String verifyEmailWebSiteId;
	/**
	 * Opt Out Screen
	 */
	@Getter
	@Setter
	private String optOutScreen;
	/**
	 * Created By User Login
	 */
	@Getter
	@Setter
	private String createdByUserLogin;
	/**
	 * Last Modified By User Login
	 */
	@Getter
	@Setter
	private String lastModifiedByUserLogin;
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

	public ContactList(GenericValue value) {
		contactListId = (String) value.get(FIELD_CONTACT_LIST_ID);
		contactListTypeId = (String) value.get(FIELD_CONTACT_LIST_TYPE_ID);
		contactMechTypeId = (String) value.get(FIELD_CONTACT_MECH_TYPE_ID);
		marketingCampaignId = (String) value.get(FIELD_MARKETING_CAMPAIGN_ID);
		contactListName = (String) value.get(FIELD_CONTACT_LIST_NAME);
		description = (String) value.get(FIELD_DESCRIPTION);
		comments = (String) value.get(FIELD_COMMENTS);
		isPublic = (String) value.get(FIELD_IS_PUBLIC);
		singleUse = (String) value.get(FIELD_SINGLE_USE);
		ownerPartyId = (String) value.get(FIELD_OWNER_PARTY_ID);
		verifyEmailFrom = (String) value.get(FIELD_VERIFY_EMAIL_FROM);
		verifyEmailScreen = (String) value.get(FIELD_VERIFY_EMAIL_SCREEN);
		verifyEmailSubject = (String) value.get(FIELD_VERIFY_EMAIL_SUBJECT);
		verifyEmailWebSiteId = (String) value
				.get(FIELD_VERIFY_EMAIL_WEB_SITE_ID);
		optOutScreen = (String) value.get(FIELD_OPT_OUT_SCREEN);
		createdByUserLogin = (String) value.get(FIELD_CREATED_BY_USER_LOGIN);
		lastModifiedByUserLogin = (String) value
				.get(FIELD_LAST_MODIFIED_BY_USER_LOGIN);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ContactList fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ContactList(value);
	}

	public static List<ContactList> fromValues(List<GenericValue> values) {
		List<ContactList> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ContactList(value));
		}
		return entities;
	}
}