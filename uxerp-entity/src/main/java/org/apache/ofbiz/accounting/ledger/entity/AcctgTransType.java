package org.apache.ofbiz.accounting.ledger.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Acctg Trans Type
 */
public class AcctgTransType implements Serializable {

	public static final long serialVersionUID = 1220477885201131520L;
	public static final String NAME = "AcctgTransType";
	/**
	 * Acctg Trans Type Id
	 */
	@Getter
	@Setter
	private String acctgTransTypeId;
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
		acctgTransTypeId, parentTypeId, hasTable, description
	}

	public AcctgTransType(GenericValue value) {
		acctgTransTypeId = (String) value.get(Fields.acctgTransTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static AcctgTransType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new AcctgTransType(value);
	}

	public static List<AcctgTransType> fromValues(List<GenericValue> values) {
		List<AcctgTransType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new AcctgTransType(value));
		}
		return entities;
	}
}