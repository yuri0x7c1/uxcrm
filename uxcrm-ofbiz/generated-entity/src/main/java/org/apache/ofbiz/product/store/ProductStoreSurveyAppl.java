package org.apache.ofbiz.product.store;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Store Survey Appl
 */
@FieldNameConstants
public class ProductStoreSurveyAppl implements Serializable {

	public static final long serialVersionUID = 4198298739262655488L;
	public static final String NAME = "ProductStoreSurveyAppl";
	/**
	 * Product Store Survey Id
	 */
	@Getter
	@Setter
	private String productStoreSurveyId;
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Survey Appl Type Id
	 */
	@Getter
	@Setter
	private String surveyApplTypeId;
	/**
	 * Group Name
	 */
	@Getter
	@Setter
	private String groupName;
	/**
	 * Survey Id
	 */
	@Getter
	@Setter
	private String surveyId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Product Category Id
	 */
	@Getter
	@Setter
	private String productCategoryId;
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;
	/**
	 * Survey Template
	 */
	@Getter
	@Setter
	private String surveyTemplate;
	/**
	 * Result Template
	 */
	@Getter
	@Setter
	private String resultTemplate;
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

	public ProductStoreSurveyAppl(GenericValue value) {
		productStoreSurveyId = (String) value
				.get(FIELD_PRODUCT_STORE_SURVEY_ID);
		productStoreId = (String) value.get(FIELD_PRODUCT_STORE_ID);
		surveyApplTypeId = (String) value.get(FIELD_SURVEY_APPL_TYPE_ID);
		groupName = (String) value.get(FIELD_GROUP_NAME);
		surveyId = (String) value.get(FIELD_SURVEY_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		productCategoryId = (String) value.get(FIELD_PRODUCT_CATEGORY_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		surveyTemplate = (String) value.get(FIELD_SURVEY_TEMPLATE);
		resultTemplate = (String) value.get(FIELD_RESULT_TEMPLATE);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProductStoreSurveyAppl fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductStoreSurveyAppl(value);
	}

	public static List<ProductStoreSurveyAppl> fromValues(
			List<GenericValue> values) {
		List<ProductStoreSurveyAppl> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductStoreSurveyAppl(value));
		}
		return entities;
	}
}