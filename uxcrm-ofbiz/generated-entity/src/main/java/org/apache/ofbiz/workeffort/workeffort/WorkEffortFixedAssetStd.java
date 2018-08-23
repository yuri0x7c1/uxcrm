package org.apache.ofbiz.workeffort.workeffort;

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
 * Work Effort Fixed Asset Std
 */
@FieldNameConstants
public class WorkEffortFixedAssetStd implements Serializable {

	public static final long serialVersionUID = 731946944704880640L;
	public static final String NAME = "WorkEffortFixedAssetStd";
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Fixed Asset Type Id
	 */
	@Getter
	@Setter
	private String fixedAssetTypeId;
	/**
	 * Estimated Quantity
	 */
	@Getter
	@Setter
	private Double estimatedQuantity;
	/**
	 * Estimated Duration
	 */
	@Getter
	@Setter
	private Double estimatedDuration;
	/**
	 * Estimated Cost
	 */
	@Getter
	@Setter
	private BigDecimal estimatedCost;
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

	public WorkEffortFixedAssetStd(GenericValue value) {
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		fixedAssetTypeId = (String) value.get(FIELD_FIXED_ASSET_TYPE_ID);
		estimatedQuantity = (Double) value.get(FIELD_ESTIMATED_QUANTITY);
		estimatedDuration = (Double) value.get(FIELD_ESTIMATED_DURATION);
		estimatedCost = (BigDecimal) value.get(FIELD_ESTIMATED_COST);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static WorkEffortFixedAssetStd fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortFixedAssetStd(value);
	}

	public static List<WorkEffortFixedAssetStd> fromValues(
			List<GenericValue> values) {
		List<WorkEffortFixedAssetStd> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortFixedAssetStd(value));
		}
		return entities;
	}
}