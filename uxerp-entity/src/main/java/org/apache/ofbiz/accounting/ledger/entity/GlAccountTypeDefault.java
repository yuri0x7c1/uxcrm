package org.apache.ofbiz.accounting.ledger.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Gl Account Type Default
 */
public class GlAccountTypeDefault implements Serializable {

	public static final long serialVersionUID = 5487149941958500352L;
	public static final String NAME = "GlAccountTypeDefault";
	/**
	 * Gl Account Type Id
	 */
	@Getter
	@Setter
	private String glAccountTypeId;
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
		glAccountTypeId, organizationPartyId, glAccountId
	}

	public GlAccountTypeDefault(GenericValue value) {
		glAccountTypeId = (String) value.get(Fields.glAccountTypeId.name());
		organizationPartyId = (String) value.get(Fields.organizationPartyId
				.name());
		glAccountId = (String) value.get(Fields.glAccountId.name());
	}

	public static GlAccountTypeDefault fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new GlAccountTypeDefault(value);
	}

	public static List<GlAccountTypeDefault> fromValues(
			List<GenericValue> values) {
		List<GlAccountTypeDefault> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new GlAccountTypeDefault(value));
		}
		return entities;
	}
}