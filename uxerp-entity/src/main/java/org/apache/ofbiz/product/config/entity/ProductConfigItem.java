package org.apache.ofbiz.product.config.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Config Item
 */
public class ProductConfigItem implements Serializable {

	public static final long serialVersionUID = 6826118876038362112L;
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

	public enum Fields {
		configItemId, configItemTypeId, configItemName, description, longDescription, imageUrl
	}

	public ProductConfigItem(GenericValue value) {
		configItemId = (String) value.get(Fields.configItemId.name());
		configItemTypeId = (String) value.get(Fields.configItemTypeId.name());
		configItemName = (String) value.get(Fields.configItemName.name());
		description = (String) value.get(Fields.description.name());
		longDescription = (String) value.get(Fields.longDescription.name());
		imageUrl = (String) value.get(Fields.imageUrl.name());
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