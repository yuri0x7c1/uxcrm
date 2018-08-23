package org.apache.ofbiz.accounting.invoice;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Invoice Item Assoc
 */
@FieldNameConstants
public class InvoiceItemAssoc implements Serializable {

	public static final long serialVersionUID = 4514839661002847232L;
	public static final String NAME = "InvoiceItemAssoc";
	/**
	 * Invoice Id From
	 */
	@Getter
	@Setter
	private String invoiceIdFrom;
	/**
	 * Invoice Item Seq Id From
	 */
	@Getter
	@Setter
	private String invoiceItemSeqIdFrom;
	/**
	 * Invoice Id To
	 */
	@Getter
	@Setter
	private String invoiceIdTo;
	/**
	 * Invoice Item Seq Id To
	 */
	@Getter
	@Setter
	private String invoiceItemSeqIdTo;
	/**
	 * Invoice Item Assoc Type Id
	 */
	@Getter
	@Setter
	private String invoiceItemAssocTypeId;
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
	 * Party Id From
	 */
	@Getter
	@Setter
	private String partyIdFrom;
	/**
	 * Party Id To
	 */
	@Getter
	@Setter
	private String partyIdTo;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
	/**
	 * Amount
	 */
	@Getter
	@Setter
	private BigDecimal amount;
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

	public InvoiceItemAssoc(GenericValue value) {
		invoiceIdFrom = (String) value.get(FIELD_INVOICE_ID_FROM);
		invoiceItemSeqIdFrom = (String) value
				.get(FIELD_INVOICE_ITEM_SEQ_ID_FROM);
		invoiceIdTo = (String) value.get(FIELD_INVOICE_ID_TO);
		invoiceItemSeqIdTo = (String) value.get(FIELD_INVOICE_ITEM_SEQ_ID_TO);
		invoiceItemAssocTypeId = (String) value
				.get(FIELD_INVOICE_ITEM_ASSOC_TYPE_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		partyIdFrom = (String) value.get(FIELD_PARTY_ID_FROM);
		partyIdTo = (String) value.get(FIELD_PARTY_ID_TO);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
		amount = (BigDecimal) value.get(FIELD_AMOUNT);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static InvoiceItemAssoc fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InvoiceItemAssoc(value);
	}

	public static List<InvoiceItemAssoc> fromValues(List<GenericValue> values) {
		List<InvoiceItemAssoc> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InvoiceItemAssoc(value));
		}
		return entities;
	}
}