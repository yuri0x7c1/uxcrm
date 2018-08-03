package org.apache.ofbiz.humanres.recruitment;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Job Interview Type
 */
public class JobInterviewType implements Serializable {

	public static final long serialVersionUID = 5361318476366583808L;
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
		jobInterviewTypeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public JobInterviewType(GenericValue value) {
		jobInterviewTypeId = (String) value.get(Fields.jobInterviewTypeId
				.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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