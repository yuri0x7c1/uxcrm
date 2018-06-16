package org.apache.ofbiz.accounting.fixedasset;

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
public class FixedAssetMeter implements Serializable {

	public static final long serialVersionUID = 3282433878434989056L;
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

	public enum Fields {
		fixedAssetId, productMeterTypeId, readingDate, meterValue, readingReasonEnumId, maintHistSeqId, workEffortId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public FixedAssetMeter(GenericValue value) {
		fixedAssetId = (String) value.get(Fields.fixedAssetId.name());
		productMeterTypeId = (String) value.get(Fields.productMeterTypeId
				.name());
		readingDate = (Timestamp) value.get(Fields.readingDate.name());
		meterValue = (BigDecimal) value.get(Fields.meterValue.name());
		readingReasonEnumId = (String) value.get(Fields.readingReasonEnumId
				.name());
		maintHistSeqId = (String) value.get(Fields.maintHistSeqId.name());
		workEffortId = (String) value.get(Fields.workEffortId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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