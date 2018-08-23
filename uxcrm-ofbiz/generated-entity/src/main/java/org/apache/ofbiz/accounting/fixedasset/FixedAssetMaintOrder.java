package org.apache.ofbiz.accounting.fixedasset;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class FixedAssetMaintOrder implements Serializable {

	public static final long serialVersionUID = 3813804741856385024L;
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

	public FixedAssetMaintOrder(GenericValue value) {
		fixedAssetId = (String) value.get(FIELD_FIXED_ASSET_ID);
		maintHistSeqId = (String) value.get(FIELD_MAINT_HIST_SEQ_ID);
		orderId = (String) value.get(FIELD_ORDER_ID);
		orderItemSeqId = (String) value.get(FIELD_ORDER_ITEM_SEQ_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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