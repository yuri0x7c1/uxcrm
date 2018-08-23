package org.apache.ofbiz.content.survey;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class SurveyMultiRespColumn implements Serializable {

	public static final long serialVersionUID = 8030366293001644032L;
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

	public SurveyMultiRespColumn(GenericValue value) {
		surveyId = (String) value.get(FIELD_SURVEY_ID);
		surveyMultiRespId = (String) value.get(FIELD_SURVEY_MULTI_RESP_ID);
		surveyMultiRespColId = (String) value
				.get(FIELD_SURVEY_MULTI_RESP_COL_ID);
		columnTitle = (String) value.get(FIELD_COLUMN_TITLE);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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