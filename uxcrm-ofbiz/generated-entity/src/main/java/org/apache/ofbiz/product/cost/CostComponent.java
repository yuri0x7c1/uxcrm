package org.apache.ofbiz.product.cost;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Cost Component
 */
public class CostComponent implements Serializable {

	public static final long serialVersionUID = 1804253971874238464L;
	public static final String NAME = "CostComponent";
	/**
	 * Cost Component Id
	 */
	@Getter
	@Setter
	private String costComponentId;
	/**
	 * Cost Component Type Id
	 */
	@Getter
	@Setter
	private String costComponentTypeId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Product Feature Id
	 */
	@Getter
	@Setter
	private String productFeatureId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Geo Id
	 */
	@Getter
	@Setter
	private String geoId;
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Fixed Asset Id
	 */
	@Getter
	@Setter
	private String fixedAssetId;
	/**
	 * Cost Component Calc Id
	 */
	@Getter
	@Setter
	private String costComponentCalcId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Cost
	 */
	@Getter
	@Setter
	private BigDecimal cost;
	/**
	 * Cost Uom Id
	 */
	@Getter
	@Setter
	private String costUomId;
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
		costComponentId, costComponentTypeId, productId, productFeatureId, partyId, geoId, workEffortId, fixedAssetId, costComponentCalcId, fromDate, thruDate, cost, costUomId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public CostComponent(GenericValue value) {
		costComponentId = (String) value.get(Fields.costComponentId.name());
		costComponentTypeId = (String) value.get(Fields.costComponentTypeId
				.name());
		productId = (String) value.get(Fields.productId.name());
		productFeatureId = (String) value.get(Fields.productFeatureId.name());
		partyId = (String) value.get(Fields.partyId.name());
		geoId = (String) value.get(Fields.geoId.name());
		workEffortId = (String) value.get(Fields.workEffortId.name());
		fixedAssetId = (String) value.get(Fields.fixedAssetId.name());
		costComponentCalcId = (String) value.get(Fields.costComponentCalcId
				.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		cost = (BigDecimal) value.get(Fields.cost.name());
		costUomId = (String) value.get(Fields.costUomId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static CostComponent fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new CostComponent(value);
	}

	public static List<CostComponent> fromValues(List<GenericValue> values) {
		List<CostComponent> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new CostComponent(value));
		}
		return entities;
	}
}