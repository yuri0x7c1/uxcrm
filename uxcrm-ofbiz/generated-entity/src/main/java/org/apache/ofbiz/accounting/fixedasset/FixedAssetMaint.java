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
 * Fixed Asset Maint
 */
public class FixedAssetMaint implements Serializable {

	public static final long serialVersionUID = 1584550599843612672L;
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

	public enum Fields {
		fixedAssetId, maintHistSeqId, statusId, productMaintTypeId, productMaintSeqId, scheduleWorkEffortId, intervalQuantity, intervalUomId, intervalMeterTypeId, purchaseOrderId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public FixedAssetMaint(GenericValue value) {
		fixedAssetId = (String) value.get(Fields.fixedAssetId.name());
		maintHistSeqId = (String) value.get(Fields.maintHistSeqId.name());
		statusId = (String) value.get(Fields.statusId.name());
		productMaintTypeId = (String) value.get(Fields.productMaintTypeId
				.name());
		productMaintSeqId = (String) value.get(Fields.productMaintSeqId.name());
		scheduleWorkEffortId = (String) value.get(Fields.scheduleWorkEffortId
				.name());
		intervalQuantity = (BigDecimal) value.get(Fields.intervalQuantity
				.name());
		intervalUomId = (String) value.get(Fields.intervalUomId.name());
		intervalMeterTypeId = (String) value.get(Fields.intervalMeterTypeId
				.name());
		purchaseOrderId = (String) value.get(Fields.purchaseOrderId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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