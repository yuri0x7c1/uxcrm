package org.apache.ofbiz.product.inventory;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Variance Reason
 */
public class VarianceReason implements Serializable {

	public static final long serialVersionUID = 8032181964733773824L;
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
		varianceReasonId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public VarianceReason(GenericValue value) {
		varianceReasonId = (String) value.get(Fields.varianceReasonId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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