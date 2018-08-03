package org.apache.ofbiz.order.order;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Adjustment Type
 */
public class OrderAdjustmentType implements Serializable {

	public static final long serialVersionUID = 79924694508606464L;
	public static final String NAME = "OrderAdjustmentType";
	/**
	 * Order Adjustment Type Id
	 */
	@Getter
	@Setter
	private String orderAdjustmentTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Has Table
	 */
	@Getter
	@Setter
	private String hasTable;
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
		orderAdjustmentTypeId, parentTypeId, hasTable, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public OrderAdjustmentType(GenericValue value) {
		orderAdjustmentTypeId = (String) value.get(Fields.orderAdjustmentTypeId
				.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static OrderAdjustmentType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderAdjustmentType(value);
	}

	public static List<OrderAdjustmentType> fromValues(List<GenericValue> values) {
		List<OrderAdjustmentType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderAdjustmentType(value));
		}
		return entities;
	}
}