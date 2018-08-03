package org.apache.ofbiz.order.order;

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
public class OldOrderItemAssociation implements Serializable {

	public static final long serialVersionUID = 6182496298570890240L;
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

	public enum Fields {
		salesOrderId, soItemSeqId, purchaseOrderId, poItemSeqId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public OldOrderItemAssociation(GenericValue value) {
		salesOrderId = (String) value.get(Fields.salesOrderId.name());
		soItemSeqId = (String) value.get(Fields.soItemSeqId.name());
		purchaseOrderId = (String) value.get(Fields.purchaseOrderId.name());
		poItemSeqId = (String) value.get(Fields.poItemSeqId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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