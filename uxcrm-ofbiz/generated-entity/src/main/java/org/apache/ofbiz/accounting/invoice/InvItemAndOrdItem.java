package org.apache.ofbiz.accounting.invoice;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class InvItemAndOrdItem implements Serializable {

	public static final long serialVersionUID = 6663018010884912128L;
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

	public InvItemAndOrdItem(GenericValue value) {
		orderId = (String) value.get(FIELD_ORDER_ID);
		orderItemSeqId = (String) value.get(FIELD_ORDER_ITEM_SEQ_ID);
		amount = (BigDecimal) value.get(FIELD_AMOUNT);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		overrideOrgPartyId = (String) value.get(FIELD_OVERRIDE_ORG_PARTY_ID);
		productFeatureId = (String) value.get(FIELD_PRODUCT_FEATURE_ID);
		taxableFlag = (String) value.get(FIELD_TAXABLE_FLAG);
		taxAuthorityRateSeqId = (String) value
				.get(FIELD_TAX_AUTHORITY_RATE_SEQ_ID);
		overrideGlAccountId = (String) value.get(FIELD_OVERRIDE_GL_ACCOUNT_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		invoiceItemSeqId = (String) value.get(FIELD_INVOICE_ITEM_SEQ_ID);
		uomId = (String) value.get(FIELD_UOM_ID);
		invoiceItemTypeId = (String) value.get(FIELD_INVOICE_ITEM_TYPE_ID);
		inventoryItemId = (String) value.get(FIELD_INVENTORY_ITEM_ID);
		taxAuthPartyId = (String) value.get(FIELD_TAX_AUTH_PARTY_ID);
		parentInvoiceId = (String) value.get(FIELD_PARENT_INVOICE_ID);
		parentInvoiceItemSeqId = (String) value
				.get(FIELD_PARENT_INVOICE_ITEM_SEQ_ID);
		taxAuthGeoId = (String) value.get(FIELD_TAX_AUTH_GEO_ID);
		invoiceId = (String) value.get(FIELD_INVOICE_ID);
		salesOpportunityId = (String) value.get(FIELD_SALES_OPPORTUNITY_ID);
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