package org.apache.ofbiz.order.order;

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
 * Order Report Purchases Group By Product
 */
@FieldNameConstants
public class OrderReportPurchasesGroupByProduct implements Serializable {

	public static final long serialVersionUID = 2839179776502331392L;
	public static final String NAME = "OrderReportPurchasesGroupByProduct";
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Internal Name
	 */
	@Getter
	@Setter
	private String internalName;
	/**
	 * Order Date
	 */
	@Getter
	@Setter
	private Timestamp orderDate;
	/**
	 * Order Status Id
	 */
	@Getter
	@Setter
	private String orderStatusId;
	/**
	 * Order Item Status Id
	 */
	@Getter
	@Setter
	private String orderItemStatusId;
	/**
	 * Order Type Id
	 */
	@Getter
	@Setter
	private String orderTypeId;
	/**
	 * To Party Id
	 */
	@Getter
	@Setter
	private String toPartyId;
	/**
	 * To Role Type Id
	 */
	@Getter
	@Setter
	private String toRoleTypeId;
	/**
	 * From Party Id
	 */
	@Getter
	@Setter
	private String fromPartyId;
	/**
	 * From Role Type Id
	 */
	@Getter
	@Setter
	private String fromRoleTypeId;
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

	public OrderReportPurchasesGroupByProduct(GenericValue value) {
		productId = (String) value.get(FIELD_PRODUCT_ID);
		internalName = (String) value.get(FIELD_INTERNAL_NAME);
		orderDate = (Timestamp) value.get(FIELD_ORDER_DATE);
		orderStatusId = (String) value.get(FIELD_ORDER_STATUS_ID);
		orderItemStatusId = (String) value.get(FIELD_ORDER_ITEM_STATUS_ID);
		orderTypeId = (String) value.get(FIELD_ORDER_TYPE_ID);
		toPartyId = (String) value.get(FIELD_TO_PARTY_ID);
		toRoleTypeId = (String) value.get(FIELD_TO_ROLE_TYPE_ID);
		fromPartyId = (String) value.get(FIELD_FROM_PARTY_ID);
		fromRoleTypeId = (String) value.get(FIELD_FROM_ROLE_TYPE_ID);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
		unitPrice = (BigDecimal) value.get(FIELD_UNIT_PRICE);
	}

	public static OrderReportPurchasesGroupByProduct fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderReportPurchasesGroupByProduct(value);
	}

	public static List<OrderReportPurchasesGroupByProduct> fromValues(
			List<GenericValue> values) {
		List<OrderReportPurchasesGroupByProduct> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderReportPurchasesGroupByProduct(value));
		}
		return entities;
	}
}