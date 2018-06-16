package org.apache.ofbiz.accounting.invoice;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Invoice Item And Assoc Product
 */
public class InvoiceItemAndAssocProduct implements Serializable {

	public static final long serialVersionUID = 3783190971128491008L;
	public static final String NAME = "InvoiceItemAndAssocProduct";
	/**
	 * Term Amount
	 */
	@Getter
	@Setter
	private BigDecimal termAmount;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Product Name
	 */
	@Getter
	@Setter
	private String productName;
	/**
	 * Amount
	 */
	@Getter
	@Setter
	private BigDecimal amount;
	/**
	 * Party Id From
	 */
	@Getter
	@Setter
	private String partyIdFrom;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
	/**
	 * Invoice Item Seq Id From
	 */
	@Getter
	@Setter
	private String invoiceItemSeqIdFrom;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Invoice Id From
	 */
	@Getter
	@Setter
	private String invoiceIdFrom;
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
	 * Invoice Id To
	 */
	@Getter
	@Setter
	private String invoiceIdTo;
	/**
	 * Party Id To
	 */
	@Getter
	@Setter
	private String partyIdTo;

	public enum Fields {
		termAmount, productId, productName, amount, partyIdFrom, quantity, invoiceItemSeqIdFrom, thruDate, fromDate, invoiceIdFrom, invoiceItemSeqIdTo, invoiceItemAssocTypeId, invoiceIdTo, partyIdTo
	}

	public InvoiceItemAndAssocProduct(GenericValue value) {
		termAmount = (BigDecimal) value.get(Fields.termAmount.name());
		productId = (String) value.get(Fields.productId.name());
		productName = (String) value.get(Fields.productName.name());
		amount = (BigDecimal) value.get(Fields.amount.name());
		partyIdFrom = (String) value.get(Fields.partyIdFrom.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		invoiceItemSeqIdFrom = (String) value.get(Fields.invoiceItemSeqIdFrom
				.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		invoiceIdFrom = (String) value.get(Fields.invoiceIdFrom.name());
		invoiceItemSeqIdTo = (String) value.get(Fields.invoiceItemSeqIdTo
				.name());
		invoiceItemAssocTypeId = (String) value
				.get(Fields.invoiceItemAssocTypeId.name());
		invoiceIdTo = (String) value.get(Fields.invoiceIdTo.name());
		partyIdTo = (String) value.get(Fields.partyIdTo.name());
	}

	public static InvoiceItemAndAssocProduct fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InvoiceItemAndAssocProduct(value);
	}

	public static List<InvoiceItemAndAssocProduct> fromValues(
			List<GenericValue> values) {
		List<InvoiceItemAndAssocProduct> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InvoiceItemAndAssocProduct(value));
		}
		return entities;
	}
}