package org.apache.ofbiz.order.order;

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
public class OrderBlacklist implements Serializable {

	public static final long serialVersionUID = 7921728584340214784L;
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

	public enum Fields {
		blacklistString, orderBlacklistTypeId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public OrderBlacklist(GenericValue value) {
		blacklistString = (String) value.get(Fields.blacklistString.name());
		orderBlacklistTypeId = (String) value.get(Fields.orderBlacklistTypeId
				.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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