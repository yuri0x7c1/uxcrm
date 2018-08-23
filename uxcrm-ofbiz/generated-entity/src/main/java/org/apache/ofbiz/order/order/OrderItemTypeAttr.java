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
 * Order Item Type Attr
 */
@FieldNameConstants
public class OrderItemTypeAttr implements Serializable {

	public static final long serialVersionUID = 8040539945155793920L;
	public static final String NAME = "OrderItemTypeAttr";
	/**
	 * Order Item Type Id
	 */
	@Getter
	@Setter
	private String orderItemTypeId;
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

	public OrderItemTypeAttr(GenericValue value) {
		orderItemTypeId = (String) value.get(FIELD_ORDER_ITEM_TYPE_ID);
		attrName = (String) value.get(FIELD_ATTR_NAME);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static OrderItemTypeAttr fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderItemTypeAttr(value);
	}

	public static List<OrderItemTypeAttr> fromValues(List<GenericValue> values) {
		List<OrderItemTypeAttr> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderItemTypeAttr(value));
		}
		return entities;
	}
}