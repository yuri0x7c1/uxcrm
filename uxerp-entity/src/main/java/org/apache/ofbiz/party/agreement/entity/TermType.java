package org.apache.ofbiz.party.agreement.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Term Type
 */
public class TermType implements Serializable {

	public static final long serialVersionUID = 553875621733391360L;
	public static final String NAME = "TermType";
	/**
	 * Term Type Id
	 */
	@Getter
	@Setter
	private String termTypeId;
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
		termTypeId, parentTypeId, hasTable, description
	}

	public TermType(GenericValue value) {
		termTypeId = (String) value.get(Fields.termTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static TermType fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new TermType(value);
	}

	public static List<TermType> fromValues(List<GenericValue> values) {
		List<TermType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TermType(value));
		}
		return entities;
	}
}