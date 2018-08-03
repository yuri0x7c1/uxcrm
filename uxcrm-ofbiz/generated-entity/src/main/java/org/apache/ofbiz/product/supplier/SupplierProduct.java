package org.apache.ofbiz.product.supplier;

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
public class SupplierProduct implements Serializable {

	public static final long serialVersionUID = 9052857463504618496L;
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

	public enum Fields {
		productId, partyId, availableFromDate, availableThruDate, supplierPrefOrderId, supplierRatingTypeId, standardLeadTimeDays, minimumOrderQuantity, orderQtyIncrements, unitsIncluded, quantityUomId, agreementId, agreementItemSeqId, lastPrice, shippingPrice, currencyUomId, supplierProductName, supplierProductId, canDropShip, comments, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public SupplierProduct(GenericValue value) {
		productId = (String) value.get(Fields.productId.name());
		partyId = (String) value.get(Fields.partyId.name());
		availableFromDate = (Timestamp) value.get(Fields.availableFromDate
				.name());
		availableThruDate = (Timestamp) value.get(Fields.availableThruDate
				.name());
		supplierPrefOrderId = (String) value.get(Fields.supplierPrefOrderId
				.name());
		supplierRatingTypeId = (String) value.get(Fields.supplierRatingTypeId
				.name());
		standardLeadTimeDays = (BigDecimal) value
				.get(Fields.standardLeadTimeDays.name());
		minimumOrderQuantity = (BigDecimal) value
				.get(Fields.minimumOrderQuantity.name());
		orderQtyIncrements = (BigDecimal) value.get(Fields.orderQtyIncrements
				.name());
		unitsIncluded = (BigDecimal) value.get(Fields.unitsIncluded.name());
		quantityUomId = (String) value.get(Fields.quantityUomId.name());
		agreementId = (String) value.get(Fields.agreementId.name());
		agreementItemSeqId = (String) value.get(Fields.agreementItemSeqId
				.name());
		lastPrice = (BigDecimal) value.get(Fields.lastPrice.name());
		shippingPrice = (BigDecimal) value.get(Fields.shippingPrice.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		supplierProductName = (String) value.get(Fields.supplierProductName
				.name());
		supplierProductId = (String) value.get(Fields.supplierProductId.name());
		canDropShip = (String) value.get(Fields.canDropShip.name());
		comments = (String) value.get(Fields.comments.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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