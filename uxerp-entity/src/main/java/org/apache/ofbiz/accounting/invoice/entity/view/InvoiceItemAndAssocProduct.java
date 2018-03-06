package org.apache.ofbiz.accounting.invoice.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Invoice Item And Assoc Product
 */
public class InvoiceItemAndAssocProduct implements Serializable {

	public static final long serialVersionUID = 5404349843875647488L;
	public static final String NAME = "InvoiceItemAndAssocProduct";
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

	public enum Fields {
		invoiceIdFrom, invoiceItemSeqIdFrom, invoiceIdTo, invoiceItemSeqIdTo, invoiceItemAssocTypeId, fromDate, thruDate, partyIdFrom, partyIdTo, quantity, amount, productId, productName
	}

	public InvoiceItemAndAssocProduct(GenericValue value) {
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
		productId = (String) value.get(Fields.productId.name());
		productName = (String) value.get(Fields.productName.name());
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