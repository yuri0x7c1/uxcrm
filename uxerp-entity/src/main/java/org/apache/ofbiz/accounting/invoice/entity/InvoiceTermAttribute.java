package org.apache.ofbiz.accounting.invoice.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Invoice Term Attribute
 */
public class InvoiceTermAttribute implements Serializable {

	public static final long serialVersionUID = 3819868951968917504L;
	public static final String NAME = "InvoiceTermAttribute";
	/**
	 * Invoice Term Id
	 */
	@Getter
	@Setter
	private String invoiceTermId;
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
		invoiceTermId, attrName, attrValue, attrDescription
	}

	public InvoiceTermAttribute(GenericValue value) {
		invoiceTermId = (String) value.get(Fields.invoiceTermId.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
		attrDescription = (String) value.get(Fields.attrDescription.name());
	}

	public static InvoiceTermAttribute fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InvoiceTermAttribute(value);
	}

	public static List<InvoiceTermAttribute> fromValues(
			List<GenericValue> values) {
		List<InvoiceTermAttribute> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InvoiceTermAttribute(value));
		}
		return entities;
	}
}