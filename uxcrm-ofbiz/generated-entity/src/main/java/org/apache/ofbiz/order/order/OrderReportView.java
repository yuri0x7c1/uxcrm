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
 * Order Report View
 */
public class OrderReportView implements Serializable {

	public static final long serialVersionUID = 6595321839578449920L;
	public static final String NAME = "OrderReportView";
	/**
	 * Group Name
	 */
	@Getter
	@Setter
	private String groupName;
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
	 * Order Date
	 */
	@Getter
	@Setter
	private Timestamp orderDate;
	/**
	 * Order Status
	 */
	@Getter
	@Setter
	private String orderStatus;
	/**
	 * Payment Method
	 */
	@Getter
	@Setter
	private String paymentMethod;
	/**
	 * Visit Id
	 */
	@Getter
	@Setter
	private String visitId;
	/**
	 * Currency Uom
	 */
	@Getter
	@Setter
	private String currencyUom;
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
	 * Grand Total
	 */
	@Getter
	@Setter
	private BigDecimal grandTotal;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Item Description
	 */
	@Getter
	@Setter
	private String itemDescription;
	/**
	 * Item Status
	 */
	@Getter
	@Setter
	private String itemStatus;
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

	public enum Fields {
		groupName, orderId, orderTypeId, orderDate, orderStatus, paymentMethod, visitId, currencyUom, originFacilityId, webSiteId, grandTotal, productId, itemDescription, itemStatus, quantity, unitPrice
	}

	public OrderReportView(GenericValue value) {
		groupName = (String) value.get(Fields.groupName.name());
		orderId = (String) value.get(Fields.orderId.name());
		orderTypeId = (String) value.get(Fields.orderTypeId.name());
		orderDate = (Timestamp) value.get(Fields.orderDate.name());
		orderStatus = (String) value.get(Fields.orderStatus.name());
		paymentMethod = (String) value.get(Fields.paymentMethod.name());
		visitId = (String) value.get(Fields.visitId.name());
		currencyUom = (String) value.get(Fields.currencyUom.name());
		originFacilityId = (String) value.get(Fields.originFacilityId.name());
		webSiteId = (String) value.get(Fields.webSiteId.name());
		grandTotal = (BigDecimal) value.get(Fields.grandTotal.name());
		productId = (String) value.get(Fields.productId.name());
		itemDescription = (String) value.get(Fields.itemDescription.name());
		itemStatus = (String) value.get(Fields.itemStatus.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		unitPrice = (BigDecimal) value.get(Fields.unitPrice.name());
	}

	public static OrderReportView fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderReportView(value);
	}

	public static List<OrderReportView> fromValues(List<GenericValue> values) {
		List<OrderReportView> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderReportView(value));
		}
		return entities;
	}
}