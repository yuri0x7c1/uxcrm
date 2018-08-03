package org.apache.ofbiz.humanres.trainings;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Training Request
 */
public class TrainingRequest implements Serializable {

	public static final long serialVersionUID = 1318605029240870912L;
	public static final String NAME = "TrainingRequest";
	/**
	 * Training Request Id
	 */
	@Getter
	@Setter
	private String trainingRequestId;
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
		trainingRequestId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public TrainingRequest(GenericValue value) {
		trainingRequestId = (String) value.get(Fields.trainingRequestId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static TrainingRequest fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TrainingRequest(value);
	}

	public static List<TrainingRequest> fromValues(List<GenericValue> values) {
		List<TrainingRequest> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TrainingRequest(value));
		}
		return entities;
	}
}