package org.apache.ofbiz.party.agreement.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Agreement Attribute
 */
public class AgreementAttribute implements Serializable {

	public static final long serialVersionUID = 5837154926637137920L;
	public static final String NAME = "AgreementAttribute";
	/**
	 * Agreement Id
	 */
	@Getter
	@Setter
	private String agreementId;
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
		agreementId, attrName, attrValue, attrDescription
	}

	public AgreementAttribute(GenericValue value) {
		agreementId = (String) value.get(Fields.agreementId.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
		attrDescription = (String) value.get(Fields.attrDescription.name());
	}

	public static AgreementAttribute fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new AgreementAttribute(value);
	}

	public static List<AgreementAttribute> fromValues(List<GenericValue> values) {
		List<AgreementAttribute> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new AgreementAttribute(value));
		}
		return entities;
	}
}