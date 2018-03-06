package org.apache.ofbiz.order.request.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Cust Request Attribute
 */
public class CustRequestAttribute implements Serializable {

	public static final long serialVersionUID = 8540844654686532608L;
	public static final String NAME = "CustRequestAttribute";
	/**
	 * Cust Request Id
	 */
	@Getter
	@Setter
	private String custRequestId;
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
		custRequestId, attrName, attrValue, attrDescription
	}

	public CustRequestAttribute(GenericValue value) {
		custRequestId = (String) value.get(Fields.custRequestId.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
		attrDescription = (String) value.get(Fields.attrDescription.name());
	}

	public static CustRequestAttribute fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CustRequestAttribute(value);
	}

	public static List<CustRequestAttribute> fromValues(
			List<GenericValue> values) {
		List<CustRequestAttribute> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CustRequestAttribute(value));
		}
		return entities;
	}
}