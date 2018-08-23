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
 * Fixed Asset Maint Meter
 */
@FieldNameConstants
public class FixedAssetMaintMeter implements Serializable {

	public static final long serialVersionUID = 8783962644709225472L;
	public static final String NAME = "FixedAssetMaintMeter";
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
	 * Product Meter Type Id
	 */
	@Getter
	@Setter
	private String productMeterTypeId;
	/**
	 * Meter Value
	 */
	@Getter
	@Setter
	private BigDecimal meterValue;
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

	public FixedAssetMaintMeter(GenericValue value) {
		fixedAssetId = (String) value.get(FIELD_FIXED_ASSET_ID);
		maintHistSeqId = (String) value.get(FIELD_MAINT_HIST_SEQ_ID);
		productMeterTypeId = (String) value.get(FIELD_PRODUCT_METER_TYPE_ID);
		meterValue = (BigDecimal) value.get(FIELD_METER_VALUE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static FixedAssetMaintMeter fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FixedAssetMaintMeter(value);
	}

	public static List<FixedAssetMaintMeter> fromValues(
			List<GenericValue> values) {
		List<FixedAssetMaintMeter> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FixedAssetMaintMeter(value));
		}
		return entities;
	}
}