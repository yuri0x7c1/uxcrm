package org.apache.ofbiz.accounting.ledger.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Acctg Trans Type Attr
 */
public class AcctgTransTypeAttr implements Serializable {

	public static final long serialVersionUID = 5936541611162105856L;
	public static final String NAME = "AcctgTransTypeAttr";
	/**
	 * Acctg Trans Type Id
	 */
	@Getter
	@Setter
	private String acctgTransTypeId;
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
		acctgTransTypeId, attrName, description
	}

	public AcctgTransTypeAttr(GenericValue value) {
		acctgTransTypeId = (String) value.get(Fields.acctgTransTypeId.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
	}

	public static AcctgTransTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new AcctgTransTypeAttr(value);
	}

	public static List<AcctgTransTypeAttr> fromValues(List<GenericValue> values) {
		List<AcctgTransTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new AcctgTransTypeAttr(value));
		}
		return entities;
	}
}