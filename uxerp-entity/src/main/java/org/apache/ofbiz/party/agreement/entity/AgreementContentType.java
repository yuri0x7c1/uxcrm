package org.apache.ofbiz.party.agreement.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Agreement Content Type
 */
public class AgreementContentType implements Serializable {

	public static final long serialVersionUID = 4087863681244822528L;
	public static final String NAME = "AgreementContentType";
	/**
	 * Agreement Content Type Id
	 */
	@Getter
	@Setter
	private String agreementContentTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Has Table
	 */
	@Getter
	@Setter
	private String hasTable;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		agreementContentTypeId, parentTypeId, hasTable, description
	}

	public AgreementContentType(GenericValue value) {
		agreementContentTypeId = (String) value
				.get(Fields.agreementContentTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static AgreementContentType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new AgreementContentType(value);
	}

	public static List<AgreementContentType> fromValues(
			List<GenericValue> values) {
		List<AgreementContentType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new AgreementContentType(value));
		}
		return entities;
	}
}