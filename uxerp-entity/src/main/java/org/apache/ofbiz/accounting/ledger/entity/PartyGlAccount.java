package org.apache.ofbiz.accounting.ledger.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Party Gl Account
 */
public class PartyGlAccount implements Serializable {

	public static final long serialVersionUID = 263753511134542848L;
	public static final String NAME = "PartyGlAccount";
	/**
	 * Organization Party Id
	 */
	@Getter
	@Setter
	private String organizationPartyId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * Gl Account Type Id
	 */
	@Getter
	@Setter
	private String glAccountTypeId;
	/**
	 * Gl Account Id
	 */
	@Getter
	@Setter
	private String glAccountId;

	public enum Fields {
		organizationPartyId, partyId, roleTypeId, glAccountTypeId, glAccountId
	}

	public PartyGlAccount(GenericValue value) {
		organizationPartyId = (String) value.get(Fields.organizationPartyId
				.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		glAccountTypeId = (String) value.get(Fields.glAccountTypeId.name());
		glAccountId = (String) value.get(Fields.glAccountId.name());
	}

	public static PartyGlAccount fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new PartyGlAccount(value);
	}

	public static List<PartyGlAccount> fromValues(List<GenericValue> values) {
		List<PartyGlAccount> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new PartyGlAccount(value));
		}
		return entities;
	}
}