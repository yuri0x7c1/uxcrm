package org.apache.ofbiz.humanres.employment;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Termination Reason
 */
@FieldNameConstants
public class TerminationReason implements Serializable {

	public static final long serialVersionUID = 1445530110555544576L;
	public static final String NAME = "TerminationReason";
	/**
	 * Termination Reason Id
	 */
	@Getter
	@Setter
	private String terminationReasonId;
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

	public TerminationReason(GenericValue value) {
		terminationReasonId = (String) value.get(FIELD_TERMINATION_REASON_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static TerminationReason fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TerminationReason(value);
	}

	public static List<TerminationReason> fromValues(List<GenericValue> values) {
		List<TerminationReason> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TerminationReason(value));
		}
		return entities;
	}
}