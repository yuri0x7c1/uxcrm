package org.apache.ofbiz.accounting.fixedasset.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Fixed Asset Maint
 */
public class FixedAssetMaint implements Serializable {

	public static final long serialVersionUID = 6352991994428051456L;
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

	public enum Fields {
		fixedAssetId, maintHistSeqId, statusId, productMaintTypeId, productMaintSeqId, scheduleWorkEffortId, intervalQuantity, intervalUomId, intervalMeterTypeId, purchaseOrderId
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