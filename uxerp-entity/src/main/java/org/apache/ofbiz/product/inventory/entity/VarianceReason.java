package org.apache.ofbiz.product.inventory.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Variance Reason
 */
public class VarianceReason implements Serializable {

	public static final long serialVersionUID = 7655940452636041216L;
	public static final String NAME = "VarianceReason";
	/**
	 * Variance Reason Id
	 */
	@Getter
	@Setter
	private String varianceReasonId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		varianceReasonId, description
	}

	public VarianceReason(GenericValue value) {
		varianceReasonId = (String) value.get(Fields.varianceReasonId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static VarianceReason fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new VarianceReason(value);
	}

	public static List<VarianceReason> fromValues(List<GenericValue> values) {
		List<VarianceReason> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new VarianceReason(value));
		}
		return entities;
	}
}