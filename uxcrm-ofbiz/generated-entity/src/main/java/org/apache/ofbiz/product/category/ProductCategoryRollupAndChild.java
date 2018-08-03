package org.apache.ofbiz.product.category;

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

	public static final long serialVersionUID = 4444357075583559680L;
	public static final String NAME = "ProductCategoryRollupAndChild";
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
	/**
	 * Long Description
	 */
	@Getter
	@Setter
	private String longDescription;
	/**
	 * Product Category Type Id
	 */
	@Getter
	@Setter
	private String productCategoryTypeId;
	/**
	 * Detail Screen
	 */
	@Getter
	@Setter
	private String detailScreen;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Link Two Image Url
	 */
	@Getter
	@Setter
	private String linkTwoImageUrl;
	/**
	 * Category Name
	 */
	@Getter
	@Setter
	private String categoryName;
	/**
	 * Product Category Id
	 */
	@Getter
	@Setter
	private String productCategoryId;
	/**
	 * Link One Image Url
	 */
	@Getter
	@Setter
	private String linkOneImageUrl;
	/**
	 * Primary Parent Category Id
	 */
	@Getter
	@Setter
	private String primaryParentCategoryId;
	/**
	 * Category Image Url
	 */
	@Getter
	@Setter
	private String categoryImageUrl;
	/**
	 * Show In Select
	 */
	@Getter
	@Setter
	private String showInSelect;

	public enum Fields {
		parentProductCategoryId, fromDate, thruDate, sequenceNum, longDescription, productCategoryTypeId, detailScreen, description, linkTwoImageUrl, categoryName, productCategoryId, linkOneImageUrl, primaryParentCategoryId, categoryImageUrl, showInSelect
	}

	public ProductCategoryRollupAndChild(GenericValue value) {
		parentProductCategoryId = (String) value
				.get(Fields.parentProductCategoryId.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		longDescription = (String) value.get(Fields.longDescription.name());
		productCategoryTypeId = (String) value.get(Fields.productCategoryTypeId
				.name());
		detailScreen = (String) value.get(Fields.detailScreen.name());
		description = (String) value.get(Fields.description.name());
		linkTwoImageUrl = (String) value.get(Fields.linkTwoImageUrl.name());
		categoryName = (String) value.get(Fields.categoryName.name());
		productCategoryId = (String) value.get(Fields.productCategoryId.name());
		linkOneImageUrl = (String) value.get(Fields.linkOneImageUrl.name());
		primaryParentCategoryId = (String) value
				.get(Fields.primaryParentCategoryId.name());
		categoryImageUrl = (String) value.get(Fields.categoryImageUrl.name());
		showInSelect = (String) value.get(Fields.showInSelect.name());
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