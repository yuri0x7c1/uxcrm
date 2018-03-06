package org.apache.ofbiz.product.category.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Category Content And Info
 */
public class ProductCategoryContentAndInfo implements Serializable {

	public static final long serialVersionUID = 8809727914004970496L;
	public static final String NAME = "ProductCategoryContentAndInfo";
	/**
	 * Product Category Id
	 */
	@Getter
	@Setter
	private String productCategoryId;
	/**
	 * Content Id
	 */
	@Getter
	@Setter
	private String contentId;
	/**
	 * Prod Cat Content Type Id
	 */
	@Getter
	@Setter
	private String prodCatContentTypeId;
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
	 * Purchase From Date
	 */
	@Getter
	@Setter
	private Timestamp purchaseFromDate;
	/**
	 * Purchase Thru Date
	 */
	@Getter
	@Setter
	private Timestamp purchaseThruDate;
	/**
	 * Use Count Limit
	 */
	@Getter
	@Setter
	private Long useCountLimit;
	/**
	 * Use Days Limit
	 */
	@Getter
	@Setter
	private BigDecimal useDaysLimit;
	/**
	 * Content Type Id
	 */
	@Getter
	@Setter
	private String contentTypeId;
	/**
	 * Owner Content Id
	 */
	@Getter
	@Setter
	private String ownerContentId;
	/**
	 * Decorator Content Id
	 */
	@Getter
	@Setter
	private String decoratorContentId;
	/**
	 * Instance Of Content Id
	 */
	@Getter
	@Setter
	private String instanceOfContentId;
	/**
	 * Data Resource Id
	 */
	@Getter
	@Setter
	private String dataResourceId;
	/**
	 * Template Data Resource Id
	 */
	@Getter
	@Setter
	private String templateDataResourceId;
	/**
	 * Data Source Id
	 */
	@Getter
	@Setter
	private String dataSourceId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Privilege Enum Id
	 */
	@Getter
	@Setter
	private String privilegeEnumId;
	/**
	 * Service Name
	 */
	@Getter
	@Setter
	private String serviceName;
	/**
	 * Custom Method Id
	 */
	@Getter
	@Setter
	private String customMethodId;
	/**
	 * Content Name
	 */
	@Getter
	@Setter
	private String contentName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Locale String
	 */
	@Getter
	@Setter
	private String localeString;
	/**
	 * Mime Type Id
	 */
	@Getter
	@Setter
	private String mimeTypeId;
	/**
	 * Character Set Id
	 */
	@Getter
	@Setter
	private String characterSetId;
	/**
	 * Child Leaf Count
	 */
	@Getter
	@Setter
	private Long childLeafCount;
	/**
	 * Child Branch Count
	 */
	@Getter
	@Setter
	private Long childBranchCount;
	/**
	 * Created Date
	 */
	@Getter
	@Setter
	private Timestamp createdDate;
	/**
	 * Created By User Login
	 */
	@Getter
	@Setter
	private String createdByUserLogin;
	/**
	 * Last Modified Date
	 */
	@Getter
	@Setter
	private Timestamp lastModifiedDate;
	/**
	 * Last Modified By User Login
	 */
	@Getter
	@Setter
	private String lastModifiedByUserLogin;
	/**
	 * Data Resource Type Id
	 */
	@Getter
	@Setter
	private String dataResourceTypeId;
	/**
	 * Data Template Type Id
	 */
	@Getter
	@Setter
	private String dataTemplateTypeId;
	/**
	 * Data Category Id
	 */
	@Getter
	@Setter
	private String dataCategoryId;
	/**
	 * Data Resource Name
	 */
	@Getter
	@Setter
	private String dataResourceName;
	/**
	 * Object Info
	 */
	@Getter
	@Setter
	private String objectInfo;
	/**
	 * Survey Id
	 */
	@Getter
	@Setter
	private String surveyId;
	/**
	 * Survey Response Id
	 */
	@Getter
	@Setter
	private String surveyResponseId;
	/**
	 * Related Detail Id
	 */
	@Getter
	@Setter
	private String relatedDetailId;
	/**
	 * Is Public
	 */
	@Getter
	@Setter
	private String isPublic;

	public enum Fields {
		productCategoryId, contentId, prodCatContentTypeId, fromDate, thruDate, purchaseFromDate, purchaseThruDate, useCountLimit, useDaysLimit, contentTypeId, ownerContentId, decoratorContentId, instanceOfContentId, dataResourceId, templateDataResourceId, dataSourceId, statusId, privilegeEnumId, serviceName, customMethodId, contentName, description, localeString, mimeTypeId, characterSetId, childLeafCount, childBranchCount, createdDate, createdByUserLogin, lastModifiedDate, lastModifiedByUserLogin, dataResourceTypeId, dataTemplateTypeId, dataCategoryId, dataResourceName, objectInfo, surveyId, surveyResponseId, relatedDetailId, isPublic
	}

	public ProductCategoryContentAndInfo(GenericValue value) {
		productCategoryId = (String) value.get(Fields.productCategoryId.name());
		contentId = (String) value.get(Fields.contentId.name());
		prodCatContentTypeId = (String) value.get(Fields.prodCatContentTypeId
				.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		purchaseFromDate = (Timestamp) value
				.get(Fields.purchaseFromDate.name());
		purchaseThruDate = (Timestamp) value
				.get(Fields.purchaseThruDate.name());
		useCountLimit = (Long) value.get(Fields.useCountLimit.name());
		useDaysLimit = (BigDecimal) value.get(Fields.useDaysLimit.name());
		contentTypeId = (String) value.get(Fields.contentTypeId.name());
		ownerContentId = (String) value.get(Fields.ownerContentId.name());
		decoratorContentId = (String) value.get(Fields.decoratorContentId
				.name());
		instanceOfContentId = (String) value.get(Fields.instanceOfContentId
				.name());
		dataResourceId = (String) value.get(Fields.dataResourceId.name());
		templateDataResourceId = (String) value
				.get(Fields.templateDataResourceId.name());
		dataSourceId = (String) value.get(Fields.dataSourceId.name());
		statusId = (String) value.get(Fields.statusId.name());
		privilegeEnumId = (String) value.get(Fields.privilegeEnumId.name());
		serviceName = (String) value.get(Fields.serviceName.name());
		customMethodId = (String) value.get(Fields.customMethodId.name());
		contentName = (String) value.get(Fields.contentName.name());
		description = (String) value.get(Fields.description.name());
		localeString = (String) value.get(Fields.localeString.name());
		mimeTypeId = (String) value.get(Fields.mimeTypeId.name());
		characterSetId = (String) value.get(Fields.characterSetId.name());
		childLeafCount = (Long) value.get(Fields.childLeafCount.name());
		childBranchCount = (Long) value.get(Fields.childBranchCount.name());
		createdDate = (Timestamp) value.get(Fields.createdDate.name());
		createdByUserLogin = (String) value.get(Fields.createdByUserLogin
				.name());
		lastModifiedDate = (Timestamp) value
				.get(Fields.lastModifiedDate.name());
		lastModifiedByUserLogin = (String) value
				.get(Fields.lastModifiedByUserLogin.name());
		dataResourceTypeId = (String) value.get(Fields.dataResourceTypeId
				.name());
		dataTemplateTypeId = (String) value.get(Fields.dataTemplateTypeId
				.name());
		dataCategoryId = (String) value.get(Fields.dataCategoryId.name());
		dataResourceName = (String) value.get(Fields.dataResourceName.name());
		objectInfo = (String) value.get(Fields.objectInfo.name());
		surveyId = (String) value.get(Fields.surveyId.name());
		surveyResponseId = (String) value.get(Fields.surveyResponseId.name());
		relatedDetailId = (String) value.get(Fields.relatedDetailId.name());
		isPublic = (String) value.get(Fields.isPublic.name());
	}

	public static ProductCategoryContentAndInfo fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductCategoryContentAndInfo(value);
	}

	public static List<ProductCategoryContentAndInfo> fromValues(
			List<GenericValue> values) {
		List<ProductCategoryContentAndInfo> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductCategoryContentAndInfo(value));
		}
		return entities;
	}
}