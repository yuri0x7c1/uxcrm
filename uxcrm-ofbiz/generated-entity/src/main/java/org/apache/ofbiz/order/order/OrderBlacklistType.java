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
 * Order Blacklist Type
 */
@FieldNameConstants
public class OrderBlacklistType implements Serializable {

	public static final long serialVersionUID = 1054011382221529088L;
	public static final String NAME = "OrderBlacklistType";
	/**
	 * Order Blacklist Type Id
	 */
	@Getter
	@Setter
	private String orderBlacklistTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
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

	public OrderBlacklistType(GenericValue value) {
		orderBlacklistTypeId = (String) value
				.get(FIELD_ORDER_BLACKLIST_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static OrderBlacklistType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderBlacklistType(value);
	}

	public static List<OrderBlacklistType> fromValues(List<GenericValue> values) {
		List<OrderBlacklistType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderBlacklistType(value));
		}
		return entities;
	}
}