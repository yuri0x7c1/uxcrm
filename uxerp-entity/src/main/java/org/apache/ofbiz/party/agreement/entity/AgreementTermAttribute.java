package org.apache.ofbiz.party.agreement.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Agreement Term Attribute
 */
public class AgreementTermAttribute implements Serializable {

	public static final long serialVersionUID = 2932066196529359872L;
	public static final String NAME = "AgreementTermAttribute";
	/**
	 * Agreement Term Id
	 */
	@Getter
	@Setter
	private String agreementTermId;
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
		agreementTermId, attrName, attrValue, attrDescription
	}

	public AgreementTermAttribute(GenericValue value) {
		agreementTermId = (String) value.get(Fields.agreementTermId.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
		attrDescription = (String) value.get(Fields.attrDescription.name());
	}

	public static AgreementTermAttribute fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new AgreementTermAttribute(value);
	}

	public static List<AgreementTermAttribute> fromValues(
			List<GenericValue> values) {
		List<AgreementTermAttribute> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new AgreementTermAttribute(value));
		}
		return entities;
	}
}