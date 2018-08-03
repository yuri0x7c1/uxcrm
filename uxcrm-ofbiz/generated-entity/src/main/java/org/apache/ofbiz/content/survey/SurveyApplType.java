package org.apache.ofbiz.content.survey;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Survey Appl Type
 */
public class SurveyApplType implements Serializable {

	public static final long serialVersionUID = 5764525667425206272L;
	public static final String NAME = "SurveyApplType";
	/**
	 * Survey Appl Type Id
	 */
	@Getter
	@Setter
	private String surveyApplTypeId;
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
		surveyApplTypeId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public SurveyApplType(GenericValue value) {
		surveyApplTypeId = (String) value.get(Fields.surveyApplTypeId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static SurveyApplType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SurveyApplType(value);
	}

	public static List<SurveyApplType> fromValues(List<GenericValue> values) {
		List<SurveyApplType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SurveyApplType(value));
		}
		return entities;
	}
}