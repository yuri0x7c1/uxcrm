package org.apache.ofbiz.order.order;

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
 * Order Delivery Schedule
 */
@FieldNameConstants
public class OrderDeliverySchedule implements Serializable {

	public static final long serialVersionUID = 1769692704920279040L;
	public static final String NAME = "OrderDeliverySchedule";
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
	 * Estimated Ready Date
	 */
	@Getter
	@Setter
	private Timestamp estimatedReadyDate;
	/**
	 * Cartons
	 */
	@Getter
	@Setter
	private Long cartons;
	/**
	 * Skids Pallets
	 */
	@Getter
	@Setter
	private Long skidsPallets;
	/**
	 * Units Pieces
	 */
	@Getter
	@Setter
	private BigDecimal unitsPieces;
	/**
	 * Total Cubic Size
	 */
	@Getter
	@Setter
	private BigDecimal totalCubicSize;
	/**
	 * Total Cubic Uom Id
	 */
	@Getter
	@Setter
	private String totalCubicUomId;
	/**
	 * Total Weight
	 */
	@Getter
	@Setter
	private BigDecimal totalWeight;
	/**
	 * Total Weight Uom Id
	 */
	@Getter
	@Setter
	private String totalWeightUomId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
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

	public OrderDeliverySchedule(GenericValue value) {
		orderId = (String) value.get(FIELD_ORDER_ID);
		orderItemSeqId = (String) value.get(FIELD_ORDER_ITEM_SEQ_ID);
		estimatedReadyDate = (Timestamp) value.get(FIELD_ESTIMATED_READY_DATE);
		cartons = (Long) value.get(FIELD_CARTONS);
		skidsPallets = (Long) value.get(FIELD_SKIDS_PALLETS);
		unitsPieces = (BigDecimal) value.get(FIELD_UNITS_PIECES);
		totalCubicSize = (BigDecimal) value.get(FIELD_TOTAL_CUBIC_SIZE);
		totalCubicUomId = (String) value.get(FIELD_TOTAL_CUBIC_UOM_ID);
		totalWeight = (BigDecimal) value.get(FIELD_TOTAL_WEIGHT);
		totalWeightUomId = (String) value.get(FIELD_TOTAL_WEIGHT_UOM_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static OrderDeliverySchedule fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OrderDeliverySchedule(value);
	}

	public static List<OrderDeliverySchedule> fromValues(
			List<GenericValue> values) {
		List<OrderDeliverySchedule> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OrderDeliverySchedule(value));
		}
		return entities;
	}
}