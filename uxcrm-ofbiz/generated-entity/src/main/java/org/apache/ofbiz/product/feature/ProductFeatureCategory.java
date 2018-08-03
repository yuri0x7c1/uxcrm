package org.apache.ofbiz.product.feature;

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
public class ProductFeatureCategory implements Serializable {

	public static final long serialVersionUID = 1626770911276306432L;
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

	public enum Fields {
		productFeatureCategoryId, parentCategoryId, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductFeatureCategory(GenericValue value) {
		productFeatureCategoryId = (String) value
				.get(Fields.productFeatureCategoryId.name());
		parentCategoryId = (String) value.get(Fields.parentCategoryId.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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