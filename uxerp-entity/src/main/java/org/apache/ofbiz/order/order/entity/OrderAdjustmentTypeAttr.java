package org.apache.ofbiz.order.order.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Adjustment Type Attr
 */
public class OrderAdjustmentTypeAttr implements Serializable {

	public static final long serialVersionUID = 2977365779043606528L;
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

	public enum Fields {
		orderAdjustmentTypeId, attrName, description
	}

	public OrderAdjustmentTypeAttr(GenericValue value) {
		orderAdjustmentTypeId = (String) value.get(Fields.orderAdjustmentTypeId
				.name());
		attrName = (String) value.get(Fields.attrName.name());
		description = (String) value.get(Fields.description.name());
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