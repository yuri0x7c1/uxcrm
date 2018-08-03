package org.apache.ofbiz.order.order;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Adjustment Attribute
 */
public class OrderAdjustmentAttribute implements Serializable {

	public static final long serialVersionUID = 7101349394366382080L;
	public static final String NAME = "OrderAdjustmentAttribute";
	/**
	 * Order Adjustment Id
	 */
	@Getter
	@Setter
	private String orderAdjustmentId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
	/**
	 * Attr Value
	 */
	@Getter
	@Setter
	private String attrValue;
	/**
	 * Attr Description
	 */
	@Getter
	@Setter
	private String attrDescription;
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
		orderAdjustmentId, attrName, attrValue, attrDescription, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public OrderAdjustmentAttribute(GenericValue value) {
		orderAdjustmentId = (String) value.get(Fields.orderAdjustmentId.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
		attrDescription = (String) value.get(Fields.attrDescription.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static OrderAdjustmentAttribute fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderAdjustmentAttribute(value);
	}

	public static List<OrderAdjustmentAttribute> fromValues(
			List<GenericValue> values) {
		List<OrderAdjustmentAttribute> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderAdjustmentAttribute(value));
		}
		return entities;
	}
}