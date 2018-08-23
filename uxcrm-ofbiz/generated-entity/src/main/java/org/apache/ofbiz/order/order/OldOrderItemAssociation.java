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
 * Old Order Item Association
 */
@FieldNameConstants
public class OldOrderItemAssociation implements Serializable {

	public static final long serialVersionUID = 5017652739324285952L;
	public static final String NAME = "OldOrderItemAssociation";
	/**
	 * Sales Order Id
	 */
	@Getter
	@Setter
	private String salesOrderId;
	/**
	 * So Item Seq Id
	 */
	@Getter
	@Setter
	private String soItemSeqId;
	/**
	 * Purchase Order Id
	 */
	@Getter
	@Setter
	private String purchaseOrderId;
	/**
	 * Po Item Seq Id
	 */
	@Getter
	@Setter
	private String poItemSeqId;
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

	public OldOrderItemAssociation(GenericValue value) {
		salesOrderId = (String) value.get(FIELD_SALES_ORDER_ID);
		soItemSeqId = (String) value.get(FIELD_SO_ITEM_SEQ_ID);
		purchaseOrderId = (String) value.get(FIELD_PURCHASE_ORDER_ID);
		poItemSeqId = (String) value.get(FIELD_PO_ITEM_SEQ_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static OldOrderItemAssociation fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new OldOrderItemAssociation(value);
	}

	public static List<OldOrderItemAssociation> fromValues(
			List<GenericValue> values) {
		List<OldOrderItemAssociation> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new OldOrderItemAssociation(value));
		}
		return entities;
	}
}