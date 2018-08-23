package org.apache.ofbiz.party.party;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Identification And Party
 */
@FieldNameConstants
public class PartyIdentificationAndParty implements Serializable {

	public static final long serialVersionUID = 5304947069149833216L;
	public static final String NAME = "PartyIdentificationAndParty";
	/**
	 * Party Ident Type Desc
	 */
	@Getter
	@Setter
	private String partyIdentTypeDesc;
	/**
	 * Party Identification Type Id
	 */
	@Getter
	@Setter
	private String partyIdentificationTypeId;
	/**
	 * Id Value
	 */
	@Getter
	@Setter
	private String idValue;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Last Modified Date
	 */
	@Getter
	@Setter
	private Timestamp lastModifiedDate;
	/**
	 * External Id
	 */
	@Getter
	@Setter
	private String externalId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Is Unread
	 */
	@Getter
	@Setter
	private String isUnread;
	/**
	 * Party Type Id
	 */
	@Getter
	@Setter
	private String partyTypeId;
	/**
	 * Last Modified By User Login
	 */
	@Getter
	@Setter
	private String lastModifiedByUserLogin;
	/**
	 * Data Source Id
	 */
	@Getter
	@Setter
	private String dataSourceId;
	/**
	 * Created Date
	 */
	@Getter
	@Setter
	private Timestamp createdDate;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Preferred Currency Uom Id
	 */
	@Getter
	@Setter
	private String preferredCurrencyUomId;
	/**
	 * Created By User Login
	 */
	@Getter
	@Setter
	private String createdByUserLogin;

	public PartyIdentificationAndParty(GenericValue value) {
		partyIdentTypeDesc = (String) value.get(FIELD_PARTY_IDENT_TYPE_DESC);
		partyIdentificationTypeId = (String) value
				.get(FIELD_PARTY_IDENTIFICATION_TYPE_ID);
		idValue = (String) value.get(FIELD_ID_VALUE);
		partyId = (String) value.get(FIELD_PARTY_ID);
		lastModifiedDate = (Timestamp) value.get(FIELD_LAST_MODIFIED_DATE);
		externalId = (String) value.get(FIELD_EXTERNAL_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		isUnread = (String) value.get(FIELD_IS_UNREAD);
		partyTypeId = (String) value.get(FIELD_PARTY_TYPE_ID);
		lastModifiedByUserLogin = (String) value
				.get(FIELD_LAST_MODIFIED_BY_USER_LOGIN);
		dataSourceId = (String) value.get(FIELD_DATA_SOURCE_ID);
		createdDate = (Timestamp) value.get(FIELD_CREATED_DATE);
		statusId = (String) value.get(FIELD_STATUS_ID);
		preferredCurrencyUomId = (String) value
				.get(FIELD_PREFERRED_CURRENCY_UOM_ID);
		createdByUserLogin = (String) value.get(FIELD_CREATED_BY_USER_LOGIN);
	}

	public static PartyIdentificationAndParty fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyIdentificationAndParty(value);
	}

	public static List<PartyIdentificationAndParty> fromValues(
			List<GenericValue> values) {
		List<PartyIdentificationAndParty> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyIdentificationAndParty(value));
		}
		return entities;
	}
}