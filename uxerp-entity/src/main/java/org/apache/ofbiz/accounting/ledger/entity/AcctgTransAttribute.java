package org.apache.ofbiz.accounting.ledger.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Acctg Trans Attribute
 */
public class AcctgTransAttribute implements Serializable {

	public static final long serialVersionUID = 7791700345736901632L;
	public static final String NAME = "AcctgTransAttribute";
	/**
	 * Acctg Trans Id
	 */
	@Getter
	@Setter
	private String acctgTransId;
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
		acctgTransId, attrName, attrValue, attrDescription
	}

	public AcctgTransAttribute(GenericValue value) {
		acctgTransId = (String) value.get(Fields.acctgTransId.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
		attrDescription = (String) value.get(Fields.attrDescription.name());
	}

	public static AcctgTransAttribute fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new AcctgTransAttribute(value);
	}

	public static List<AcctgTransAttribute> fromValues(List<GenericValue> values) {
		List<AcctgTransAttribute> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new AcctgTransAttribute(value));
		}
		return entities;
	}
}