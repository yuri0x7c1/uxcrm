package org.apache.ofbiz.product.config;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Config Item
 */
@FieldNameConstants
public class ProductConfigItem implements Serializable {

	public static final long serialVersionUID = 6568278147418190848L;
	public static final String NAME = "ProductConfigItem";
	/**
	 * Config Item Id
	 */
	@Getter
	@Setter
	private String configItemId;
	/**
	 * Config Item Type Id
	 */
	@Getter
	@Setter
	private String configItemTypeId;
	/**
	 * Config Item Name
	 */
	@Getter
	@Setter
	private String configItemName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Long Description
	 */
	@Getter
	@Setter
	private String longDescription;
	/**
	 * Image Url
	 */
	@Getter
	@Setter
	private String imageUrl;
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

	public ProductConfigItem(GenericValue value) {
		configItemId = (String) value.get(FIELD_CONFIG_ITEM_ID);
		configItemTypeId = (String) value.get(FIELD_CONFIG_ITEM_TYPE_ID);
		configItemName = (String) value.get(FIELD_CONFIG_ITEM_NAME);
		description = (String) value.get(FIELD_DESCRIPTION);
		longDescription = (String) value.get(FIELD_LONG_DESCRIPTION);
		imageUrl = (String) value.get(FIELD_IMAGE_URL);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProductConfigItem fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductConfigItem(value);
	}

	public static List<ProductConfigItem> fromValues(List<GenericValue> values) {
		List<ProductConfigItem> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductConfigItem(value));
		}
		return entities;
	}
}