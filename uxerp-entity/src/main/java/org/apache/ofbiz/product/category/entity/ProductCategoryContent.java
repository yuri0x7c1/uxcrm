package org.apache.ofbiz.product.category.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Category Content
 */
public class ProductCategoryContent implements Serializable {

	public static final long serialVersionUID = 1180846133437601792L;
	public static final String NAME = "ProductCategoryContent";
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

	public enum Fields {
		productCategoryId, contentId, prodCatContentTypeId, fromDate, thruDate, purchaseFromDate, purchaseThruDate, useCountLimit, useDaysLimit
	}

	public ProductCategoryContent(GenericValue value) {
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
	}

	public static ProductCategoryContent fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductCategoryContent(value);
	}

	public static List<ProductCategoryContent> fromValues(
			List<GenericValue> values) {
		List<ProductCategoryContent> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductCategoryContent(value));
		}
		return entities;
	}
}