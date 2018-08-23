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
 * Order Adjustment Type Attr
 */
@FieldNameConstants
public class OrderAdjustmentTypeAttr implements Serializable {

	public static final long serialVersionUID = 8273953068854846464L;
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

	public OrderAdjustmentTypeAttr(GenericValue value) {
		orderAdjustmentTypeId = (String) value
				.get(FIELD_ORDER_ADJUSTMENT_TYPE_ID);
		attrName = (String) value.get(FIELD_ATTR_NAME);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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