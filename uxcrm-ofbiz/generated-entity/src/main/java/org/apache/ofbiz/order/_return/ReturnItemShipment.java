package org.apache.ofbiz.order._return;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Return Item Shipment
 */
@FieldNameConstants
public class ReturnItemShipment implements Serializable {

	public static final long serialVersionUID = 3721964804846171136L;
	public static final String NAME = "ReturnItemShipment";
	/**
	 * Return Id
	 */
	@Getter
	@Setter
	private String returnId;
	/**
	 * Return Item Seq Id
	 */
	@Getter
	@Setter
	private String returnItemSeqId;
	/**
	 * Shipment Id
	 */
	@Getter
	@Setter
	private String shipmentId;
	/**
	 * Shipment Item Seq Id
	 */
	@Getter
	@Setter
	private String shipmentItemSeqId;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
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

	public ReturnItemShipment(GenericValue value) {
		returnId = (String) value.get(FIELD_RETURN_ID);
		returnItemSeqId = (String) value.get(FIELD_RETURN_ITEM_SEQ_ID);
		shipmentId = (String) value.get(FIELD_SHIPMENT_ID);
		shipmentItemSeqId = (String) value.get(FIELD_SHIPMENT_ITEM_SEQ_ID);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ReturnItemShipment fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ReturnItemShipment(value);
	}

	public static List<ReturnItemShipment> fromValues(List<GenericValue> values) {
		List<ReturnItemShipment> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ReturnItemShipment(value));
		}
		return entities;
	}
}