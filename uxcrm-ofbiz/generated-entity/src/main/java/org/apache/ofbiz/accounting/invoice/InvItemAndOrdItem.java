package org.apache.ofbiz.accounting.invoice;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Inv Item And Ord Item
 */
public class InvItemAndOrdItem implements Serializable {

	public static final long serialVersionUID = 3433809323893910528L;
	public static final String NAME = "InvItemAndOrdItem";
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Order Item Seq Id
	 */
	@Getter
	@Setter
	private String orderItemSeqId;
	/**
	 * Amount
	 */
	@Getter
	@Setter
	private BigDecimal amount;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Override Org Party Id
	 */
	@Getter
	@Setter
	private String overrideOrgPartyId;
	/**
	 * Product Feature Id
	 */
	@Getter
	@Setter
	private String productFeatureId;
	/**
	 * Taxable Flag
	 */
	@Getter
	@Setter
	private String taxableFlag;
	/**
	 * Tax Authority Rate Seq Id
	 */
	@Getter
	@Setter
	private String taxAuthorityRateSeqId;
	/**
	 * Override Gl Account Id
	 */
	@Getter
	@Setter
	private String overrideGlAccountId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Invoice Item Seq Id
	 */
	@Getter
	@Setter
	private String invoiceItemSeqId;
	/**
	 * Uom Id
	 */
	@Getter
	@Setter
	private String uomId;
	/**
	 * Invoice Item Type Id
	 */
	@Getter
	@Setter
	private String invoiceItemTypeId;
	/**
	 * Inventory Item Id
	 */
	@Getter
	@Setter
	private String inventoryItemId;
	/**
	 * Tax Auth Party Id
	 */
	@Getter
	@Setter
	private String taxAuthPartyId;
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
	 * Tax Auth Geo Id
	 */
	@Getter
	@Setter
	private String taxAuthGeoId;
	/**
	 * Invoice Id
	 */
	@Getter
	@Setter
	private String invoiceId;
	/**
	 * Sales Opportunity Id
	 */
	@Getter
	@Setter
	private String salesOpportunityId;

	public enum Fields {
		orderId, orderItemSeqId, amount, quantity, productId, overrideOrgPartyId, productFeatureId, taxableFlag, taxAuthorityRateSeqId, overrideGlAccountId, description, invoiceItemSeqId, uomId, invoiceItemTypeId, inventoryItemId, taxAuthPartyId, parentInvoiceId, parentInvoiceItemSeqId, taxAuthGeoId, invoiceId, salesOpportunityId
	}

	public InvItemAndOrdItem(GenericValue value) {
		orderId = (String) value.get(Fields.orderId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		amount = (BigDecimal) value.get(Fields.amount.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		productId = (String) value.get(Fields.productId.name());
		overrideOrgPartyId = (String) value.get(Fields.overrideOrgPartyId
				.name());
		productFeatureId = (String) value.get(Fields.productFeatureId.name());
		taxableFlag = (String) value.get(Fields.taxableFlag.name());
		taxAuthorityRateSeqId = (String) value.get(Fields.taxAuthorityRateSeqId
				.name());
		overrideGlAccountId = (String) value.get(Fields.overrideGlAccountId
				.name());
		description = (String) value.get(Fields.description.name());
		invoiceItemSeqId = (String) value.get(Fields.invoiceItemSeqId.name());
		uomId = (String) value.get(Fields.uomId.name());
		invoiceItemTypeId = (String) value.get(Fields.invoiceItemTypeId.name());
		inventoryItemId = (String) value.get(Fields.inventoryItemId.name());
		taxAuthPartyId = (String) value.get(Fields.taxAuthPartyId.name());
		parentInvoiceId = (String) value.get(Fields.parentInvoiceId.name());
		parentInvoiceItemSeqId = (String) value
				.get(Fields.parentInvoiceItemSeqId.name());
		taxAuthGeoId = (String) value.get(Fields.taxAuthGeoId.name());
		invoiceId = (String) value.get(Fields.invoiceId.name());
		salesOpportunityId = (String) value.get(Fields.salesOpportunityId
				.name());
	}

	public static InvItemAndOrdItem fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new InvItemAndOrdItem(value);
	}

	public static List<InvItemAndOrdItem> fromValues(List<GenericValue> values) {
		List<InvItemAndOrdItem> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new InvItemAndOrdItem(value));
		}
		return entities;
	}
}