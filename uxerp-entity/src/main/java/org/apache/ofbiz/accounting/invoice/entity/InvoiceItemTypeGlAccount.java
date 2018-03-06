package org.apache.ofbiz.accounting.invoice.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Invoice Item Type Gl Account
 */
public class InvoiceItemTypeGlAccount implements Serializable {

	public static final long serialVersionUID = 7837901901740923904L;
	public static final String NAME = "InvoiceItemTypeGlAccount";
	/**
	 * Invoice Item Type Id
	 */
	@Getter
	@Setter
	private String invoiceItemTypeId;
	/**
	 * Organization Party Id
	 */
	@Getter
	@Setter
	private String organizationPartyId;
	/**
	 * Gl Account Id
	 */
	@Getter
	@Setter
	private String glAccountId;

	public enum Fields {
		invoiceItemTypeId, organizationPartyId, glAccountId
	}

	public InvoiceItemTypeGlAccount(GenericValue value) {
		invoiceItemTypeId = (String) value.get(Fields.invoiceItemTypeId.name());
		organizationPartyId = (String) value.get(Fields.organizationPartyId
				.name());
		glAccountId = (String) value.get(Fields.glAccountId.name());
	}

	public static InvoiceItemTypeGlAccount fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InvoiceItemTypeGlAccount(value);
	}

	public static List<InvoiceItemTypeGlAccount> fromValues(
			List<GenericValue> values) {
		List<InvoiceItemTypeGlAccount> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InvoiceItemTypeGlAccount(value));
		}
		return entities;
	}
}