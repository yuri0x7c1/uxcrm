package org.apache.ofbiz.order.request.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Cust Request Type Attr
 */
public class CustRequestTypeAttr implements Serializable {

	public static final long serialVersionUID = 517509234445228032L;
	public static final String NAME = "CustRequestTypeAttr";
	/**
	 * Cust Request Type Id
	 */
	@Getter
	@Setter
	private String custRequestTypeId;
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
		custRequestTypeId, attrName, description
	}

	public CustRequestTypeAttr(GenericValue value) {
		custRequestTypeId = (String) value.get(Fields.custRequestTypeId.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
	}

	public static CustRequestTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CustRequestTypeAttr(value);
	}

	public static List<CustRequestTypeAttr> fromValues(List<GenericValue> values) {
		List<CustRequestTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CustRequestTypeAttr(value));
		}
		return entities;
	}
}