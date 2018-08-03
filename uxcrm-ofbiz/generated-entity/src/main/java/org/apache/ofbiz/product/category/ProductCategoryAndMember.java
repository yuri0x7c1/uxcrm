package org.apache.ofbiz.product.category;

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
public class ProductCategoryAndMember implements Serializable {

	public static final long serialVersionUID = 6405094131727216640L;
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

	public enum Fields {
		longDescription, productCategoryTypeId, detailScreen, description, linkTwoImageUrl, categoryName, productCategoryId, linkOneImageUrl, primaryParentCategoryId, categoryImageUrl, showInSelect, fromDate, comments, quantity, productId, sequenceNum, thruDate
	}

	public ProductCategoryAndMember(GenericValue value) {
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
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		comments = (String) value.get(Fields.comments.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		productId = (String) value.get(Fields.productId.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
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