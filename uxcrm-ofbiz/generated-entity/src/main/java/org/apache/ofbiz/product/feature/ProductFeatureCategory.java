package org.apache.ofbiz.product.feature;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Feature Category
 */
@FieldNameConstants
public class ProductFeatureCategory implements Serializable {

	public static final long serialVersionUID = 4264538444488331264L;
	public static final String NAME = "ProductFeatureCategory";
	/**
	 * Product Feature Category Id
	 */
	@Getter
	@Setter
	private String productFeatureCategoryId;
	/**
	 * Parent Category Id
	 */
	@Getter
	@Setter
	private String parentCategoryId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
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

	public ProductFeatureCategory(GenericValue value) {
		productFeatureCategoryId = (String) value
				.get(FIELD_PRODUCT_FEATURE_CATEGORY_ID);
		parentCategoryId = (String) value.get(FIELD_PARENT_CATEGORY_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProductFeatureCategory fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductFeatureCategory(value);
	}

	public static List<ProductFeatureCategory> fromValues(
			List<GenericValue> values) {
		List<ProductFeatureCategory> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductFeatureCategory(value));
		}
		return entities;
	}
}