package org.apache.ofbiz.accounting.tax;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Tax Authority Category View
 */
public class TaxAuthorityCategoryView implements Serializable {

	public static final long serialVersionUID = 5176289432991235072L;
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

	public enum Fields {
		taxAuthPartyId, productCategoryId, taxAuthGeoId, longDescription, productCategoryTypeId, detailScreen, description, linkTwoImageUrl, categoryName, linkOneImageUrl, primaryParentCategoryId, categoryImageUrl, showInSelect
	}

	public TaxAuthorityCategoryView(GenericValue value) {
		taxAuthPartyId = (String) value.get(Fields.taxAuthPartyId.name());
		productCategoryId = (String) value.get(Fields.productCategoryId.name());
		taxAuthGeoId = (String) value.get(Fields.taxAuthGeoId.name());
		longDescription = (String) value.get(Fields.longDescription.name());
		productCategoryTypeId = (String) value.get(Fields.productCategoryTypeId
				.name());
		detailScreen = (String) value.get(Fields.detailScreen.name());
		description = (String) value.get(Fields.description.name());
		linkTwoImageUrl = (String) value.get(Fields.linkTwoImageUrl.name());
		categoryName = (String) value.get(Fields.categoryName.name());
		linkOneImageUrl = (String) value.get(Fields.linkOneImageUrl.name());
		primaryParentCategoryId = (String) value
				.get(Fields.primaryParentCategoryId.name());
		categoryImageUrl = (String) value.get(Fields.categoryImageUrl.name());
		showInSelect = (String) value.get(Fields.showInSelect.name());
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