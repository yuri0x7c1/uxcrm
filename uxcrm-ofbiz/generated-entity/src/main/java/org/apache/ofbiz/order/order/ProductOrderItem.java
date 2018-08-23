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
 * Product Order Item
 */
@FieldNameConstants
public class ProductOrderItem implements Serializable {

	public static final long serialVersionUID = 8787507801127208960L;
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

	public ProductOrderItem(GenericValue value) {
		orderId = (String) value.get(FIELD_ORDER_ID);
		orderItemSeqId = (String) value.get(FIELD_ORDER_ITEM_SEQ_ID);
		engagementId = (String) value.get(FIELD_ENGAGEMENT_ID);
		engagementItemSeqId = (String) value.get(FIELD_ENGAGEMENT_ITEM_SEQ_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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