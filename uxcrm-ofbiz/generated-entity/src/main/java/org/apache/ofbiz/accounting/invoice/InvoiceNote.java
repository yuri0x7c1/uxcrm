package org.apache.ofbiz.accounting.invoice;

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
public class InvoiceNote implements Serializable {

	public static final long serialVersionUID = 3578630987984043008L;
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

	public enum Fields {
		invoiceId, noteId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public InvoiceNote(GenericValue value) {
		invoiceId = (String) value.get(Fields.invoiceId.name());
		noteId = (String) value.get(Fields.noteId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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