package org.apache.ofbiz.order.order;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Product Promo Code
 */
@FieldNameConstants
public class OrderProductPromoCode implements Serializable {

	public static final long serialVersionUID = 6587880900590771200L;
	public static final String NAME = "OrderProductPromoCode";
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Product Promo Code Id
	 */
	@Getter
	@Setter
	private String productPromoCodeId;
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

	public OrderProductPromoCode(GenericValue value) {
		orderId = (String) value.get(FIELD_ORDER_ID);
		productPromoCodeId = (String) value.get(FIELD_PRODUCT_PROMO_CODE_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static OrderProductPromoCode fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderProductPromoCode(value);
	}

	public static List<OrderProductPromoCode> fromValues(
			List<GenericValue> values) {
		List<OrderProductPromoCode> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderProductPromoCode(value));
		}
		return entities;
	}
}