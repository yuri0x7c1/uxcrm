package org.apache.ofbiz.product.config.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Config Option
 */
public class ProductConfigOption implements Serializable {

	public static final long serialVersionUID = 8047072961297482752L;
	public static final String NAME = "ProductConfigOption";
	/**
	 * Config Item Id
	 */
	@Getter
	@Setter
	private String configItemId;
	/**
	 * Config Option Id
	 */
	@Getter
	@Setter
	private String configOptionId;
	/**
	 * Config Option Name
	 */
	@Getter
	@Setter
	private String configOptionName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;

	public enum Fields {
		configItemId, configOptionId, configOptionName, description, sequenceNum
	}

	public ProductConfigOption(GenericValue value) {
		configItemId = (String) value.get(Fields.configItemId.name());
		configOptionId = (String) value.get(Fields.configOptionId.name());
		configOptionName = (String) value.get(Fields.configOptionName.name());
		description = (String) value.get(Fields.description.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
	}

	public static ProductConfigOption fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductConfigOption(value);
	}

	public static List<ProductConfigOption> fromValues(List<GenericValue> values) {
		List<ProductConfigOption> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductConfigOption(value));
		}
		return entities;
	}
}