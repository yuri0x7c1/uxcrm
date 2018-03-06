package org.apache.ofbiz.accounting.invoice.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Invoice Item Type Map
 */
public class InvoiceItemTypeMap implements Serializable {

	public static final long serialVersionUID = 152248382323422208L;
	public static final String NAME = "InvoiceItemTypeMap";
	/**
	 * Invoice Item Map Key
	 */
	@Getter
	@Setter
	private String invoiceItemMapKey;
	/**
	 * Invoice Type Id
	 */
	@Getter
	@Setter
	private String invoiceTypeId;
	/**
	 * Invoice Item Type Id
	 */
	@Getter
	@Setter
	private String invoiceItemTypeId;

	public enum Fields {
		invoiceItemMapKey, invoiceTypeId, invoiceItemTypeId
	}

	public InvoiceItemTypeMap(GenericValue value) {
		invoiceItemMapKey = (String) value.get(Fields.invoiceItemMapKey.name());
		invoiceTypeId = (String) value.get(Fields.invoiceTypeId.name());
		invoiceItemTypeId = (String) value.get(Fields.invoiceItemTypeId.name());
	}

	public static InvoiceItemTypeMap fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InvoiceItemTypeMap(value);
	}

	public static List<InvoiceItemTypeMap> fromValues(List<GenericValue> values) {
		List<InvoiceItemTypeMap> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InvoiceItemTypeMap(value));
		}
		return entities;
	}
}