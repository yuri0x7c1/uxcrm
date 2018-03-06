package org.apache.ofbiz.accounting.invoice.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Invoice Contact Mech
 */
public class InvoiceContactMech implements Serializable {

	public static final long serialVersionUID = 4110770490410788864L;
	public static final String NAME = "InvoiceContactMech";
	/**
	 * Invoice Id
	 */
	@Getter
	@Setter
	private String invoiceId;
	/**
	 * Contact Mech Purpose Type Id
	 */
	@Getter
	@Setter
	private String contactMechPurposeTypeId;
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;

	public enum Fields {
		invoiceId, contactMechPurposeTypeId, contactMechId
	}

	public InvoiceContactMech(GenericValue value) {
		invoiceId = (String) value.get(Fields.invoiceId.name());
		contactMechPurposeTypeId = (String) value
				.get(Fields.contactMechPurposeTypeId.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
	}

	public static InvoiceContactMech fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InvoiceContactMech(value);
	}

	public static List<InvoiceContactMech> fromValues(List<GenericValue> values) {
		List<InvoiceContactMech> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InvoiceContactMech(value));
		}
		return entities;
	}
}