package org.apache.ofbiz.content.survey;

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
public class SurveyPage implements Serializable {

	public static final long serialVersionUID = 7988442920701221888L;
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

	public enum Fields {
		surveyId, surveyPageSeqId, pageName, sequenceNum, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public SurveyPage(GenericValue value) {
		surveyId = (String) value.get(Fields.surveyId.name());
		surveyPageSeqId = (String) value.get(Fields.surveyPageSeqId.name());
		pageName = (String) value.get(Fields.pageName.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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