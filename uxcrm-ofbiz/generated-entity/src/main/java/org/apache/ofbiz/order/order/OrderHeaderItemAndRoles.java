package org.apache.ofbiz.order.order;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Header Item And Roles
 */
public class OrderHeaderItemAndRoles implements Serializable {

	public static final long serialVersionUID = 5111990963400854528L;
	public static final String NAME = "OrderHeaderItemAndRoles";
	/**
	 * Order Name
	 */
	@Getter
	@Setter
	private String orderName;
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Role Type Id
	 */
	@Getter
	@Setter
	private String roleTypeId;
	/**
	 * Order Type Id
	 */
	@Getter
	@Setter
	private String orderTypeId;
	/**
	 * Order Date
	 */
	@Getter
	@Setter
	private Timestamp orderDate;
	/**
	 * Entry Date
	 */
	@Getter
	@Setter
	private Timestamp entryDate;
	/**
	 * Visit Id
	 */
	@Getter
	@Setter
	private String visitId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Created By
	 */
	@Getter
	@Setter
	private String createdBy;
	/**
	 * First Attempt Order Id
	 */
	@Getter
	@Setter
	private String firstAttemptOrderId;
	/**
	 * Currency Uom
	 */
	@Getter
	@Setter
	private String currencyUom;
	/**
	 * Sync Status Id
	 */
	@Getter
	@Setter
	private String syncStatusId;
	/**
	 * Billing Account Id
	 */
	@Getter
	@Setter
	private String billingAccountId;
	/**
	 * Origin Facility Id
	 */
	@Getter
	@Setter
	private String originFacilityId;
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Web Site Id
	 */
	@Getter
	@Setter
	private String webSiteId;
	/**
	 * Grand Total
	 */
	@Getter
	@Setter
	private BigDecimal grandTotal;
	/**
	 * Remaining Sub Total
	 */
	@Getter
	@Setter
	private BigDecimal remainingSubTotal;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
	/**
	 * Unit Price
	 */
	@Getter
	@Setter
	private BigDecimal unitPrice;
	/**
	 * Unit List Price
	 */
	@Getter
	@Setter
	private BigDecimal unitListPrice;
	/**
	 * Estimated Ship Date
	 */
	@Getter
	@Setter
	private Timestamp estimatedShipDate;
	/**
	 * Auto Cancel Date
	 */
	@Getter
	@Setter
	private Timestamp autoCancelDate;
	/**
	 * Corresponding Po Id
	 */
	@Getter
	@Setter
	private String correspondingPoId;
	/**
	 * Order Item Type Id
	 */
	@Getter
	@Setter
	private String orderItemTypeId;
	/**
	 * Item Description
	 */
	@Getter
	@Setter
	private String itemDescription;
	/**
	 * Order Item Seq Id
	 */
	@Getter
	@Setter
	private String orderItemSeqId;
	/**
	 * Order Item Status Id
	 */
	@Getter
	@Setter
	private String orderItemStatusId;

	public enum Fields {
		orderName, orderId, partyId, roleTypeId, orderTypeId, orderDate, entryDate, visitId, statusId, createdBy, firstAttemptOrderId, currencyUom, syncStatusId, billingAccountId, originFacilityId, productStoreId, webSiteId, grandTotal, remainingSubTotal, productId, quantity, unitPrice, unitListPrice, estimatedShipDate, autoCancelDate, correspondingPoId, orderItemTypeId, itemDescription, orderItemSeqId, orderItemStatusId
	}

	public OrderHeaderItemAndRoles(GenericValue value) {
		orderName = (String) value.get(Fields.orderName.name());
		orderId = (String) value.get(Fields.orderId.name());
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		orderTypeId = (String) value.get(Fields.orderTypeId.name());
		orderDate = (Timestamp) value.get(Fields.orderDate.name());
		entryDate = (Timestamp) value.get(Fields.entryDate.name());
		visitId = (String) value.get(Fields.visitId.name());
		statusId = (String) value.get(Fields.statusId.name());
		createdBy = (String) value.get(Fields.createdBy.name());
		firstAttemptOrderId = (String) value.get(Fields.firstAttemptOrderId
				.name());
		currencyUom = (String) value.get(Fields.currencyUom.name());
		syncStatusId = (String) value.get(Fields.syncStatusId.name());
		billingAccountId = (String) value.get(Fields.billingAccountId.name());
		originFacilityId = (String) value.get(Fields.originFacilityId.name());
		productStoreId = (String) value.get(Fields.productStoreId.name());
		webSiteId = (String) value.get(Fields.webSiteId.name());
		grandTotal = (BigDecimal) value.get(Fields.grandTotal.name());
		remainingSubTotal = (BigDecimal) value.get(Fields.remainingSubTotal
				.name());
		productId = (String) value.get(Fields.productId.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		unitPrice = (BigDecimal) value.get(Fields.unitPrice.name());
		unitListPrice = (BigDecimal) value.get(Fields.unitListPrice.name());
		estimatedShipDate = (Timestamp) value.get(Fields.estimatedShipDate
				.name());
		autoCancelDate = (Timestamp) value.get(Fields.autoCancelDate.name());
		correspondingPoId = (String) value.get(Fields.correspondingPoId.name());
		orderItemTypeId = (String) value.get(Fields.orderItemTypeId.name());
		itemDescription = (String) value.get(Fields.itemDescription.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		orderItemStatusId = (String) value.get(Fields.orderItemStatusId.name());
	}

	public static OrderHeaderItemAndRoles fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderHeaderItemAndRoles(value);
	}

	public static List<OrderHeaderItemAndRoles> fromValues(
			List<GenericValue> values) {
		List<OrderHeaderItemAndRoles> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderHeaderItemAndRoles(value));
		}
		return entities;
	}
}