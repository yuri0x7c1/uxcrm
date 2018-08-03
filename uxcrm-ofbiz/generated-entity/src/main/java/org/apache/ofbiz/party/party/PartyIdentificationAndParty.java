package org.apache.ofbiz.party.party;

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

	public static final long serialVersionUID = 6192188196071661568L;
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

	public enum Fields {
		partyIdentTypeDesc, partyIdentificationTypeId, idValue, partyId, lastModifiedDate, externalId, description, isUnread, partyTypeId, lastModifiedByUserLogin, dataSourceId, createdDate, statusId, preferredCurrencyUomId, createdByUserLogin
	}

	public PartyIdentificationAndParty(GenericValue value) {
		partyIdentTypeDesc = (String) value.get(Fields.partyIdentTypeDesc
				.name());
		partyIdentificationTypeId = (String) value
				.get(Fields.partyIdentificationTypeId.name());
		idValue = (String) value.get(Fields.idValue.name());
		partyId = (String) value.get(Fields.partyId.name());
		lastModifiedDate = (Timestamp) value
				.get(Fields.lastModifiedDate.name());
		externalId = (String) value.get(Fields.externalId.name());
		description = (String) value.get(Fields.description.name());
		isUnread = (String) value.get(Fields.isUnread.name());
		partyTypeId = (String) value.get(Fields.partyTypeId.name());
		lastModifiedByUserLogin = (String) value
				.get(Fields.lastModifiedByUserLogin.name());
		dataSourceId = (String) value.get(Fields.dataSourceId.name());
		createdDate = (Timestamp) value.get(Fields.createdDate.name());
		statusId = (String) value.get(Fields.statusId.name());
		preferredCurrencyUomId = (String) value
				.get(Fields.preferredCurrencyUomId.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
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