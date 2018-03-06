package org.apache.ofbiz.accounting.invoice.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Invoice Item
 */
public class InvoiceItem implements Serializable {

	public static final long serialVersionUID = 4181850163458019328L;
	public static final String NAME = "InvoiceItem";
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
	 * Invoice Item Type Id
	 */
	@Getter
	@Setter
	private String invoiceItemTypeId;
	/**
	 * Override Gl Account Id
	 */
	@Getter
	@Setter
	private String overrideGlAccountId;
	/**
	 * Override Org Party Id
	 */
	@Getter
	@Setter
	private String overrideOrgPartyId;
	/**
	 * Inventory Item Id
	 */
	@Getter
	@Setter
	private String inventoryItemId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Product Feature Id
	 */
	@Getter
	@Setter
	private String productFeatureId;
	/**
	 * Parent Invoice Id
	 */
	@Getter
	@Setter
	private String parentInvoiceId;
	/**
	 * Parent Invoice Item Seq Id
	 */
	@Getter
	@Setter
	private String parentInvoiceItemSeqId;
	/**
	 * Uom Id
	 */
	@Getter
	@Setter
	private String uomId;
	/**
	 * Taxable Flag
	 */
	@Getter
	@Setter
	private String taxableFlag;
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
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Tax Auth Party Id
	 */
	@Getter
	@Setter
	private String taxAuthPartyId;
	/**
	 * Tax Auth Geo Id
	 */
	@Getter
	@Setter
	private String taxAuthGeoId;
	/**
	 * Tax Authority Rate Seq Id
	 */
	@Getter
	@Setter
	private String taxAuthorityRateSeqId;
	/**
	 * Sales Opportunity Id
	 */
	@Getter
	@Setter
	private String salesOpportunityId;

	public enum Fields {
		invoiceId, invoiceItemSeqId, invoiceItemTypeId, overrideGlAccountId, overrideOrgPartyId, inventoryItemId, productId, productFeatureId, parentInvoiceId, parentInvoiceItemSeqId, uomId, taxableFlag, quantity, amount, description, taxAuthPartyId, taxAuthGeoId, taxAuthorityRateSeqId, salesOpportunityId
	}

	public InvoiceItem(GenericValue value) {
		invoiceId = (String) value.get(Fields.invoiceId.name());
		invoiceItemSeqId = (String) value.get(Fields.invoiceItemSeqId.name());
		invoiceItemTypeId = (String) value.get(Fields.invoiceItemTypeId.name());
		overrideGlAccountId = (String) value.get(Fields.overrideGlAccountId
				.name());
		overrideOrgPartyId = (String) value.get(Fields.overrideOrgPartyId
				.name());
		inventoryItemId = (String) value.get(Fields.inventoryItemId.name());
		productId = (String) value.get(Fields.productId.name());
		productFeatureId = (String) value.get(Fields.productFeatureId.name());
		parentInvoiceId = (String) value.get(Fields.parentInvoiceId.name());
		parentInvoiceItemSeqId = (String) value
				.get(Fields.parentInvoiceItemSeqId.name());
		uomId = (String) value.get(Fields.uomId.name());
		taxableFlag = (String) value.get(Fields.taxableFlag.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		amount = (BigDecimal) value.get(Fields.amount.name());
		description = (String) value.get(Fields.description.name());
		taxAuthPartyId = (String) value.get(Fields.taxAuthPartyId.name());
		taxAuthGeoId = (String) value.get(Fields.taxAuthGeoId.name());
		taxAuthorityRateSeqId = (String) value.get(Fields.taxAuthorityRateSeqId
				.name());
		salesOpportunityId = (String) value.get(Fields.salesOpportunityId
				.name());
	}

	public static InvoiceItem fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InvoiceItem(value);
	}

	public static List<InvoiceItem> fromValues(List<GenericValue> values) {
		List<InvoiceItem> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InvoiceItem(value));
		}
		return entities;
	}
}