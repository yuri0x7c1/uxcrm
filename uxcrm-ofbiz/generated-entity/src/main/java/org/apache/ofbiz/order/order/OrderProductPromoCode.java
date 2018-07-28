package org.apache.ofbiz.order.order;

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
public class OrderProductPromoCode implements Serializable {

	public static final long serialVersionUID = 77977109193137152L;
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

	public enum Fields {
		orderId, productPromoCodeId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public OrderProductPromoCode(GenericValue value) {
		orderId = (String) value.get(Fields.orderId.name());
		productPromoCodeId = (String) value.get(Fields.productPromoCodeId
				.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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