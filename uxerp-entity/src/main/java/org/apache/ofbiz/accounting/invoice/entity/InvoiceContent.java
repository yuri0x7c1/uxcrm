package org.apache.ofbiz.accounting.invoice.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Invoice Content
 */
public class InvoiceContent implements Serializable {

	public static final long serialVersionUID = 5769999128881940480L;
	public static final String NAME = "InvoiceContent";
	/**
	 * Invoice Id
	 */
	@Getter
	@Setter
	private String invoiceId;
	/**
	 * Invoice Content Type Id
	 */
	@Getter
	@Setter
	private String invoiceContentTypeId;
	/**
	 * Content Id
	 */
	@Getter
	@Setter
	private String contentId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;

	public enum Fields {
		invoiceId, invoiceContentTypeId, contentId, fromDate, thruDate
	}

	public InvoiceContent(GenericValue value) {
		invoiceId = (String) value.get(Fields.invoiceId.name());
		invoiceContentTypeId = (String) value.get(Fields.invoiceContentTypeId
				.name());
		contentId = (String) value.get(Fields.contentId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
	}

	public static InvoiceContent fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InvoiceContent(value);
	}

	public static List<InvoiceContent> fromValues(List<GenericValue> values) {
		List<InvoiceContent> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InvoiceContent(value));
		}
		return entities;
	}
}