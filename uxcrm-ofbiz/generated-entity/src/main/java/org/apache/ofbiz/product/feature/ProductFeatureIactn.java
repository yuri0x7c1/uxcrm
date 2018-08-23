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
 * Product Feature Iactn
 */
@FieldNameConstants
public class ProductFeatureIactn implements Serializable {

	public static final long serialVersionUID = 681960679042310144L;
	public static final String NAME = "ProductFeatureIactn";
	/**
	 * Product Feature Id
	 */
	@Getter
	@Setter
	private String productFeatureId;
	/**
	 * Product Feature Id To
	 */
	@Getter
	@Setter
	private String productFeatureIdTo;
	/**
	 * Product Feature Iactn Type Id
	 */
	@Getter
	@Setter
	private String productFeatureIactnTypeId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
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

	public ProductFeatureIactn(GenericValue value) {
		productFeatureId = (String) value.get(FIELD_PRODUCT_FEATURE_ID);
		productFeatureIdTo = (String) value.get(FIELD_PRODUCT_FEATURE_ID_TO);
		productFeatureIactnTypeId = (String) value
				.get(FIELD_PRODUCT_FEATURE_IACTN_TYPE_ID);
		productId = (String) value.get(FIELD_PRODUCT_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProductFeatureIactn fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductFeatureIactn(value);
	}

	public static List<ProductFeatureIactn> fromValues(List<GenericValue> values) {
		List<ProductFeatureIactn> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductFeatureIactn(value));
		}
		return entities;
	}
}