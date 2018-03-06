package org.apache.ofbiz.accounting.fixedasset.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Fixed Asset Maint Meter
 */
public class FixedAssetMaintMeter implements Serializable {

	public static final long serialVersionUID = 8493698598648576000L;
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

	public enum Fields {
		fixedAssetId, maintHistSeqId, productMeterTypeId, meterValue
	}

	public FixedAssetMaintMeter(GenericValue value) {
		fixedAssetId = (String) value.get(Fields.fixedAssetId.name());
		maintHistSeqId = (String) value.get(Fields.maintHistSeqId.name());
		productMeterTypeId = (String) value.get(Fields.productMeterTypeId
				.name());
		meterValue = (BigDecimal) value.get(Fields.meterValue.name());
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