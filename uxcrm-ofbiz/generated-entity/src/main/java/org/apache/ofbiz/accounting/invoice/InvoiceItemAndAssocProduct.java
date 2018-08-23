package org.apache.ofbiz.accounting.invoice;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class InvoiceItemAndAssocProduct implements Serializable {

	public static final long serialVersionUID = 695470184352860160L;
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

	public InvoiceItemAndAssocProduct(GenericValue value) {
		termAmount = (BigDecimal) value.get(FIELD_TERM_AMOUNT);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		productName = (String) value.get(FIELD_PRODUCT_NAME);
		amount = (BigDecimal) value.get(FIELD_AMOUNT);
		partyIdFrom = (String) value.get(FIELD_PARTY_ID_FROM);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
		invoiceItemSeqIdFrom = (String) value
				.get(FIELD_INVOICE_ITEM_SEQ_ID_FROM);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		invoiceIdFrom = (String) value.get(FIELD_INVOICE_ID_FROM);
		invoiceItemSeqIdTo = (String) value.get(FIELD_INVOICE_ITEM_SEQ_ID_TO);
		invoiceItemAssocTypeId = (String) value
				.get(FIELD_INVOICE_ITEM_ASSOC_TYPE_ID);
		invoiceIdTo = (String) value.get(FIELD_INVOICE_ID_TO);
		partyIdTo = (String) value.get(FIELD_PARTY_ID_TO);
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