package org.apache.ofbiz.accounting.fixedasset.entity;

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

	public static final long serialVersionUID = 4820373372463781888L;
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

	public enum Fields {
		fixedAssetId, productMeterTypeId, readingDate, meterValue, readingReasonEnumId, maintHistSeqId, workEffortId
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