package org.apache.ofbiz.humanres.employment;

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
public class TerminationReason implements Serializable {

	public static final long serialVersionUID = 5752753386113513472L;
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

	public enum Fields {
		terminationReasonId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public TerminationReason(GenericValue value) {
		terminationReasonId = (String) value.get(Fields.terminationReasonId
				.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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