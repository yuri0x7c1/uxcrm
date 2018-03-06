package org.apache.ofbiz.accounting.invoice.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Invoice Item Attribute
 */
public class InvoiceItemAttribute implements Serializable {

	public static final long serialVersionUID = 7307245256729478144L;
	public static final String NAME = "InvoiceItemAttribute";
	/**
	 * Invoice Id
	 */
	@Getter
	@Setter
	private String invoiceId;
	/**
	 * Invoice Item Seq Id
	 */
	@Getter
	@Setter
	private String invoiceItemSeqId;
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
		invoiceId, invoiceItemSeqId, attrName, attrValue, attrDescription
	}

	public InvoiceItemAttribute(GenericValue value) {
		invoiceId = (String) value.get(Fields.invoiceId.name());
		invoiceItemSeqId = (String) value.get(Fields.invoiceItemSeqId.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
		attrDescription = (String) value.get(Fields.attrDescription.name());
	}

	public static InvoiceItemAttribute fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InvoiceItemAttribute(value);
	}

	public static List<InvoiceItemAttribute> fromValues(
			List<GenericValue> values) {
		List<InvoiceItemAttribute> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InvoiceItemAttribute(value));
		}
		return entities;
	}
}