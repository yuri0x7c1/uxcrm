package org.apache.ofbiz.accounting.invoice;

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
public class InvoiceItemAssoc implements Serializable {

	public static final long serialVersionUID = 2648639978794719232L;
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

	public enum Fields {
		invoiceIdFrom, invoiceItemSeqIdFrom, invoiceIdTo, invoiceItemSeqIdTo, invoiceItemAssocTypeId, fromDate, thruDate, partyIdFrom, partyIdTo, quantity, amount, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public InvoiceItemAssoc(GenericValue value) {
		invoiceIdFrom = (String) value.get(Fields.invoiceIdFrom.name());
		invoiceItemSeqIdFrom = (String) value.get(Fields.invoiceItemSeqIdFrom
				.name());
		invoiceIdTo = (String) value.get(Fields.invoiceIdTo.name());
		invoiceItemSeqIdTo = (String) value.get(Fields.invoiceItemSeqIdTo
				.name());
		invoiceItemAssocTypeId = (String) value
				.get(Fields.invoiceItemAssocTypeId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		partyIdFrom = (String) value.get(Fields.partyIdFrom.name());
		partyIdTo = (String) value.get(Fields.partyIdTo.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		amount = (BigDecimal) value.get(Fields.amount.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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