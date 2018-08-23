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
 * Order Blacklist
 */
@FieldNameConstants
public class OrderBlacklist implements Serializable {

	public static final long serialVersionUID = 9059490525447218176L;
	public static final String NAME = "OrderBlacklist";
	/**
	 * Blacklist String
	 */
	@Getter
	@Setter
	private String blacklistString;
	/**
	 * Order Blacklist Type Id
	 */
	@Getter
	@Setter
	private String orderBlacklistTypeId;
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

	public OrderBlacklist(GenericValue value) {
		blacklistString = (String) value.get(FIELD_BLACKLIST_STRING);
		orderBlacklistTypeId = (String) value
				.get(FIELD_ORDER_BLACKLIST_TYPE_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static OrderBlacklist fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderBlacklist(value);
	}

	public static List<OrderBlacklist> fromValues(List<GenericValue> values) {
		List<OrderBlacklist> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderBlacklist(value));
		}
		return entities;
	}
}