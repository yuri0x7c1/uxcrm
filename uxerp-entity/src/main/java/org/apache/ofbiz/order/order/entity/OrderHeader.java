package org.apache.ofbiz.order.order.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Header
 */
public class OrderHeader implements Serializable {

	public static final long serialVersionUID = 3555463060423960576L;
	public static final String NAME = "OrderHeader";
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Order Type Id
	 */
	@Getter
	@Setter
	private String orderTypeId;
	/**
	 * Order Name
	 */
	@Getter
	@Setter
	private String orderName;
	/**
	 * External Id
	 */
	@Getter
	@Setter
	private String externalId;
	/**
	 * Sales Channel Enum Id
	 */
	@Getter
	@Setter
	private String salesChannelEnumId;
	/**
	 * Order Date
	 */
	@Getter
	@Setter
	private Timestamp orderDate;
	/**
	 * Priority
	 */
	@Getter
	@Setter
	private String priority;
	/**
	 * Entry Date
	 */
	@Getter
	@Setter
	private Timestamp entryDate;
	/**
	 * Pick Sheet Printed Date
	 */
	@Getter
	@Setter
	private Timestamp pickSheetPrintedDate;
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
	 * Web Site Id
	 */
	@Getter
	@Setter
	private String webSiteId;
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Terminal Id
	 */
	@Getter
	@Setter
	private String terminalId;
	/**
	 * Transaction Id
	 */
	@Getter
	@Setter
	private String transactionId;
	/**
	 * Auto Order Shopping List Id
	 */
	@Getter
	@Setter
	private String autoOrderShoppingListId;
	/**
	 * Needs Inventory Issuance
	 */
	@Getter
	@Setter
	private String needsInventoryIssuance;
	/**
	 * Is Rush Order
	 */
	@Getter
	@Setter
	private String isRushOrder;
	/**
	 * Internal Code
	 */
	@Getter
	@Setter
	private String internalCode;
	/**
	 * Remaining Sub Total
	 */
	@Getter
	@Setter
	private BigDecimal remainingSubTotal;
	/**
	 * Grand Total
	 */
	@Getter
	@Setter
	private BigDecimal grandTotal;
	/**
	 * Is Viewed
	 */
	@Getter
	@Setter
	private String isViewed;
	/**
	 * Invoice Per Shipment
	 */
	@Getter
	@Setter
	private String invoicePerShipment;

	public enum Fields {
		orderId, orderTypeId, orderName, externalId, salesChannelEnumId, orderDate, priority, entryDate, pickSheetPrintedDate, visitId, statusId, createdBy, firstAttemptOrderId, currencyUom, syncStatusId, billingAccountId, originFacilityId, webSiteId, productStoreId, terminalId, transactionId, autoOrderShoppingListId, needsInventoryIssuance, isRushOrder, internalCode, remainingSubTotal, grandTotal, isViewed, invoicePerShipment
	}

	public OrderHeader(GenericValue value) {
		orderId = (String) value.get(Fields.orderId.name());
		orderTypeId = (String) value.get(Fields.orderTypeId.name());
		orderName = (String) value.get(Fields.orderName.name());
		externalId = (String) value.get(Fields.externalId.name());
		salesChannelEnumId = (String) value.get(Fields.salesChannelEnumId
				.name());
		orderDate = (Timestamp) value.get(Fields.orderDate.name());
		priority = (String) value.get(Fields.priority.name());
		entryDate = (Timestamp) value.get(Fields.entryDate.name());
		pickSheetPrintedDate = (Timestamp) value
				.get(Fields.pickSheetPrintedDate.name());
		visitId = (String) value.get(Fields.visitId.name());
		statusId = (String) value.get(Fields.statusId.name());
		createdBy = (String) value.get(Fields.createdBy.name());
		firstAttemptOrderId = (String) value.get(Fields.firstAttemptOrderId
				.name());
		currencyUom = (String) value.get(Fields.currencyUom.name());
		syncStatusId = (String) value.get(Fields.syncStatusId.name());
		billingAccountId = (String) value.get(Fields.billingAccountId.name());
		originFacilityId = (String) value.get(Fields.originFacilityId.name());
		webSiteId = (String) value.get(Fields.webSiteId.name());
		productStoreId = (String) value.get(Fields.productStoreId.name());
		terminalId = (String) value.get(Fields.terminalId.name());
		transactionId = (String) value.get(Fields.transactionId.name());
		autoOrderShoppingListId = (String) value
				.get(Fields.autoOrderShoppingListId.name());
		needsInventoryIssuance = (String) value
				.get(Fields.needsInventoryIssuance.name());
		isRushOrder = (String) value.get(Fields.isRushOrder.name());
		internalCode = (String) value.get(Fields.internalCode.name());
		remainingSubTotal = (BigDecimal) value.get(Fields.remainingSubTotal
				.name());
		grandTotal = (BigDecimal) value.get(Fields.grandTotal.name());
		isViewed = (String) value.get(Fields.isViewed.name());
		invoicePerShipment = (String) value.get(Fields.invoicePerShipment
				.name());
	}

	public static OrderHeader fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderHeader(value);
	}

	public static List<OrderHeader> fromValues(List<GenericValue> values) {
		List<OrderHeader> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderHeader(value));
		}
		return entities;
	}
}