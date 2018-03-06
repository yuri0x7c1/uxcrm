package org.apache.ofbiz.order.order.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Order Content
 */
public class OrderContent implements Serializable {

	public static final long serialVersionUID = 706740639306005504L;
	public static final String NAME = "OrderContent";
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
	 * Content Id
	 */
	@Getter
	@Setter
	private String contentId;
	/**
	 * Order Content Type Id
	 */
	@Getter
	@Setter
	private String orderContentTypeId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;

	public enum Fields {
		orderId, orderItemSeqId, contentId, orderContentTypeId, fromDate, thruDate
	}

	public OrderContent(GenericValue value) {
		orderId = (String) value.get(Fields.orderId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		contentId = (String) value.get(Fields.contentId.name());
		orderContentTypeId = (String) value.get(Fields.orderContentTypeId
				.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
	}

	public static OrderContent fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderContent(value);
	}

	public static List<OrderContent> fromValues(List<GenericValue> values) {
		List<OrderContent> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderContent(value));
		}
		return entities;
	}
}