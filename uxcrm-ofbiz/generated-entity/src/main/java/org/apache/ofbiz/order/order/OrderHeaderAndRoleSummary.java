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
 * Order Header And Role Summary
 */
@FieldNameConstants
public class OrderHeaderAndRoleSummary implements Serializable {

	public static final long serialVersionUID = 6910562269156856832L;
	public static final String NAME = "OrderHeaderAndRoleSummary";
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
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Total Grand Amount
	 */
	@Getter
	@Setter
	private BigDecimal totalGrandAmount;
	/**
	 * Total Sub Remaining Amount
	 */
	@Getter
	@Setter
	private BigDecimal totalSubRemainingAmount;
	/**
	 * Total Orders
	 */
	@Getter
	@Setter
	private Long totalOrders;

	public OrderHeaderAndRoleSummary(GenericValue value) {
		partyId = (String) value.get(FIELD_PARTY_ID);
		roleTypeId = (String) value.get(FIELD_ROLE_TYPE_ID);
		orderId = (String) value.get(FIELD_ORDER_ID);
		orderTypeId = (String) value.get(FIELD_ORDER_TYPE_ID);
		orderDate = (Timestamp) value.get(FIELD_ORDER_DATE);
		statusId = (String) value.get(FIELD_STATUS_ID);
		totalGrandAmount = (BigDecimal) value.get(FIELD_TOTAL_GRAND_AMOUNT);
		totalSubRemainingAmount = (BigDecimal) value
				.get(FIELD_TOTAL_SUB_REMAINING_AMOUNT);
		totalOrders = (Long) value.get(FIELD_TOTAL_ORDERS);
	}

	public static OrderHeaderAndRoleSummary fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderHeaderAndRoleSummary(value);
	}

	public static List<OrderHeaderAndRoleSummary> fromValues(
			List<GenericValue> values) {
		List<OrderHeaderAndRoleSummary> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderHeaderAndRoleSummary(value));
		}
		return entities;
	}
}