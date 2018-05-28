package org.apache.ofbiz.product.feature;

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
public class ProductFeatureDataResource implements Serializable {

	public static final long serialVersionUID = 339838687467857920L;
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

	public enum Fields {
		dataResourceId, productFeatureId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductFeatureDataResource(GenericValue value) {
		dataResourceId = (String) value.get(Fields.dataResourceId.name());
		productFeatureId = (String) value.get(Fields.productFeatureId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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