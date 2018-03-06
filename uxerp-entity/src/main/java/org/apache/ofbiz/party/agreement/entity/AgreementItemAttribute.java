package org.apache.ofbiz.party.agreement.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Agreement Item Attribute
 */
public class AgreementItemAttribute implements Serializable {

	public static final long serialVersionUID = 7940569389099676672L;
	public static final String NAME = "AgreementItemAttribute";
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
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Attr Value
	 */
	@Getter
	@Setter
	private String attrValue;
	/**
	 * Attr Description
	 */
	@Getter
	@Setter
	private String attrDescription;

	public enum Fields {
		agreementId, agreementItemSeqId, attrName, attrValue, attrDescription
	}

	public AgreementItemAttribute(GenericValue value) {
		agreementId = (String) value.get(Fields.agreementId.name());
		agreementItemSeqId = (String) value.get(Fields.agreementItemSeqId
				.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
		attrDescription = (String) value.get(Fields.attrDescription.name());
	}

	public static AgreementItemAttribute fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new AgreementItemAttribute(value);
	}

	public static List<AgreementItemAttribute> fromValues(
			List<GenericValue> values) {
		List<AgreementItemAttribute> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new AgreementItemAttribute(value));
		}
		return entities;
	}
}