package org.apache.ofbiz.accounting.invoice.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Invoice Item Type Attr
 */
public class InvoiceItemTypeAttr implements Serializable {

	public static final long serialVersionUID = 4493461079785716736L;
	public static final String NAME = "InvoiceItemTypeAttr";
	/**
	 * Invoice Item Type Id
	 */
	@Getter
	@Setter
	private String invoiceItemTypeId;
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
		invoiceItemTypeId, attrName, description
	}

	public InvoiceItemTypeAttr(GenericValue value) {
		invoiceItemTypeId = (String) value.get(Fields.invoiceItemTypeId.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
	}

	public static InvoiceItemTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InvoiceItemTypeAttr(value);
	}

	public static List<InvoiceItemTypeAttr> fromValues(List<GenericValue> values) {
		List<InvoiceItemTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InvoiceItemTypeAttr(value));
		}
		return entities;
	}
}