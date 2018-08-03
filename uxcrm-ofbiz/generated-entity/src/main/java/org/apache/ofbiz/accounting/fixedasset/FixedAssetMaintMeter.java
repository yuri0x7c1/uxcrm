package org.apache.ofbiz.accounting.fixedasset;

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
public class FixedAssetMaintMeter implements Serializable {

	public static final long serialVersionUID = 5303387653969344512L;
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

	public enum Fields {
		fixedAssetId, maintHistSeqId, productMeterTypeId, meterValue, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public FixedAssetMaintMeter(GenericValue value) {
		fixedAssetId = (String) value.get(Fields.fixedAssetId.name());
		maintHistSeqId = (String) value.get(Fields.maintHistSeqId.name());
		productMeterTypeId = (String) value.get(Fields.productMeterTypeId
				.name());
		meterValue = (BigDecimal) value.get(Fields.meterValue.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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