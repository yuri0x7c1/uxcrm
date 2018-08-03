package org.apache.ofbiz.content.survey;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Survey Multi Resp Column
 */
public class SurveyMultiRespColumn implements Serializable {

	public static final long serialVersionUID = 682524800480655360L;
	public static final String NAME = "SurveyMultiRespColumn";
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
	 * Survey Multi Resp Col Id
	 */
	@Getter
	@Setter
	private String surveyMultiRespColId;
	/**
	 * Column Title
	 */
	@Getter
	@Setter
	private String columnTitle;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
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
		surveyId, surveyMultiRespId, surveyMultiRespColId, columnTitle, sequenceNum, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public SurveyMultiRespColumn(GenericValue value) {
		surveyId = (String) value.get(Fields.surveyId.name());
		surveyMultiRespId = (String) value.get(Fields.surveyMultiRespId.name());
		surveyMultiRespColId = (String) value.get(Fields.surveyMultiRespColId
				.name());
		columnTitle = (String) value.get(Fields.columnTitle.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static SurveyMultiRespColumn fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SurveyMultiRespColumn(value);
	}

	public static List<SurveyMultiRespColumn> fromValues(
			List<GenericValue> values) {
		List<SurveyMultiRespColumn> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SurveyMultiRespColumn(value));
		}
		return entities;
	}
}