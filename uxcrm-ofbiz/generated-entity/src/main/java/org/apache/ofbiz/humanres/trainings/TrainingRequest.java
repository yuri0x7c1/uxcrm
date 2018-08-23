package org.apache.ofbiz.humanres.trainings;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class TrainingRequest implements Serializable {

	public static final long serialVersionUID = 5262258661289445376L;
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

	public TrainingRequest(GenericValue value) {
		trainingRequestId = (String) value.get(FIELD_TRAINING_REQUEST_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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