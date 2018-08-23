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
 * Survey
 */
@FieldNameConstants
public class Survey implements Serializable {

	public static final long serialVersionUID = 6888483263111522304L;
	public static final String NAME = "Survey";
	/**
	 * Survey Id
	 */
	@Getter
	@Setter
	private String surveyId;
	/**
	 * Survey Name
	 */
	@Getter
	@Setter
	private String surveyName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Submit Caption
	 */
	@Getter
	@Setter
	private String submitCaption;
	/**
	 * Response Service
	 */
	@Getter
	@Setter
	private String responseService;
	/**
	 * Is Anonymous
	 */
	@Getter
	@Setter
	private String isAnonymous;
	/**
	 * Allow Multiple
	 */
	@Getter
	@Setter
	private String allowMultiple;
	/**
	 * Allow Update
	 */
	@Getter
	@Setter
	private String allowUpdate;
	/**
	 * Acro Form Content Id
	 */
	@Getter
	@Setter
	private String acroFormContentId;
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

	public Survey(GenericValue value) {
		surveyId = (String) value.get(FIELD_SURVEY_ID);
		surveyName = (String) value.get(FIELD_SURVEY_NAME);
		description = (String) value.get(FIELD_DESCRIPTION);
		comments = (String) value.get(FIELD_COMMENTS);
		submitCaption = (String) value.get(FIELD_SUBMIT_CAPTION);
		responseService = (String) value.get(FIELD_RESPONSE_SERVICE);
		isAnonymous = (String) value.get(FIELD_IS_ANONYMOUS);
		allowMultiple = (String) value.get(FIELD_ALLOW_MULTIPLE);
		allowUpdate = (String) value.get(FIELD_ALLOW_UPDATE);
		acroFormContentId = (String) value.get(FIELD_ACRO_FORM_CONTENT_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static Survey fromValue(org.apache.ofbiz.entity.GenericValue value) {
		return new Survey(value);
	}

	public static List<Survey> fromValues(List<GenericValue> values) {
		List<Survey> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new Survey(value));
		}
		return entities;
	}
}