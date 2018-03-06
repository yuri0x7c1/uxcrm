package org.apache.ofbiz.accounting.invoice.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Invoice Attribute
 */
public class InvoiceAttribute implements Serializable {

	public static final long serialVersionUID = 309447986216899584L;
	public static final String NAME = "InvoiceAttribute";
	/**
	 * Invoice Id
	 */
	@Getter
	@Setter
	private String invoiceId;
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
		invoiceId, attrName, attrValue, attrDescription
	}

	public InvoiceAttribute(GenericValue value) {
		invoiceId = (String) value.get(Fields.invoiceId.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
		attrDescription = (String) value.get(Fields.attrDescription.name());
	}

	public static InvoiceAttribute fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InvoiceAttribute(value);
	}

	public static List<InvoiceAttribute> fromValues(List<GenericValue> values) {
		List<InvoiceAttribute> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InvoiceAttribute(value));
		}
		return entities;
	}
}