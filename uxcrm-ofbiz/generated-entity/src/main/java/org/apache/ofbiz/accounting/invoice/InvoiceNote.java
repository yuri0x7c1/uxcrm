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
 * Invoice Note
 */
@FieldNameConstants
public class InvoiceNote implements Serializable {

	public static final long serialVersionUID = 4398879319156278272L;
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

	public InvoiceNote(GenericValue value) {
		invoiceId = (String) value.get(FIELD_INVOICE_ID);
		noteId = (String) value.get(FIELD_NOTE_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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