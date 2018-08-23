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
 * Product Category
 */
@FieldNameConstants
public class ProductCategory implements Serializable {

	public static final long serialVersionUID = 8025921903520738304L;
	public static final String NAME = "ProductCategory";
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

	public ProductCategory(GenericValue value) {
		productCategoryId = (String) value.get(FIELD_PRODUCT_CATEGORY_ID);
		productCategoryTypeId = (String) value
				.get(FIELD_PRODUCT_CATEGORY_TYPE_ID);
		primaryParentCategoryId = (String) value
				.get(FIELD_PRIMARY_PARENT_CATEGORY_ID);
		categoryName = (String) value.get(FIELD_CATEGORY_NAME);
		description = (String) value.get(FIELD_DESCRIPTION);
		longDescription = (String) value.get(FIELD_LONG_DESCRIPTION);
		categoryImageUrl = (String) value.get(FIELD_CATEGORY_IMAGE_URL);
		linkOneImageUrl = (String) value.get(FIELD_LINK_ONE_IMAGE_URL);
		linkTwoImageUrl = (String) value.get(FIELD_LINK_TWO_IMAGE_URL);
		detailScreen = (String) value.get(FIELD_DETAIL_SCREEN);
		showInSelect = (String) value.get(FIELD_SHOW_IN_SELECT);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProductCategory fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductCategory(value);
	}

	public static List<ProductCategory> fromValues(List<GenericValue> values) {
		List<ProductCategory> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductCategory(value));
		}
		return entities;
	}
}