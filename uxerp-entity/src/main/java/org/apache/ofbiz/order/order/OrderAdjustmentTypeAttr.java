package org.apache.ofbiz.order.order;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Adjustment Type Attr
 */
public class OrderAdjustmentTypeAttr implements Serializable {

	public static final long serialVersionUID = 8644889565189313536L;
	public static final String NAME = "OrderAdjustmentTypeAttr";
	/**
	 * Order Adjustment Type Id
	 */
	@Getter
	@Setter
	private String orderAdjustmentTypeId;
	/**
	 * Attr Name
	 */
	@Getter
	@Setter
	private String attrName;
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
		orderAdjustmentTypeId, attrName, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public OrderAdjustmentTypeAttr(GenericValue value) {
		orderAdjustmentTypeId = (String) value.get(Fields.orderAdjustmentTypeId
				.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static OrderAdjustmentTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderAdjustmentTypeAttr(value);
	}

	public static List<OrderAdjustmentTypeAttr> fromValues(
			List<GenericValue> values) {
		List<OrderAdjustmentTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderAdjustmentTypeAttr(value));
		}
		return entities;
	}
}