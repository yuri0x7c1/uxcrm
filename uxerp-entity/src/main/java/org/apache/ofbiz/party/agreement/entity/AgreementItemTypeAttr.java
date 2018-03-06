package org.apache.ofbiz.party.agreement.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Agreement Item Type Attr
 */
public class AgreementItemTypeAttr implements Serializable {

	public static final long serialVersionUID = 3810398184535261184L;
	public static final String NAME = "AgreementItemTypeAttr";
	/**
	 * Agreement Item Type Id
	 */
	@Getter
	@Setter
	private String agreementItemTypeId;
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
		agreementItemTypeId, attrName, description
	}

	public AgreementItemTypeAttr(GenericValue value) {
		agreementItemTypeId = (String) value.get(Fields.agreementItemTypeId
				.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
	}

	public static AgreementItemTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new AgreementItemTypeAttr(value);
	}

	public static List<AgreementItemTypeAttr> fromValues(
			List<GenericValue> values) {
		List<AgreementItemTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new AgreementItemTypeAttr(value));
		}
		return entities;
	}
}