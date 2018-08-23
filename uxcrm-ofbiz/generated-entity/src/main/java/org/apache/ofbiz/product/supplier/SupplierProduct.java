package org.apache.ofbiz.product.supplier;

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
 * Supplier Product
 */
@FieldNameConstants
public class SupplierProduct implements Serializable {

	public static final long serialVersionUID = 3335634858860030976L;
	public static final String NAME = "SupplierProduct";
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Available From Date
	 */
	@Getter
	@Setter
	private Timestamp availableFromDate;
	/**
	 * Available Thru Date
	 */
	@Getter
	@Setter
	private Timestamp availableThruDate;
	/**
	 * Supplier Pref Order Id
	 */
	@Getter
	@Setter
	private String supplierPrefOrderId;
	/**
	 * Supplier Rating Type Id
	 */
	@Getter
	@Setter
	private String supplierRatingTypeId;
	/**
	 * Standard Lead Time Days
	 */
	@Getter
	@Setter
	private BigDecimal standardLeadTimeDays;
	/**
	 * Minimum Order Quantity
	 */
	@Getter
	@Setter
	private BigDecimal minimumOrderQuantity;
	/**
	 * Order Qty Increments
	 */
	@Getter
	@Setter
	private BigDecimal orderQtyIncrements;
	/**
	 * Units Included
	 */
	@Getter
	@Setter
	private BigDecimal unitsIncluded;
	/**
	 * Quantity Uom Id
	 */
	@Getter
	@Setter
	private String quantityUomId;
	/**
	 * Agreement Id
	 */
	@Getter
	@Setter
	private String agreementId;
	/**
	 * Agreement Item Seq Id
	 */
	@Getter
	@Setter
	private String agreementItemSeqId;
	/**
	 * Last Price
	 */
	@Getter
	@Setter
	private BigDecimal lastPrice;
	/**
	 * Shipping Price
	 */
	@Getter
	@Setter
	private BigDecimal shippingPrice;
	/**
	 * Currency Uom Id
	 */
	@Getter
	@Setter
	private String currencyUomId;
	/**
	 * Supplier Product Name
	 */
	@Getter
	@Setter
	private String supplierProductName;
	/**
	 * Supplier Product Id
	 */
	@Getter
	@Setter
	private String supplierProductId;
	/**
	 * Can Drop Ship
	 */
	@Getter
	@Setter
	private String canDropShip;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
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

	public SupplierProduct(GenericValue value) {
		productId = (String) value.get(FIELD_PRODUCT_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		availableFromDate = (Timestamp) value.get(FIELD_AVAILABLE_FROM_DATE);
		availableThruDate = (Timestamp) value.get(FIELD_AVAILABLE_THRU_DATE);
		supplierPrefOrderId = (String) value.get(FIELD_SUPPLIER_PREF_ORDER_ID);
		supplierRatingTypeId = (String) value
				.get(FIELD_SUPPLIER_RATING_TYPE_ID);
		standardLeadTimeDays = (BigDecimal) value
				.get(FIELD_STANDARD_LEAD_TIME_DAYS);
		minimumOrderQuantity = (BigDecimal) value
				.get(FIELD_MINIMUM_ORDER_QUANTITY);
		orderQtyIncrements = (BigDecimal) value.get(FIELD_ORDER_QTY_INCREMENTS);
		unitsIncluded = (BigDecimal) value.get(FIELD_UNITS_INCLUDED);
		quantityUomId = (String) value.get(FIELD_QUANTITY_UOM_ID);
		agreementId = (String) value.get(FIELD_AGREEMENT_ID);
		agreementItemSeqId = (String) value.get(FIELD_AGREEMENT_ITEM_SEQ_ID);
		lastPrice = (BigDecimal) value.get(FIELD_LAST_PRICE);
		shippingPrice = (BigDecimal) value.get(FIELD_SHIPPING_PRICE);
		currencyUomId = (String) value.get(FIELD_CURRENCY_UOM_ID);
		supplierProductName = (String) value.get(FIELD_SUPPLIER_PRODUCT_NAME);
		supplierProductId = (String) value.get(FIELD_SUPPLIER_PRODUCT_ID);
		canDropShip = (String) value.get(FIELD_CAN_DROP_SHIP);
		comments = (String) value.get(FIELD_COMMENTS);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static SupplierProduct fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SupplierProduct(value);
	}

	public static List<SupplierProduct> fromValues(List<GenericValue> values) {
		List<SupplierProduct> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SupplierProduct(value));
		}
		return entities;
	}
}