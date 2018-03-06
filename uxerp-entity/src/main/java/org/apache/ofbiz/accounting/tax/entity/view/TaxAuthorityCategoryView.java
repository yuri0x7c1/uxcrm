package org.apache.ofbiz.accounting.tax.entity.view;

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

	public static final long serialVersionUID = 6772250363617733632L;
	public static final String NAME = "TaxAuthorityCategoryView";
	/**
	 * Tax Auth Geo Id
	 */
	@Getter
	@Setter
	private String taxAuthGeoId;
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

	public enum Fields {
		taxAuthGeoId, taxAuthPartyId, productCategoryId, productCategoryTypeId, primaryParentCategoryId, categoryName, description, longDescription, categoryImageUrl, linkOneImageUrl, linkTwoImageUrl, detailScreen, showInSelect
	}

	public TaxAuthorityCategoryView(GenericValue value) {
		taxAuthGeoId = (String) value.get(Fields.taxAuthGeoId.name());
		taxAuthPartyId = (String) value.get(Fields.taxAuthPartyId.name());
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