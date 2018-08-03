package org.apache.ofbiz.order.order;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Order Item
 */
public class ProductOrderItem implements Serializable {

	public static final long serialVersionUID = 7040185936410250240L;
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
		orderId, orderItemSeqId, engagementId, engagementItemSeqId, productId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductOrderItem(GenericValue value) {
		orderId = (String) value.get(Fields.orderId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		engagementId = (String) value.get(Fields.engagementId.name());
		engagementItemSeqId = (String) value.get(Fields.engagementItemSeqId
				.name());
		productId = (String) value.get(Fields.productId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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