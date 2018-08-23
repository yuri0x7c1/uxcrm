package org.apache.ofbiz.common.status;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Status Valid Change
 */
@FieldNameConstants
public class StatusValidChange implements Serializable {

	public static final long serialVersionUID = 7195782579866948608L;
	public static final String NAME = "StatusValidChange";
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Status Id To
	 */
	@Getter
	@Setter
	private String statusIdTo;
	/**
	 * Condition Expression
	 */
	@Getter
	@Setter
	private String conditionExpression;
	/**
	 * Transition Name
	 */
	@Getter
	@Setter
	private String transitionName;
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

	public StatusValidChange(GenericValue value) {
		statusId = (String) value.get(FIELD_STATUS_ID);
		statusIdTo = (String) value.get(FIELD_STATUS_ID_TO);
		conditionExpression = (String) value.get(FIELD_CONDITION_EXPRESSION);
		transitionName = (String) value.get(FIELD_TRANSITION_NAME);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static StatusValidChange fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new StatusValidChange(value);
	}

	public static List<StatusValidChange> fromValues(List<GenericValue> values) {
		List<StatusValidChange> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new StatusValidChange(value));
		}
		return entities;
	}
}