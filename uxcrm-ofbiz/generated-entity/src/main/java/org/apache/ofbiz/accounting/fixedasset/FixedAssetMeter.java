package org.apache.ofbiz.accounting.fixedasset;

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
 * Fixed Asset Meter
 */
@FieldNameConstants
public class FixedAssetMeter implements Serializable {

	public static final long serialVersionUID = 925541887463001088L;
	public static final String NAME = "FixedAssetMeter";
	/**
	 * Fixed Asset Id
	 */
	@Getter
	@Setter
	private String fixedAssetId;
	/**
	 * Product Meter Type Id
	 */
	@Getter
	@Setter
	private String productMeterTypeId;
	/**
	 * Reading Date
	 */
	@Getter
	@Setter
	private Timestamp readingDate;
	/**
	 * Meter Value
	 */
	@Getter
	@Setter
	private BigDecimal meterValue;
	/**
	 * Reading Reason Enum Id
	 */
	@Getter
	@Setter
	private String readingReasonEnumId;
	/**
	 * Maint Hist Seq Id
	 */
	@Getter
	@Setter
	private String maintHistSeqId;
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
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

	public FixedAssetMeter(GenericValue value) {
		fixedAssetId = (String) value.get(FIELD_FIXED_ASSET_ID);
		productMeterTypeId = (String) value.get(FIELD_PRODUCT_METER_TYPE_ID);
		readingDate = (Timestamp) value.get(FIELD_READING_DATE);
		meterValue = (BigDecimal) value.get(FIELD_METER_VALUE);
		readingReasonEnumId = (String) value.get(FIELD_READING_REASON_ENUM_ID);
		maintHistSeqId = (String) value.get(FIELD_MAINT_HIST_SEQ_ID);
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static FixedAssetMeter fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new FixedAssetMeter(value);
	}

	public static List<FixedAssetMeter> fromValues(List<GenericValue> values) {
		List<FixedAssetMeter> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new FixedAssetMeter(value));
		}
		return entities;
	}
}