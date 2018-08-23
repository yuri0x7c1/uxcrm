package org.apache.ofbiz.product.category;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Category And Member
 */
@FieldNameConstants
public class ProductCategoryAndMember implements Serializable {

	public static final long serialVersionUID = 2258406142638652416L;
	public static final String NAME = "ProductCategoryAndMember";
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
	/**
	 * From Date
	 */
	@Getter
	@Setter
	private Timestamp fromDate;
	/**
	 * Comments
	 */
	@Getter
	@Setter
	private String comments;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
	/**
	 * Thru Date
	 */
	@Getter
	@Setter
	private Timestamp thruDate;

	public ProductCategoryAndMember(GenericValue value) {
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
		fromDate = (Timestamp) value.get(FIELD_FROM_DATE);
		comments = (String) value.get(FIELD_COMMENTS);
		quantity = (BigDecimal) value.get(FIELD_QUANTITY);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		sequenceNum = (Long) value.get(FIELD_SEQUENCE_NUM);
		thruDate = (Timestamp) value.get(FIELD_THRU_DATE);
	}

	public static ProductCategoryAndMember fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductCategoryAndMember(value);
	}

	public static List<ProductCategoryAndMember> fromValues(
			List<GenericValue> values) {
		List<ProductCategoryAndMember> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductCategoryAndMember(value));
		}
		return entities;
	}
}