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
 * Product Feature Data Resource
 */
@FieldNameConstants
public class ProductFeatureDataResource implements Serializable {

	public static final long serialVersionUID = 1739613179047165952L;
	public static final String NAME = "ProductFeatureDataResource";
	/**
	 * Data Resource Id
	 */
	@Getter
	@Setter
	private String dataResourceId;
	/**
	 * Product Feature Id
	 */
	@Getter
	@Setter
	private String productFeatureId;
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

	public ProductFeatureDataResource(GenericValue value) {
		dataResourceId = (String) value.get(FIELD_DATA_RESOURCE_ID);
		productFeatureId = (String) value.get(FIELD_PRODUCT_FEATURE_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProductFeatureDataResource fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductFeatureDataResource(value);
	}

	public static List<ProductFeatureDataResource> fromValues(
			List<GenericValue> values) {
		List<ProductFeatureDataResource> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductFeatureDataResource(value));
		}
		return entities;
	}
}