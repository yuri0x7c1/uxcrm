package org.apache.ofbiz.accounting.invoice.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Invoice Content Type
 */
public class InvoiceContentType implements Serializable {

	public static final long serialVersionUID = 9193618776482827264L;
	public static final String NAME = "InvoiceContentType";
	/**
	 * Invoice Content Type Id
	 */
	@Getter
	@Setter
	private String invoiceContentTypeId;
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
		invoiceContentTypeId, parentTypeId, hasTable, description
	}

	public InvoiceContentType(GenericValue value) {
		invoiceContentTypeId = (String) value.get(Fields.invoiceContentTypeId
				.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
	}

	public static InvoiceContentType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InvoiceContentType(value);
	}

	public static List<InvoiceContentType> fromValues(List<GenericValue> values) {
		List<InvoiceContentType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InvoiceContentType(value));
		}
		return entities;
	}
}