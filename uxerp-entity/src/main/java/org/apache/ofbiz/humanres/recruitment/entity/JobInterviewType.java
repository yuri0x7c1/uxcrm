package org.apache.ofbiz.humanres.recruitment.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Job Interview Type
 */
public class JobInterviewType implements Serializable {

	public static final long serialVersionUID = 828503118063750144L;
	public static final String NAME = "JobInterviewType";
	/**
	 * Job Interview Type Id
	 */
	@Getter
	@Setter
	private String jobInterviewTypeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		jobInterviewTypeId, description
	}

	public JobInterviewType(GenericValue value) {
		jobInterviewTypeId = (String) value.get(Fields.jobInterviewTypeId
				.name());
		description = (String) value.get(Fields.description.name());
	}

	public static JobInterviewType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new JobInterviewType(value);
	}

	public static List<JobInterviewType> fromValues(List<GenericValue> values) {
		List<JobInterviewType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new JobInterviewType(value));
		}
		return entities;
	}
}