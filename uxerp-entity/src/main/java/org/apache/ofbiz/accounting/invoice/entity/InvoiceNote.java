package org.apache.ofbiz.accounting.invoice.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Invoice Note
 */
public class InvoiceNote implements Serializable {

	public static final long serialVersionUID = 5066630385768216576L;
	public static final String NAME = "InvoiceNote";
	/**
	 * Invoice Id
	 */
	@Getter
	@Setter
	private String invoiceId;
	/**
	 * Note Id
	 */
	@Getter
	@Setter
	private String noteId;

	public enum Fields {
		invoiceId, noteId
	}

	public InvoiceNote(GenericValue value) {
		invoiceId = (String) value.get(Fields.invoiceId.name());
		noteId = (String) value.get(Fields.noteId.name());
	}

	public static InvoiceNote fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InvoiceNote(value);
	}

	public static List<InvoiceNote> fromValues(List<GenericValue> values) {
		List<InvoiceNote> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InvoiceNote(value));
		}
		return entities;
	}
}