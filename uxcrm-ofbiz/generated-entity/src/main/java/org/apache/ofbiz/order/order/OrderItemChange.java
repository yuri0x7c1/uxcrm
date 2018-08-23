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
 * Order Item Change
 */
@FieldNameConstants
public class OrderItemChange implements Serializable {

	public static final long serialVersionUID = 694170321328348160L;
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

	public OrderItemChange(GenericValue value) {
		orderItemChangeId = (String) value.get(FIELD_ORDER_ITEM_CHANGE_ID);
		orderId = (String) value.get(FIELD_ORDER_ID);
		orderItemSeqId = (String) value.get(FIELD_ORDER_ITEM_SEQ_ID);
		changeTypeEnumId = (String) value.get(FIELD_CHANGE_TYPE_ENUM_ID);
		changeDatetime = (Timestamp) value.get(FIELD_CHANGE_DATETIME);
		changeUserLogin = (String) value.get(FIELD_CHANGE_USER_LOGIN);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
		cancelQuantity = (BigDecimal) value.get(FIELD_CANCEL_QUANTITY);
		unitPrice = (BigDecimal) value.get(FIELD_UNIT_PRICE);
		itemDescription = (String) value.get(FIELD_ITEM_DESCRIPTION);
		reasonEnumId = (String) value.get(FIELD_REASON_ENUM_ID);
		changeComments = (String) value.get(FIELD_CHANGE_COMMENTS);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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