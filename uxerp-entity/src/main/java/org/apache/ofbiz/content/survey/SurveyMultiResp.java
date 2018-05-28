package org.apache.ofbiz.content.survey;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Survey Multi Resp
 */
public class SurveyMultiResp implements Serializable {

	public static final long serialVersionUID = 5430464728065295360L;
	public static final String NAME = "SurveyMultiResp";
	/**
	 * Survey Id
	 */
	@Getter
	@Setter
	private String surveyId;
	/**
	 * Survey Multi Resp Id
	 */
	@Getter
	@Setter
	private String surveyMultiRespId;
	/**
	 * Multi Resp Title
	 */
	@Getter
	@Setter
	private String multiRespTitle;
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
		surveyId, surveyMultiRespId, multiRespTitle, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public SurveyMultiResp(GenericValue value) {
		surveyId = (String) value.get(Fields.surveyId.name());
		surveyMultiRespId = (String) value.get(Fields.surveyMultiRespId.name());
		multiRespTitle = (String) value.get(Fields.multiRespTitle.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static SurveyMultiResp fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SurveyMultiResp(value);
	}

	public static List<SurveyMultiResp> fromValues(List<GenericValue> values) {
		List<SurveyMultiResp> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SurveyMultiResp(value));
		}
		return entities;
	}
}