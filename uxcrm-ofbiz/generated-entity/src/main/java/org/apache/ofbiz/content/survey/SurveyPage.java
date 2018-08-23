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
 * Survey Page
 */
@FieldNameConstants
public class SurveyPage implements Serializable {

	public static final long serialVersionUID = 5535189495612939264L;
	public static final String NAME = "SurveyPage";
	/**
	 * Survey Id
	 */
	@Getter
	@Setter
	private String surveyId;
	/**
	 * Survey Page Seq Id
	 */
	@Getter
	@Setter
	private String surveyPageSeqId;
	/**
	 * Page Name
	 */
	@Getter
	@Setter
	private String pageName;
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

	public SurveyPage(GenericValue value) {
		surveyId = (String) value.get(FIELD_SURVEY_ID);
		surveyPageSeqId = (String) value.get(FIELD_SURVEY_PAGE_SEQ_ID);
		pageName = (String) value.get(FIELD_PAGE_NAME);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static SurveyPage fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SurveyPage(value);
	}

	public static List<SurveyPage> fromValues(List<GenericValue> values) {
		List<SurveyPage> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SurveyPage(value));
		}
		return entities;
	}
}