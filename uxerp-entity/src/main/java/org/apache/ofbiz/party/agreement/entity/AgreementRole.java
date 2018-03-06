package org.apache.ofbiz.party.agreement.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Agreement Role
 */
public class AgreementRole implements Serializable {

	public static final long serialVersionUID = 6733707203249460224L;
	public static final String NAME = "AgreementRole";
	/**
	 * Agreement Id
	 */
	@Getter
	@Setter
	private String agreementId;
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

	public enum Fields {
		agreementId, partyId, roleTypeId
	}

	public AgreementRole(GenericValue value) {
		agreementId = (String) value.get(Fields.agreementId.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
	}

	public static AgreementRole fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new AgreementRole(value);
	}

	public static List<AgreementRole> fromValues(List<GenericValue> values) {
		List<AgreementRole> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new AgreementRole(value));
		}
		return entities;
	}
}