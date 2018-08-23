package org.apache.ofbiz.accounting.invoice;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class InvoiceItemTypeGlAccount implements Serializable {

	public static final long serialVersionUID = 1366223045789876224L;
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

	public InvoiceItemTypeGlAccount(GenericValue value) {
		invoiceItemTypeId = (String) value.get(FIELD_INVOICE_ITEM_TYPE_ID);
		organizationPartyId = (String) value.get(FIELD_ORGANIZATION_PARTY_ID);
		glAccountId = (String) value.get(FIELD_GL_ACCOUNT_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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