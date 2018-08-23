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
 * Product Feature Iactn Type
 */
@FieldNameConstants
public class ProductFeatureIactnType implements Serializable {

	public static final long serialVersionUID = 5167130031063879680L;
	public static final String NAME = "ProductFeatureIactnType";
	/**
	 * Product Feature Iactn Type Id
	 */
	@Getter
	@Setter
	private String productFeatureIactnTypeId;
	/**
	 * Parent Type Id
	 */
	@Getter
	@Setter
	private String parentTypeId;
	/**
	 * Has Table
	 */
	@Getter
	@Setter
	private String hasTable;
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

	public ProductFeatureIactnType(GenericValue value) {
		productFeatureIactnTypeId = (String) value
				.get(FIELD_PRODUCT_FEATURE_IACTN_TYPE_ID);
		parentTypeId = (String) value.get(FIELD_PARENT_TYPE_ID);
		hasTable = (String) value.get(FIELD_HAS_TABLE);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProductFeatureIactnType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductFeatureIactnType(value);
	}

	public static List<ProductFeatureIactnType> fromValues(
			List<GenericValue> values) {
		List<ProductFeatureIactnType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductFeatureIactnType(value));
		}
		return entities;
	}
}