package org.apache.ofbiz.product.feature;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Feature Appl Type
 */
public class ProductFeatureApplType implements Serializable {

	public static final long serialVersionUID = 7166254974616285184L;
	public static final String NAME = "ProductFeatureApplType";
	/**
	 * Product Feature Appl Type Id
	 */
	@Getter
	@Setter
	private String productFeatureApplTypeId;
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

	public enum Fields {
		productFeatureApplTypeId, parentTypeId, hasTable, description, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ProductFeatureApplType(GenericValue value) {
		productFeatureApplTypeId = (String) value
				.get(Fields.productFeatureApplTypeId.name());
		parentTypeId = (String) value.get(Fields.parentTypeId.name());
		hasTable = (String) value.get(Fields.hasTable.name());
		description = (String) value.get(Fields.description.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
	}

	public static ProductFeatureApplType fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductFeatureApplType(value);
	}

	public static List<ProductFeatureApplType> fromValues(
			List<GenericValue> values) {
		List<ProductFeatureApplType> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductFeatureApplType(value));
		}
		return entities;
	}
}