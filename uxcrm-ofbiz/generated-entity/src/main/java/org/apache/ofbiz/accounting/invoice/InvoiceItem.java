package org.apache.ofbiz.accounting.invoice;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Invoice Item
 */
@FieldNameConstants
public class InvoiceItem implements Serializable {

	public static final long serialVersionUID = 1994409528421427200L;
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

	public InvoiceItem(GenericValue value) {
		invoiceId = (String) value.get(FIELD_INVOICE_ID);
		invoiceItemSeqId = (String) value.get(FIELD_INVOICE_ITEM_SEQ_ID);
		invoiceItemTypeId = (String) value.get(FIELD_INVOICE_ITEM_TYPE_ID);
		overrideGlAccountId = (String) value.get(FIELD_OVERRIDE_GL_ACCOUNT_ID);
		overrideOrgPartyId = (String) value.get(FIELD_OVERRIDE_ORG_PARTY_ID);
		inventoryItemId = (String) value.get(FIELD_INVENTORY_ITEM_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		productFeatureId = (String) value.get(FIELD_PRODUCT_FEATURE_ID);
		parentInvoiceId = (String) value.get(FIELD_PARENT_INVOICE_ID);
		parentInvoiceItemSeqId = (String) value
				.get(FIELD_PARENT_INVOICE_ITEM_SEQ_ID);
		uomId = (String) value.get(FIELD_UOM_ID);
		taxableFlag = (String) value.get(FIELD_TAXABLE_FLAG);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
		amount = (BigDecimal) value.get(FIELD_AMOUNT);
		description = (String) value.get(FIELD_DESCRIPTION);
		taxAuthPartyId = (String) value.get(FIELD_TAX_AUTH_PARTY_ID);
		taxAuthGeoId = (String) value.get(FIELD_TAX_AUTH_GEO_ID);
		taxAuthorityRateSeqId = (String) value
				.get(FIELD_TAX_AUTHORITY_RATE_SEQ_ID);
		salesOpportunityId = (String) value.get(FIELD_SALES_OPPORTUNITY_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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