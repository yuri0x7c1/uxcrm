package org.apache.ofbiz.humanres.recruitment;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class JobInterviewType implements Serializable {

	public static final long serialVersionUID = 217806813727253504L;
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

	public JobInterviewType(GenericValue value) {
		jobInterviewTypeId = (String) value.get(FIELD_JOB_INTERVIEW_TYPE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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