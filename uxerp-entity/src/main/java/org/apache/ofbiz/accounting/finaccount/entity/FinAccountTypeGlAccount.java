package org.apache.ofbiz.accounting.finaccount.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Fin Account Type Gl Account
 */
public class FinAccountTypeGlAccount implements Serializable {

	public static final long serialVersionUID = 1808823141696508928L;
	public static final String NAME = "FinAccountTypeGlAccount";
	/**
	 * Fin Account Type Id
	 */
	@Getter
	@Setter
	private String finAccountTypeId;
	/**
	 * Organization Party Id
	 */
	@Getter
	@Setter
	private String organizationPartyId;
	/**
	 * Gl Account Id
	 */
	@Getter
	@Setter
	private String glAccountId;

	public enum Fields {
		finAccountTypeId, organizationPartyId, glAccountId
	}

	public FinAccountTypeGlAccount(GenericValue value) {
		finAccountTypeId = (String) value.get(Fields.finAccountTypeId.name());
		organizationPartyId = (String) value.get(Fields.organizationPartyId
				.name());
		glAccountId = (String) value.get(Fields.glAccountId.name());
	}

	public static FinAccountTypeGlAccount fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FinAccountTypeGlAccount(value);
	}

	public static List<FinAccountTypeGlAccount> fromValues(
			List<GenericValue> values) {
		List<FinAccountTypeGlAccount> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FinAccountTypeGlAccount(value));
		}
		return entities;
	}
}