package org.apache.ofbiz.party.agreement.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Agreement Geographical Applic
 */
public class AgreementGeographicalApplic implements Serializable {

	public static final long serialVersionUID = 2081534900696134656L;
	public static final String NAME = "AgreementGeographicalApplic";
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
	 * Geo Id
	 */
	@Getter
	@Setter
	private String geoId;

	public enum Fields {
		agreementId, agreementItemSeqId, geoId
	}

	public AgreementGeographicalApplic(GenericValue value) {
		agreementId = (String) value.get(Fields.agreementId.name());
		agreementItemSeqId = (String) value.get(Fields.agreementItemSeqId
				.name());
		geoId = (String) value.get(Fields.geoId.name());
	}

	public static AgreementGeographicalApplic fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new AgreementGeographicalApplic(value);
	}

	public static List<AgreementGeographicalApplic> fromValues(
			List<GenericValue> values) {
		List<AgreementGeographicalApplic> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new AgreementGeographicalApplic(value));
		}
		return entities;
	}
}