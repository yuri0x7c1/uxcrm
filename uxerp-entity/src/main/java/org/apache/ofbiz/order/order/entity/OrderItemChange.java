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
 * Order Item Change
 */
public class OrderItemChange implements Serializable {

	public static final long serialVersionUID = 4860040843527049216L;
	public static final String NAME = "OrderItemChange";
	/**
	 * Order Item Change Id
	 */
	@Getter
	@Setter
	private String orderItemChangeId;
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
	 * Change Type Enum Id
	 */
	@Getter
	@Setter
	private String changeTypeEnumId;
	/**
	 * Change Datetime
	 */
	@Getter
	@Setter
	private Timestamp changeDatetime;
	/**
	 * Change User Login
	 */
	@Getter
	@Setter
	private String changeUserLogin;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
	/**
	 * Cancel Quantity
	 */
	@Getter
	@Setter
	private BigDecimal cancelQuantity;
	/**
	 * Unit Price
	 */
	@Getter
	@Setter
	private BigDecimal unitPrice;
	/**
	 * Item Description
	 */
	@Getter
	@Setter
	private String itemDescription;
	/**
	 * Reason Enum Id
	 */
	@Getter
	@Setter
	private String reasonEnumId;
	/**
	 * Change Comments
	 */
	@Getter
	@Setter
	private String changeComments;

	public enum Fields {
		orderItemChangeId, orderId, orderItemSeqId, changeTypeEnumId, changeDatetime, changeUserLogin, quantity, cancelQuantity, unitPrice, itemDescription, reasonEnumId, changeComments
	}

	public OrderItemChange(GenericValue value) {
		orderItemChangeId = (String) value.get(Fields.orderItemChangeId.name());
		orderId = (String) value.get(Fields.orderId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		changeTypeEnumId = (String) value.get(Fields.changeTypeEnumId.name());
		changeDatetime = (Timestamp) value.get(Fields.changeDatetime.name());
		changeUserLogin = (String) value.get(Fields.changeUserLogin.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		cancelQuantity = (BigDecimal) value.get(Fields.cancelQuantity.name());
		unitPrice = (BigDecimal) value.get(Fields.unitPrice.name());
		itemDescription = (String) value.get(Fields.itemDescription.name());
		reasonEnumId = (String) value.get(Fields.reasonEnumId.name());
		changeComments = (String) value.get(Fields.changeComments.name());
	}

	public static OrderItemChange fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderItemChange(value);
	}

	public static List<OrderItemChange> fromValues(List<GenericValue> values) {
		List<OrderItemChange> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderItemChange(value));
		}
		return entities;
	}
}