package org.apache.ofbiz.product.category.entity.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Category Rollup And Child
 */
public class ProductCategoryRollupAndChild implements Serializable {

	public static final long serialVersionUID = 7795885198735365120L;
	public static final String NAME = "ProductCategoryRollupAndChild";
	/**
	 * Product Category Id
	 */
	@Getter
	@Setter
	private String productCategoryId;
	/**
	 * Product Category Type Id
	 */
	@Getter
	@Setter
	private String productCategoryTypeId;
	/**
	 * Primary Parent Category Id
	 */
	@Getter
	@Setter
	private String primaryParentCategoryId;
	/**
	 * Category Name
	 */
	@Getter
	@Setter
	private String categoryName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Long Description
	 */
	@Getter
	@Setter
	private String longDescription;
	/**
	 * Category Image Url
	 */
	@Getter
	@Setter
	private String categoryImageUrl;
	/**
	 * Link One Image Url
	 */
	@Getter
	@Setter
	private String linkOneImageUrl;
	/**
	 * Link Two Image Url
	 */
	@Getter
	@Setter
	private String linkTwoImageUrl;
	/**
	 * Detail Screen
	 */
	@Getter
	@Setter
	private String detailScreen;
	/**
	 * Show In Select
	 */
	@Getter
	@Setter
	private String showInSelect;
	/**
	 * Parent Product Category Id
	 */
	@Getter
	@Setter
	private String parentProductCategoryId;
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
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;

	public enum Fields {
		productCategoryId, productCategoryTypeId, primaryParentCategoryId, categoryName, description, longDescription, categoryImageUrl, linkOneImageUrl, linkTwoImageUrl, detailScreen, showInSelect, parentProductCategoryId, fromDate, thruDate, sequenceNum
	}

	public ProductCategoryRollupAndChild(GenericValue value) {
		productCategoryId = (String) value.get(Fields.productCategoryId.name());
		productCategoryTypeId = (String) value.get(Fields.productCategoryTypeId
				.name());
		primaryParentCategoryId = (String) value
				.get(Fields.primaryParentCategoryId.name());
		categoryName = (String) value.get(Fields.categoryName.name());
		description = (String) value.get(Fields.description.name());
		longDescription = (String) value.get(Fields.longDescription.name());
		categoryImageUrl = (String) value.get(Fields.categoryImageUrl.name());
		linkOneImageUrl = (String) value.get(Fields.linkOneImageUrl.name());
		linkTwoImageUrl = (String) value.get(Fields.linkTwoImageUrl.name());
		detailScreen = (String) value.get(Fields.detailScreen.name());
		showInSelect = (String) value.get(Fields.showInSelect.name());
		parentProductCategoryId = (String) value
				.get(Fields.parentProductCategoryId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
	}

	public static ProductCategoryRollupAndChild fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductCategoryRollupAndChild(value);
	}

	public static List<ProductCategoryRollupAndChild> fromValues(
			List<GenericValue> values) {
		List<ProductCategoryRollupAndChild> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductCategoryRollupAndChild(value));
		}
		return entities;
	}
}