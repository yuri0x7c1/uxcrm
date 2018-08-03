package org.apache.ofbiz.order._return;

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
public class ReturnReason implements Serializable {

	public static final long serialVersionUID = 40742502811851776L;
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

	public enum Fields {
		returnReasonId, description, sequenceId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ReturnReason(GenericValue value) {
		returnReasonId = (String) value.get(Fields.returnReasonId.name());
		description = (String) value.get(Fields.description.name());
		sequenceId = (String) value.get(Fields.sequenceId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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