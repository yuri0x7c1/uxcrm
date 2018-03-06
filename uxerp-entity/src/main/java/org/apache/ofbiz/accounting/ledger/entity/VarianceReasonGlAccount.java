package org.apache.ofbiz.accounting.ledger.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Variance Reason Gl Account
 */
public class VarianceReasonGlAccount implements Serializable {

	public static final long serialVersionUID = 1333579581766036480L;
	public static final String NAME = "VarianceReasonGlAccount";
	/**
	 * Variance Reason Id
	 */
	@Getter
	@Setter
	private String varianceReasonId;
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
		varianceReasonId, organizationPartyId, glAccountId
	}

	public VarianceReasonGlAccount(GenericValue value) {
		varianceReasonId = (String) value.get(Fields.varianceReasonId.name());
		organizationPartyId = (String) value.get(Fields.organizationPartyId
				.name());
		glAccountId = (String) value.get(Fields.glAccountId.name());
	}

	public static VarianceReasonGlAccount fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new VarianceReasonGlAccount(value);
	}

	public static List<VarianceReasonGlAccount> fromValues(
			List<GenericValue> values) {
		List<VarianceReasonGlAccount> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new VarianceReasonGlAccount(value));
		}
		return entities;
	}
}