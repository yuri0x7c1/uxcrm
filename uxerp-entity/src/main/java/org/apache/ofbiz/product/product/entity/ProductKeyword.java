package org.apache.ofbiz.product.product.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Keyword
 */
public class ProductKeyword implements Serializable {

	public static final long serialVersionUID = 5210102590561488896L;
	public static final String NAME = "ProductKeyword";
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Keyword
	 */
	@Getter
	@Setter
	private String keyword;
	/**
	 * Keyword Type Id
	 */
	@Getter
	@Setter
	private String keywordTypeId;
	/**
	 * Relevancy Weight
	 */
	@Getter
	@Setter
	private Long relevancyWeight;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;

	public enum Fields {
		productId, keyword, keywordTypeId, relevancyWeight, statusId
	}

	public ProductKeyword(GenericValue value) {
		productId = (String) value.get(Fields.productId.name());
		keyword = (String) value.get(Fields.keyword.name());
		keywordTypeId = (String) value.get(Fields.keywordTypeId.name());
		relevancyWeight = (Long) value.get(Fields.relevancyWeight.name());
		statusId = (String) value.get(Fields.statusId.name());
	}

	public static ProductKeyword fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductKeyword(value);
	}

	public static List<ProductKeyword> fromValues(List<GenericValue> values) {
		List<ProductKeyword> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductKeyword(value));
		}
		return entities;
	}
}