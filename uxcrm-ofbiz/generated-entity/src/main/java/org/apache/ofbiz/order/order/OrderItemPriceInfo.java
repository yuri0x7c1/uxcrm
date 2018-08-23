package org.apache.ofbiz.order.order;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Item Price Info
 */
@FieldNameConstants
public class OrderItemPriceInfo implements Serializable {

	public static final long serialVersionUID = 7705809388288310272L;
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

	public OrderItemPriceInfo(GenericValue value) {
		orderItemPriceInfoId = (String) value
				.get(FIELD_ORDER_ITEM_PRICE_INFO_ID);
		orderId = (String) value.get(FIELD_ORDER_ID);
		orderItemSeqId = (String) value.get(FIELD_ORDER_ITEM_SEQ_ID);
		productPriceRuleId = (String) value.get(FIELD_PRODUCT_PRICE_RULE_ID);
		productPriceActionSeqId = (String) value
				.get(FIELD_PRODUCT_PRICE_ACTION_SEQ_ID);
		modifyAmount = (BigDecimal) value.get(FIELD_MODIFY_AMOUNT);
		description = (String) value.get(FIELD_DESCRIPTION);
		rateCode = (String) value.get(FIELD_RATE_CODE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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