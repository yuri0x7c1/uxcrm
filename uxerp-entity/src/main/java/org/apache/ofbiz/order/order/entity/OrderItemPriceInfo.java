package org.apache.ofbiz.order.order.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Item Price Info
 */
public class OrderItemPriceInfo implements Serializable {

	public static final long serialVersionUID = 5938733097725256704L;
	public static final String NAME = "OrderItemPriceInfo";
	/**
	 * Order Item Price Info Id
	 */
	@Getter
	@Setter
	private String orderItemPriceInfoId;
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
	 * Product Price Rule Id
	 */
	@Getter
	@Setter
	private String productPriceRuleId;
	/**
	 * Product Price Action Seq Id
	 */
	@Getter
	@Setter
	private String productPriceActionSeqId;
	/**
	 * Modify Amount
	 */
	@Getter
	@Setter
	private BigDecimal modifyAmount;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Rate Code
	 */
	@Getter
	@Setter
	private String rateCode;

	public enum Fields {
		orderItemPriceInfoId, orderId, orderItemSeqId, productPriceRuleId, productPriceActionSeqId, modifyAmount, description, rateCode
	}

	public OrderItemPriceInfo(GenericValue value) {
		orderItemPriceInfoId = (String) value.get(Fields.orderItemPriceInfoId
				.name());
		orderId = (String) value.get(Fields.orderId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		productPriceRuleId = (String) value.get(Fields.productPriceRuleId
				.name());
		productPriceActionSeqId = (String) value
				.get(Fields.productPriceActionSeqId.name());
		modifyAmount = (BigDecimal) value.get(Fields.modifyAmount.name());
		description = (String) value.get(Fields.description.name());
		rateCode = (String) value.get(Fields.rateCode.name());
	}

	public static OrderItemPriceInfo fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderItemPriceInfo(value);
	}

	public static List<OrderItemPriceInfo> fromValues(List<GenericValue> values) {
		List<OrderItemPriceInfo> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderItemPriceInfo(value));
		}
		return entities;
	}
}