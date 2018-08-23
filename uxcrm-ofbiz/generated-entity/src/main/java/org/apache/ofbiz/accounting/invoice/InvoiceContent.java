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
 * Invoice Content
 */
@FieldNameConstants
public class InvoiceContent implements Serializable {

	public static final long serialVersionUID = 494901066883564544L;
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

	public InvoiceContent(GenericValue value) {
		invoiceId = (String) value.get(FIELD_INVOICE_ID);
		invoiceContentTypeId = (String) value
				.get(FIELD_INVOICE_CONTENT_TYPE_ID);
		contentId = (String) value.get(FIELD_CONTENT_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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