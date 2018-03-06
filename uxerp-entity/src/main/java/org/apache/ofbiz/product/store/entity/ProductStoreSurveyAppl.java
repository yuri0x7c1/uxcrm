package org.apache.ofbiz.product.store.entity;

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
public class ProductStoreSurveyAppl implements Serializable {

	public static final long serialVersionUID = 6290870301928119296L;
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

	public enum Fields {
		productStoreSurveyId, productStoreId, surveyApplTypeId, groupName, surveyId, productId, productCategoryId, fromDate, thruDate, surveyTemplate, resultTemplate, sequenceNum
	}

	public ProductStoreSurveyAppl(GenericValue value) {
		productStoreSurveyId = (String) value.get(Fields.productStoreSurveyId
				.name());
		productStoreId = (String) value.get(Fields.productStoreId.name());
		surveyApplTypeId = (String) value.get(Fields.surveyApplTypeId.name());
		groupName = (String) value.get(Fields.groupName.name());
		surveyId = (String) value.get(Fields.surveyId.name());
		productId = (String) value.get(Fields.productId.name());
		productCategoryId = (String) value.get(Fields.productCategoryId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		surveyTemplate = (String) value.get(Fields.surveyTemplate.name());
		resultTemplate = (String) value.get(Fields.resultTemplate.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
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