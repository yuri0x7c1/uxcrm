package org.apache.ofbiz.order.order.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Term Attribute
 */
public class OrderTermAttribute implements Serializable {

	public static final long serialVersionUID = 3332262484429838336L;
	public static final String NAME = "OrderTermAttribute";
	/**
	 * Term Type Id
	 */
	@Getter
	@Setter
	private String termTypeId;
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Order Item Seq Id
	 */
	@Getter
	@Setter
	private String orderItemSeqId;
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

	public enum Fields {
		termTypeId, orderId, orderItemSeqId, attrName, attrValue, attrDescription
	}

	public OrderTermAttribute(GenericValue value) {
		termTypeId = (String) value.get(Fields.termTypeId.name());
		orderId = (String) value.get(Fields.orderId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		attrName = (String) value.get(Fields.attrName.name());
		attrValue = (String) value.get(Fields.attrValue.name());
		attrDescription = (String) value.get(Fields.attrDescription.name());
	}

	public static OrderTermAttribute fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderTermAttribute(value);
	}

	public static List<OrderTermAttribute> fromValues(List<GenericValue> values) {
		List<OrderTermAttribute> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderTermAttribute(value));
		}
		return entities;
	}
}