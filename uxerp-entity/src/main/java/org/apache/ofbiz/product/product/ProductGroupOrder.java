package org.apache.ofbiz.product.product;

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
public class ProductGroupOrder implements Serializable {

	public static final long serialVersionUID = 2086673155855062016L;
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

	public enum Fields {
		groupOrderId, productId, fromDate, thruDate, statusId, reqOrderQty, soldOrderQty, jobId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductGroupOrder(GenericValue value) {
		groupOrderId = (String) value.get(Fields.groupOrderId.name());
		productId = (String) value.get(Fields.productId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		statusId = (String) value.get(Fields.statusId.name());
		reqOrderQty = (BigDecimal) value.get(Fields.reqOrderQty.name());
		soldOrderQty = (BigDecimal) value.get(Fields.soldOrderQty.name());
		jobId = (String) value.get(Fields.jobId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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