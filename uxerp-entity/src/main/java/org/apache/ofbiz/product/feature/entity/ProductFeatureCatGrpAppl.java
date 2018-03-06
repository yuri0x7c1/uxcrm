package org.apache.ofbiz.product.feature.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Feature Cat Grp Appl
 */
public class ProductFeatureCatGrpAppl implements Serializable {

	public static final long serialVersionUID = 6002924975498187776L;
	public static final String NAME = "ProductFeatureCatGrpAppl";
	/**
	 * Product Category Id
	 */
	@Getter
	@Setter
	private String productCategoryId;
	/**
	 * Product Feature Group Id
	 */
	@Getter
	@Setter
	private String productFeatureGroupId;
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

	public enum Fields {
		productCategoryId, productFeatureGroupId, fromDate, thruDate
	}

	public ProductFeatureCatGrpAppl(GenericValue value) {
		productCategoryId = (String) value.get(Fields.productCategoryId.name());
		productFeatureGroupId = (String) value.get(Fields.productFeatureGroupId
				.name());
		fromDate = (Timestamp) value.get(Fields.fromDate.name());
		thruDate = (Timestamp) value.get(Fields.thruDate.name());
	}

	public static ProductFeatureCatGrpAppl fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductFeatureCatGrpAppl(value);
	}

	public static List<ProductFeatureCatGrpAppl> fromValues(
			List<GenericValue> values) {
		List<ProductFeatureCatGrpAppl> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductFeatureCatGrpAppl(value));
		}
		return entities;
	}
}