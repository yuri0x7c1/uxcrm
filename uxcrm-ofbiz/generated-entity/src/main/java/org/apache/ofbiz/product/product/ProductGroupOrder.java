package org.apache.ofbiz.product.product;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Group Order
 */
@FieldNameConstants
public class ProductGroupOrder implements Serializable {

	public static final long serialVersionUID = 725017632899935232L;
	public static final String NAME = "ProductGroupOrder";
	/**
	 * Group Order Id
	 */
	@Getter
	@Setter
	private String groupOrderId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
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
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Req Order Qty
	 */
	@Getter
	@Setter
	private BigDecimal reqOrderQty;
	/**
	 * Sold Order Qty
	 */
	@Getter
	@Setter
	private BigDecimal soldOrderQty;
	/**
	 * Job Id
	 */
	@Getter
	@Setter
	private String jobId;
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

	public ProductGroupOrder(GenericValue value) {
		groupOrderId = (String) value.get(FIELD_GROUP_ORDER_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		statusId = (String) value.get(FIELD_STATUS_ID);
		reqOrderQty = (BigDecimal) value.get(FIELD_REQ_ORDER_QTY);
		soldOrderQty = (BigDecimal) value.get(FIELD_SOLD_ORDER_QTY);
		jobId = (String) value.get(FIELD_JOB_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProductGroupOrder fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductGroupOrder(value);
	}

	public static List<ProductGroupOrder> fromValues(List<GenericValue> values) {
		List<ProductGroupOrder> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductGroupOrder(value));
		}
		return entities;
	}
}