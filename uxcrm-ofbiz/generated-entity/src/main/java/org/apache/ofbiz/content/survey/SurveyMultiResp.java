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
 * Survey Multi Resp
 */
@FieldNameConstants
public class SurveyMultiResp implements Serializable {

	public static final long serialVersionUID = 6235823727471236096L;
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

	public SurveyMultiResp(GenericValue value) {
		surveyId = (String) value.get(FIELD_SURVEY_ID);
		surveyMultiRespId = (String) value.get(FIELD_SURVEY_MULTI_RESP_ID);
		multiRespTitle = (String) value.get(FIELD_MULTI_RESP_TITLE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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