package org.apache.ofbiz.content.survey;

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
public class SurveyResponse implements Serializable {

	public static final long serialVersionUID = 3128320338389103616L;
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

	public enum Fields {
		surveyResponseId, surveyId, partyId, responseDate, lastModifiedDate, referenceId, generalFeedback, orderId, orderItemSeqId, statusId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public SurveyResponse(GenericValue value) {
		surveyResponseId = (String) value.get(Fields.surveyResponseId.name());
		surveyId = (String) value.get(Fields.surveyId.name());
		partyId = (String) value.get(Fields.partyId.name());
		responseDate = (Timestamp) value.get(Fields.responseDate.name());
		lastModifiedDate = (Timestamp) value
				.get(Fields.lastModifiedDate.name());
		referenceId = (String) value.get(Fields.referenceId.name());
		generalFeedback = (String) value.get(Fields.generalFeedback.name());
		orderId = (String) value.get(Fields.orderId.name());
		orderItemSeqId = (String) value.get(Fields.orderItemSeqId.name());
		statusId = (String) value.get(Fields.statusId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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