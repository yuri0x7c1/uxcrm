package org.apache.ofbiz.humanres.trainings.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Training Request
 */
public class TrainingRequest implements Serializable {

	public static final long serialVersionUID = 2674942384062231552L;
	public static final String NAME = "TrainingRequest";
	/**
	 * Training Request Id
	 */
	@Getter
	@Setter
	private String trainingRequestId;

	public enum Fields {
		trainingRequestId
	}

	public TrainingRequest(GenericValue value) {
		trainingRequestId = (String) value.get(Fields.trainingRequestId.name());
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