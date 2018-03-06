package org.apache.ofbiz.order.order.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Order Item
 */
public class ProductOrderItem implements Serializable {

	public static final long serialVersionUID = 1618618356855610368L;
	public static final String NAME = "ProductOrderItem";
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
	 * Engagement Id
	 */
	@Getter
	@Setter
	private String engagementId;
	/**
	 * Engagement Item Seq Id
	 */
	@Getter
	@Setter
	private String engagementItemSeqId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;

	public enum Fields {
		orderId, orderItemSeqId, engagementId, engagementItemSeqId, productId
	}

	public ProductOrderItem(GenericValue value) {
		orderId = (String) value.get(Fields.orderId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		engagementId = (String) value.get(Fields.engagementId.name());
		engagementItemSeqId = (String) value.get(Fields.engagementItemSeqId
				.name());
		productId = (String) value.get(Fields.productId.name());
	}

	public static ProductOrderItem fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductOrderItem(value);
	}

	public static List<ProductOrderItem> fromValues(List<GenericValue> values) {
		List<ProductOrderItem> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductOrderItem(value));
		}
		return entities;
	}
}