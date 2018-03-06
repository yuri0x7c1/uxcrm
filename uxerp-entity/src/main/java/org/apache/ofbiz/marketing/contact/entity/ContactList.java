package org.apache.ofbiz.marketing.contact.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Contact List
 */
public class ContactList implements Serializable {

	public static final long serialVersionUID = 10034854401198080L;
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

	public enum Fields {
		contactListId, contactListTypeId, contactMechTypeId, marketingCampaignId, contactListName, description, comments, isPublic, singleUse, ownerPartyId, verifyEmailFrom, verifyEmailScreen, verifyEmailSubject, verifyEmailWebSiteId, optOutScreen, createdByUserLogin, lastModifiedByUserLogin
	}

	public ContactList(GenericValue value) {
		contactListId = (String) value.get(Fields.contactListId.name());
		contactListTypeId = (String) value.get(Fields.contactListTypeId.name());
		contactMechTypeId = (String) value.get(Fields.contactMechTypeId.name());
		marketingCampaignId = (String) value.get(Fields.marketingCampaignId
				.name());
		contactListName = (String) value.get(Fields.contactListName.name());
		description = (String) value.get(Fields.description.name());
		comments = (String) value.get(Fields.comments.name());
		isPublic = (String) value.get(Fields.isPublic.name());
		singleUse = (String) value.get(Fields.singleUse.name());
		ownerPartyId = (String) value.get(Fields.ownerPartyId.name());
		verifyEmailFrom = (String) value.get(Fields.verifyEmailFrom.name());
		verifyEmailScreen = (String) value.get(Fields.verifyEmailScreen.name());
		verifyEmailSubject = (String) value.get(Fields.verifyEmailSubject
				.name());
		verifyEmailWebSiteId = (String) value.get(Fields.verifyEmailWebSiteId
				.name());
		optOutScreen = (String) value.get(Fields.optOutScreen.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
		lastModifiedByUserLogin = (String) value
				.get(Fields.lastModifiedByUserLogin.name());
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