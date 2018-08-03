package org.apache.ofbiz.order.order;

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
public class OrderBlacklistType implements Serializable {

	public static final long serialVersionUID = 3360904212409654272L;
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

	public enum Fields {
		orderBlacklistTypeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public OrderBlacklistType(GenericValue value) {
		orderBlacklistTypeId = (String) value.get(Fields.orderBlacklistTypeId
				.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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