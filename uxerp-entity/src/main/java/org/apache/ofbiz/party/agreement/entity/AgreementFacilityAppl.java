package org.apache.ofbiz.party.agreement.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Agreement Facility Appl
 */
public class AgreementFacilityAppl implements Serializable {

	public static final long serialVersionUID = 4651254809018061824L;
	public static final String NAME = "AgreementFacilityAppl";
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
	 * Facility Id
	 */
	@Getter
	@Setter
	private String facilityId;

	public enum Fields {
		agreementId, agreementItemSeqId, facilityId
	}

	public AgreementFacilityAppl(GenericValue value) {
		agreementId = (String) value.get(Fields.agreementId.name());
		agreementItemSeqId = (String) value.get(Fields.agreementItemSeqId
				.name());
		facilityId = (String) value.get(Fields.facilityId.name());
	}

	public static AgreementFacilityAppl fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new AgreementFacilityAppl(value);
	}

	public static List<AgreementFacilityAppl> fromValues(
			List<GenericValue> values) {
		List<AgreementFacilityAppl> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new AgreementFacilityAppl(value));
		}
		return entities;
	}
}