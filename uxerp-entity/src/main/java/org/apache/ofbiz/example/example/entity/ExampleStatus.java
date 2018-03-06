package org.apache.ofbiz.example.example.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Example Status
 */
public class ExampleStatus implements Serializable {

	public static final long serialVersionUID = 6569354659000368128L;
	public static final String NAME = "ExampleStatus";
	/**
	 * Example Id
	 */
	@Getter
	@Setter
	private String exampleId;
	/**
	 * Status Date
	 */
	@Getter
	@Setter
	private Timestamp statusDate;
	/**
	 * Status End Date
	 */
	@Getter
	@Setter
	private Timestamp statusEndDate;
	/**
	 * Change By User Login Id
	 */
	@Getter
	@Setter
	private String changeByUserLoginId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;

	public enum Fields {
		exampleId, statusDate, statusEndDate, changeByUserLoginId, statusId
	}

	public ExampleStatus(GenericValue value) {
		exampleId = (String) value.get(Fields.exampleId.name());
		statusDate = (Timestamp) value.get(Fields.statusDate.name());
		statusEndDate = (Timestamp) value.get(Fields.statusEndDate.name());
		changeByUserLoginId = (String) value.get(Fields.changeByUserLoginId
				.name());
		statusId = (String) value.get(Fields.statusId.name());
	}

	public static ExampleStatus fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ExampleStatus(value);
	}

	public static List<ExampleStatus> fromValues(List<GenericValue> values) {
		List<ExampleStatus> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ExampleStatus(value));
		}
		return entities;
	}
}