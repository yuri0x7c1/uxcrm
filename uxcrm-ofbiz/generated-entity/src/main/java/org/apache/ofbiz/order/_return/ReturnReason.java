package org.apache.ofbiz.order._return;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Return Reason
 */
@FieldNameConstants
public class ReturnReason implements Serializable {

	public static final long serialVersionUID = 4409784545932787712L;
	public static final String NAME = "ReturnReason";
	/**
	 * Return Reason Id
	 */
	@Getter
	@Setter
	private String returnReasonId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Sequence Id
	 */
	@Getter
	@Setter
	private String sequenceId;
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

	public ReturnReason(GenericValue value) {
		returnReasonId = (String) value.get(FIELD_RETURN_REASON_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		sequenceId = (String) value.get(FIELD_SEQUENCE_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ReturnReason fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ReturnReason(value);
	}

	public static List<ReturnReason> fromValues(List<GenericValue> values) {
		List<ReturnReason> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ReturnReason(value));
		}
		return entities;
	}
}