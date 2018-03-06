package org.apache.ofbiz.party.party.entity.view;

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
public class PartyIdentificationAndParty implements Serializable {

	public static final long serialVersionUID = 5871874083561619456L;
	public static final String NAME = "PartyIdentificationAndParty";
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
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
	 * Party Type Id
	 */
	@Getter
	@Setter
	private String partyTypeId;
	/**
	 * External Id
	 */
	@Getter
	@Setter
	private String externalId;
	/**
	 * Preferred Currency Uom Id
	 */
	@Getter
	@Setter
	private String preferredCurrencyUomId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Created Date
	 */
	@Getter
	@Setter
	private Timestamp createdDate;
	/**
	 * Created By User Login
	 */
	@Getter
	@Setter
	private String createdByUserLogin;
	/**
	 * Last Modified Date
	 */
	@Getter
	@Setter
	private Timestamp lastModifiedDate;
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
	 * Is Unread
	 */
	@Getter
	@Setter
	private String isUnread;

	public enum Fields {
		partyId, partyIdentificationTypeId, idValue, partyTypeId, externalId, preferredCurrencyUomId, description, statusId, createdDate, createdByUserLogin, lastModifiedDate, lastModifiedByUserLogin, dataSourceId, isUnread
	}

	public PartyIdentificationAndParty(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		partyIdentificationTypeId = (String) value
				.get(Fields.partyIdentificationTypeId.name());
		idValue = (String) value.get(Fields.idValue.name());
		partyTypeId = (String) value.get(Fields.partyTypeId.name());
		externalId = (String) value.get(Fields.externalId.name());
		preferredCurrencyUomId = (String) value
				.get(Fields.preferredCurrencyUomId.name());
		description = (String) value.get(Fields.description.name());
		statusId = (String) value.get(Fields.statusId.name());
		createdDate = (Timestamp) value.get(Fields.createdDate.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
		lastModifiedDate = (Timestamp) value
				.get(Fields.lastModifiedDate.name());
		lastModifiedByUserLogin = (String) value
				.get(Fields.lastModifiedByUserLogin.name());
		dataSourceId = (String) value.get(Fields.dataSourceId.name());
		isUnread = (String) value.get(Fields.isUnread.name());
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