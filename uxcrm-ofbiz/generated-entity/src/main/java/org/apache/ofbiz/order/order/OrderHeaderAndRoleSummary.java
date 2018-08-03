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
 * Order Header And Role Summary
 */
public class OrderHeaderAndRoleSummary implements Serializable {

	public static final long serialVersionUID = 8820630825559824384L;
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

	public enum Fields {
		partyId, roleTypeId, orderId, orderTypeId, orderDate, statusId, totalGrandAmount, totalSubRemainingAmount, totalOrders
	}

	public OrderHeaderAndRoleSummary(GenericValue value) {
		partyId = (String) value.get(Fields.partyId.name());
		roleTypeId = (String) value.get(Fields.roleTypeId.name());
		orderId = (String) value.get(Fields.orderId.name());
		orderTypeId = (String) value.get(Fields.orderTypeId.name());
		orderDate = (Timestamp) value.get(Fields.orderDate.name());
		statusId = (String) value.get(Fields.statusId.name());
		totalGrandAmount = (BigDecimal) value.get(Fields.totalGrandAmount
				.name());
		totalSubRemainingAmount = (BigDecimal) value
				.get(Fields.totalSubRemainingAmount.name());
		totalOrders = (Long) value.get(Fields.totalOrders.name());
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