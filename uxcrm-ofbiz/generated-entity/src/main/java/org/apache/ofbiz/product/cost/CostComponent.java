package org.apache.ofbiz.product.cost;

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
 * Cost Component
 */
@FieldNameConstants
public class CostComponent implements Serializable {

	public static final long serialVersionUID = 1620024071776921600L;
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

	public CostComponent(GenericValue value) {
		costComponentId = (String) value.get(FIELD_COST_COMPONENT_ID);
		costComponentTypeId = (String) value.get(FIELD_COST_COMPONENT_TYPE_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		productFeatureId = (String) value.get(FIELD_PRODUCT_FEATURE_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		geoId = (String) value.get(FIELD_GEO_ID);
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		fixedAssetId = (String) value.get(FIELD_FIXED_ASSET_ID);
		costComponentCalcId = (String) value.get(FIELD_COST_COMPONENT_CALC_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		cost = (BigDecimal) value.get(FIELD_COST);
		costUomId = (String) value.get(FIELD_COST_UOM_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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