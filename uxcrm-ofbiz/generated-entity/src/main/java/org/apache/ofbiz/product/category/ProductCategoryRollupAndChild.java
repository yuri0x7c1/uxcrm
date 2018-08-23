package org.apache.ofbiz.product.category;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class ProductCategoryRollupAndChild implements Serializable {

	public static final long serialVersionUID = 7240402518611769344L;
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

	public ProductCategoryRollupAndChild(GenericValue value) {
		parentProductCategoryId = (String) value
				.get(FIELD_PARENT_PRODUCT_CATEGORY_ID);
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		longDescription = (String) value.get(FIELD_LONG_DESCRIPTION);
		productCategoryTypeId = (String) value
				.get(FIELD_PRODUCT_CATEGORY_TYPE_ID);
		detailScreen = (String) value.get(FIELD_DETAIL_SCREEN);
		description = (String) value.get(FIELD_DESCRIPTION);
		linkTwoImageUrl = (String) value.get(FIELD_LINK_TWO_IMAGE_URL);
		categoryName = (String) value.get(FIELD_CATEGORY_NAME);
		productCategoryId = (String) value.get(FIELD_PRODUCT_CATEGORY_ID);
		linkOneImageUrl = (String) value.get(FIELD_LINK_ONE_IMAGE_URL);
		primaryParentCategoryId = (String) value
				.get(FIELD_PRIMARY_PARENT_CATEGORY_ID);
		categoryImageUrl = (String) value.get(FIELD_CATEGORY_IMAGE_URL);
		showInSelect = (String) value.get(FIELD_SHOW_IN_SELECT);
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