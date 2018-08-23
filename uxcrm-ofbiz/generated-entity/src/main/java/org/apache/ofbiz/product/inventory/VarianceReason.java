package org.apache.ofbiz.product.inventory;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class VarianceReason implements Serializable {

	public static final long serialVersionUID = 6680487530470748160L;
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

	public VarianceReason(GenericValue value) {
		varianceReasonId = (String) value.get(FIELD_VARIANCE_REASON_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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