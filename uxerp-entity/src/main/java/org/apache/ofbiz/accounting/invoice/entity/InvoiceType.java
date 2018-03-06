package org.apache.ofbiz.accounting.invoice.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Invoice Type
 */
public class InvoiceType implements Serializable {

	public static final long serialVersionUID = 7209670720204121088L;
	public static final String NAME = "InvoiceType";
	/**
	 * Invoice Type Id
	 */
	@Getter
	@Setter
	private String invoiceTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Has Table
	 */
	@Getter
	@Setter
	private String hasTable;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		invoiceTypeId, parentTypeId, hasTable, description
	}

	public InvoiceType(GenericValue value) {
		invoiceTypeId = (String) value.get(Fields.invoiceTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static InvoiceType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InvoiceType(value);
	}

	public static List<InvoiceType> fromValues(List<GenericValue> values) {
		List<InvoiceType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InvoiceType(value));
		}
		return entities;
	}
}