package org.apache.ofbiz.accounting.invoice.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Invoice Type Attr
 */
public class InvoiceTypeAttr implements Serializable {

	public static final long serialVersionUID = 7864615566539086848L;
	public static final String NAME = "InvoiceTypeAttr";
	/**
	 * Invoice Type Id
	 */
	@Getter
	@Setter
	private String invoiceTypeId;
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
		invoiceTypeId, attrName, description
	}

	public InvoiceTypeAttr(GenericValue value) {
		invoiceTypeId = (String) value.get(Fields.invoiceTypeId.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
	}

	public static InvoiceTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InvoiceTypeAttr(value);
	}

	public static List<InvoiceTypeAttr> fromValues(List<GenericValue> values) {
		List<InvoiceTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InvoiceTypeAttr(value));
		}
		return entities;
	}
}