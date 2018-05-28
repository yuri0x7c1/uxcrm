package org.apache.ofbiz.accounting.invoice;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Invoice Item Type Gl Account
 */
public class InvoiceItemTypeGlAccount implements Serializable {

	public static final long serialVersionUID = 7235778536952554496L;
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
	/**
	 * Last Updated Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedStamp;
	/**
	 * Last Updated Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedTxStamp;
	/**
	 * Created Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdStamp;
	/**
	 * Created Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdTxStamp;

	public enum Fields {
		invoiceItemTypeId, organizationPartyId, glAccountId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public InvoiceItemTypeGlAccount(GenericValue value) {
		invoiceItemTypeId = (String) value.get(Fields.invoiceItemTypeId.name());
		organizationPartyId = (String) value.get(Fields.organizationPartyId
				.name());
		glAccountId = (String) value.get(Fields.glAccountId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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