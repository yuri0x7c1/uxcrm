package org.apache.ofbiz.accounting.fixedasset;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Fixed Asset Maint Order
 */
public class FixedAssetMaintOrder implements Serializable {

	public static final long serialVersionUID = 6107597835826563072L;
	public static final String NAME = "FixedAssetMaintOrder";
	/**
	 * Fixed Asset Id
	 */
	@Getter
	@Setter
	private String fixedAssetId;
	/**
	 * Maint Hist Seq Id
	 */
	@Getter
	@Setter
	private String maintHistSeqId;
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
		fixedAssetId, maintHistSeqId, orderId, orderItemSeqId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public FixedAssetMaintOrder(GenericValue value) {
		fixedAssetId = (String) value.get(Fields.fixedAssetId.name());
		maintHistSeqId = (String) value.get(Fields.maintHistSeqId.name());
		orderId = (String) value.get(Fields.orderId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static FixedAssetMaintOrder fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FixedAssetMaintOrder(value);
	}

	public static List<FixedAssetMaintOrder> fromValues(
			List<GenericValue> values) {
		List<FixedAssetMaintOrder> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FixedAssetMaintOrder(value));
		}
		return entities;
	}
}