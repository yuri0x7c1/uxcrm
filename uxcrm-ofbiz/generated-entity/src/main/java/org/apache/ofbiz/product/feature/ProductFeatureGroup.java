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
 * Product Feature Group
 */
@FieldNameConstants
public class ProductFeatureGroup implements Serializable {

	public static final long serialVersionUID = 7202179670701671424L;
	public static final String NAME = "ProductFeatureGroup";
	/**
	 * Product Feature Group Id
	 */
	@Getter
	@Setter
	private String productFeatureGroupId;
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

	public ProductFeatureGroup(GenericValue value) {
		productFeatureGroupId = (String) value
				.get(FIELD_PRODUCT_FEATURE_GROUP_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProductFeatureGroup fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductFeatureGroup(value);
	}

	public static List<ProductFeatureGroup> fromValues(List<GenericValue> values) {
		List<ProductFeatureGroup> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductFeatureGroup(value));
		}
		return entities;
	}
}