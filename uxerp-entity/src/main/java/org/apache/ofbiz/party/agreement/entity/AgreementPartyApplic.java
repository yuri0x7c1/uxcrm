package org.apache.ofbiz.party.agreement.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Agreement Party Applic
 */
public class AgreementPartyApplic implements Serializable {

	public static final long serialVersionUID = 2892700079677408256L;
	public static final String NAME = "AgreementPartyApplic";
	/**
	 * Agreement Id
	 */
	@Getter
	@Setter
	private String agreementId;
	/**
	 * Agreement Item Seq Id
	 */
	@Getter
	@Setter
	private String agreementItemSeqId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;

	public enum Fields {
		agreementId, agreementItemSeqId, partyId
	}

	public AgreementPartyApplic(GenericValue value) {
		agreementId = (String) value.get(Fields.agreementId.name());
		agreementItemSeqId = (String) value.get(Fields.agreementItemSeqId
				.name());
		partyId = (String) value.get(Fields.partyId.name());
	}

	public static AgreementPartyApplic fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new AgreementPartyApplic(value);
	}

	public static List<AgreementPartyApplic> fromValues(
			List<GenericValue> values) {
		List<AgreementPartyApplic> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new AgreementPartyApplic(value));
		}
		return entities;
	}
}