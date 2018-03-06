package org.apache.ofbiz.bi.fact.accounting.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Sales Invoice Item Fact
 */
public class SalesInvoiceItemFact implements Serializable {

	public static final long serialVersionUID = 2223586767571568640L;
	public static final String NAME = "SalesInvoiceItemFact";
	/**
	 * Invoice Id
	 */
	@Getter
	@Setter
	private String invoiceId;
	/**
	 * Invoice Item Seq Id
	 */
	@Getter
	@Setter
	private String invoiceItemSeqId;
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Invoice Date Dim Id
	 */
	@Getter
	@Setter
	private String invoiceDateDimId;
	/**
	 * Product Dim Id
	 */
	@Getter
	@Setter
	private String productDimId;
	/**
	 * Bill To Customer Dim Id
	 */
	@Getter
	@Setter
	private String billToCustomerDimId;
	/**
	 * Orig Currency Dim Id
	 */
	@Getter
	@Setter
	private String origCurrencyDimId;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
	/**
	 * Ext Gross Amount
	 */
	@Getter
	@Setter
	private BigDecimal extGrossAmount;
	/**
	 * Ext Discount Amount
	 */
	@Getter
	@Setter
	private BigDecimal extDiscountAmount;
	/**
	 * Ext Net Amount
	 */
	@Getter
	@Setter
	private BigDecimal extNetAmount;
	/**
	 * Ext Tax Amount
	 */
	@Getter
	@Setter
	private BigDecimal extTaxAmount;
	/**
	 * Ext Man Fixed Cost
	 */
	@Getter
	@Setter
	private BigDecimal extManFixedCost;
	/**
	 * Ext Man Var Cost
	 */
	@Getter
	@Setter
	private BigDecimal extManVarCost;
	/**
	 * Ext Storage Cost
	 */
	@Getter
	@Setter
	private BigDecimal extStorageCost;
	/**
	 * Ext Distribution Cost
	 */
	@Getter
	@Setter
	private BigDecimal extDistributionCost;
	/**
	 * Contribution Amount
	 */
	@Getter
	@Setter
	private BigDecimal contributionAmount;

	public enum Fields {
		invoiceId, invoiceItemSeqId, orderId, invoiceDateDimId, productDimId, billToCustomerDimId, origCurrencyDimId, quantity, extGrossAmount, extDiscountAmount, extNetAmount, extTaxAmount, extManFixedCost, extManVarCost, extStorageCost, extDistributionCost, contributionAmount
	}

	public SalesInvoiceItemFact(GenericValue value) {
		invoiceId = (String) value.get(Fields.invoiceId.name());
		invoiceItemSeqId = (String) value.get(Fields.invoiceItemSeqId.name());
		orderId = (String) value.get(Fields.orderId.name());
		invoiceDateDimId = (String) value.get(Fields.invoiceDateDimId.name());
		productDimId = (String) value.get(Fields.productDimId.name());
		billToCustomerDimId = (String) value.get(Fields.billToCustomerDimId
				.name());
		origCurrencyDimId = (String) value.get(Fields.origCurrencyDimId.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		extGrossAmount = (BigDecimal) value.get(Fields.extGrossAmount.name());
		extDiscountAmount = (BigDecimal) value.get(Fields.extDiscountAmount
				.name());
		extNetAmount = (BigDecimal) value.get(Fields.extNetAmount.name());
		extTaxAmount = (BigDecimal) value.get(Fields.extTaxAmount.name());
		extManFixedCost = (BigDecimal) value.get(Fields.extManFixedCost.name());
		extManVarCost = (BigDecimal) value.get(Fields.extManVarCost.name());
		extStorageCost = (BigDecimal) value.get(Fields.extStorageCost.name());
		extDistributionCost = (BigDecimal) value.get(Fields.extDistributionCost
				.name());
		contributionAmount = (BigDecimal) value.get(Fields.contributionAmount
				.name());
	}

	public static SalesInvoiceItemFact fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SalesInvoiceItemFact(value);
	}

	public static List<SalesInvoiceItemFact> fromValues(
			List<GenericValue> values) {
		List<SalesInvoiceItemFact> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SalesInvoiceItemFact(value));
		}
		return entities;
	}
}