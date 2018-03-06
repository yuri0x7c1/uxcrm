package org.apache.ofbiz.party.agreement.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Agreement Work Effort Applic
 */
public class AgreementWorkEffortApplic implements Serializable {

	public static final long serialVersionUID = 6054262034459419648L;
	public static final String NAME = "AgreementWorkEffortApplic";
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
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;

	public enum Fields {
		agreementId, agreementItemSeqId, workEffortId
	}

	public AgreementWorkEffortApplic(GenericValue value) {
		agreementId = (String) value.get(Fields.agreementId.name());
		agreementItemSeqId = (String) value.get(Fields.agreementItemSeqId
				.name());
		workEffortId = (String) value.get(Fields.workEffortId.name());
	}

	public static AgreementWorkEffortApplic fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new AgreementWorkEffortApplic(value);
	}

	public static List<AgreementWorkEffortApplic> fromValues(
			List<GenericValue> values) {
		List<AgreementWorkEffortApplic> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new AgreementWorkEffortApplic(value));
		}
		return entities;
	}
}