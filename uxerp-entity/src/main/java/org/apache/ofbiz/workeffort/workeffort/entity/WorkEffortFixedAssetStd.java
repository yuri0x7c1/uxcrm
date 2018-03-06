package org.apache.ofbiz.workeffort.workeffort.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort Fixed Asset Std
 */
public class WorkEffortFixedAssetStd implements Serializable {

	public static final long serialVersionUID = 2160778129454023680L;
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

	public enum Fields {
		workEffortId, fixedAssetTypeId, estimatedQuantity, estimatedDuration, estimatedCost
	}

	public WorkEffortFixedAssetStd(GenericValue value) {
		workEffortId = (String) value.get(Fields.workEffortId.name());
		fixedAssetTypeId = (String) value.get(Fields.fixedAssetTypeId.name());
		estimatedQuantity = (Double) value.get(Fields.estimatedQuantity.name());
		estimatedDuration = (Double) value.get(Fields.estimatedDuration.name());
		estimatedCost = (BigDecimal) value.get(Fields.estimatedCost.name());
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