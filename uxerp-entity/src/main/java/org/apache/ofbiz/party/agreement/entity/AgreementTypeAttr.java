package org.apache.ofbiz.party.agreement.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Agreement Type Attr
 */
public class AgreementTypeAttr implements Serializable {

	public static final long serialVersionUID = 2084152353849183232L;
	public static final String NAME = "AgreementTypeAttr";
	/**
	 * Agreement Type Id
	 */
	@Getter
	@Setter
	private String agreementTypeId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		agreementTypeId, attrName, description
	}

	public AgreementTypeAttr(GenericValue value) {
		agreementTypeId = (String) value.get(Fields.agreementTypeId.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
	}

	public static AgreementTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new AgreementTypeAttr(value);
	}

	public static List<AgreementTypeAttr> fromValues(List<GenericValue> values) {
		List<AgreementTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new AgreementTypeAttr(value));
		}
		return entities;
	}
}