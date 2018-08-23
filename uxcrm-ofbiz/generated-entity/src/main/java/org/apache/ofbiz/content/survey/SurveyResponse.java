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
 * Survey Response
 */
@FieldNameConstants
public class SurveyResponse implements Serializable {

	public static final long serialVersionUID = 639481938494650368L;
	public static final String NAME = "SurveyResponse";
	/**
	 * Survey Response Id
	 */
	@Getter
	@Setter
	private String surveyResponseId;
	/**
	 * Survey Id
	 */
	@Getter
	@Setter
	private String surveyId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Response Date
	 */
	@Getter
	@Setter
	private Timestamp responseDate;
	/**
	 * Last Modified Date
	 */
	@Getter
	@Setter
	private Timestamp lastModifiedDate;
	/**
	 * Reference Id
	 */
	@Getter
	@Setter
	private String referenceId;
	/**
	 * General Feedback
	 */
	@Getter
	@Setter
	private String generalFeedback;
	/**
	 * Order Id
	 */
	@Getter
	@Setter
	private String orderId;
	/**
	 * Order Item Seq Id
	 */
	@Getter
	@Setter
	private String orderItemSeqId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
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

	public SurveyResponse(GenericValue value) {
		surveyResponseId = (String) value.get(FIELD_SURVEY_RESPONSE_ID);
		surveyId = (String) value.get(FIELD_SURVEY_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		responseDate = (Timestamp) value.get(FIELD_RESPONSE_DATE);
		lastModifiedDate = (Timestamp) value.get(FIELD_LAST_MODIFIED_DATE);
		referenceId = (String) value.get(FIELD_REFERENCE_ID);
		generalFeedback = (String) value.get(FIELD_GENERAL_FEEDBACK);
		orderId = (String) value.get(FIELD_ORDER_ID);
		orderItemSeqId = (String) value.get(FIELD_ORDER_ITEM_SEQ_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static SurveyResponse fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new SurveyResponse(value);
	}

	public static List<SurveyResponse> fromValues(List<GenericValue> values) {
		List<SurveyResponse> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new SurveyResponse(value));
		}
		return entities;
	}
}