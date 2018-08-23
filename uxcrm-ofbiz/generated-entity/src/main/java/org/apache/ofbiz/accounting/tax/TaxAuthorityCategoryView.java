package org.apache.ofbiz.accounting.tax;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Tax Authority Category View
 */
@FieldNameConstants
public class TaxAuthorityCategoryView implements Serializable {

	public static final long serialVersionUID = 839749619503538176L;
	public static final String NAME = "TaxAuthorityCategoryView";
	/**
	 * Tax Auth Party Id
	 */
	@Getter
	@Setter
	private String taxAuthPartyId;
	/**
	 * Product Category Id
	 */
	@Getter
	@Setter
	private String productCategoryId;
	/**
	 * Tax Auth Geo Id
	 */
	@Getter
	@Setter
	private String taxAuthGeoId;
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

	public TaxAuthorityCategoryView(GenericValue value) {
		taxAuthPartyId = (String) value.get(FIELD_TAX_AUTH_PARTY_ID);
		productCategoryId = (String) value.get(FIELD_PRODUCT_CATEGORY_ID);
		taxAuthGeoId = (String) value.get(FIELD_TAX_AUTH_GEO_ID);
		longDescription = (String) value.get(FIELD_LONG_DESCRIPTION);
		productCategoryTypeId = (String) value
				.get(FIELD_PRODUCT_CATEGORY_TYPE_ID);
		detailScreen = (String) value.get(FIELD_DETAIL_SCREEN);
		description = (String) value.get(FIELD_DESCRIPTION);
		linkTwoImageUrl = (String) value.get(FIELD_LINK_TWO_IMAGE_URL);
		categoryName = (String) value.get(FIELD_CATEGORY_NAME);
		linkOneImageUrl = (String) value.get(FIELD_LINK_ONE_IMAGE_URL);
		primaryParentCategoryId = (String) value
				.get(FIELD_PRIMARY_PARENT_CATEGORY_ID);
		categoryImageUrl = (String) value.get(FIELD_CATEGORY_IMAGE_URL);
		showInSelect = (String) value.get(FIELD_SHOW_IN_SELECT);
	}

	public static TaxAuthorityCategoryView fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new TaxAuthorityCategoryView(value);
	}

	public static List<TaxAuthorityCategoryView> fromValues(
			List<GenericValue> values) {
		List<TaxAuthorityCategoryView> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new TaxAuthorityCategoryView(value));
		}
		return entities;
	}
}