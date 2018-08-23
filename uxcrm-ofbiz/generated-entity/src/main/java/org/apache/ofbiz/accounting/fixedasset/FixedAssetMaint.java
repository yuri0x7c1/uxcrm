package org.apache.ofbiz.accounting.fixedasset;

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
 * Fixed Asset Maint
 */
@FieldNameConstants
public class FixedAssetMaint implements Serializable {

	public static final long serialVersionUID = 5568329711040707584L;
	public static final String NAME = "FixedAssetMaint";
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
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Product Maint Type Id
	 */
	@Getter
	@Setter
	private String productMaintTypeId;
	/**
	 * Product Maint Seq Id
	 */
	@Getter
	@Setter
	private String productMaintSeqId;
	/**
	 * Schedule Work Effort Id
	 */
	@Getter
	@Setter
	private String scheduleWorkEffortId;
	/**
	 * Interval Quantity
	 */
	@Getter
	@Setter
	private BigDecimal intervalQuantity;
	/**
	 * Interval Uom Id
	 */
	@Getter
	@Setter
	private String intervalUomId;
	/**
	 * Interval Meter Type Id
	 */
	@Getter
	@Setter
	private String intervalMeterTypeId;
	/**
	 * Purchase Order Id
	 */
	@Getter
	@Setter
	private String purchaseOrderId;
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

	public FixedAssetMaint(GenericValue value) {
		fixedAssetId = (String) value.get(FIELD_FIXED_ASSET_ID);
		maintHistSeqId = (String) value.get(FIELD_MAINT_HIST_SEQ_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		productMaintTypeId = (String) value.get(FIELD_PRODUCT_MAINT_TYPE_ID);
		productMaintSeqId = (String) value.get(FIELD_PRODUCT_MAINT_SEQ_ID);
		scheduleWorkEffortId = (String) value
				.get(FIELD_SCHEDULE_WORK_EFFORT_ID);
		intervalQuantity = (BigDecimal) value.get(FIELD_INTERVAL_QUANTITY);
		intervalUomId = (String) value.get(FIELD_INTERVAL_UOM_ID);
		intervalMeterTypeId = (String) value.get(FIELD_INTERVAL_METER_TYPE_ID);
		purchaseOrderId = (String) value.get(FIELD_PURCHASE_ORDER_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static FixedAssetMaint fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FixedAssetMaint(value);
	}

	public static List<FixedAssetMaint> fromValues(List<GenericValue> values) {
		List<FixedAssetMaint> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FixedAssetMaint(value));
		}
		return entities;
	}
}