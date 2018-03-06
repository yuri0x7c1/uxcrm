package org.apache.ofbiz.product.config.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Config Config
 */
public class ProductConfigConfig implements Serializable {

	public static final long serialVersionUID = 5939573356647951360L;
	public static final String NAME = "ProductConfigConfig";
	/**
	 * Config Id
	 */
	@Getter
	@Setter
	private String configId;
	/**
	 * Config Item Id
	 */
	@Getter
	@Setter
	private String configItemId;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;
	/**
	 * Config Option Id
	 */
	@Getter
	@Setter
	private String configOptionId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;

	public enum Fields {
		configId, configItemId, sequenceNum, configOptionId, description
	}

	public ProductConfigConfig(GenericValue value) {
		configId = (String) value.get(Fields.configId.name());
		configItemId = (String) value.get(Fields.configItemId.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
		configOptionId = (String) value.get(Fields.configOptionId.name());
		description = (String) value.get(Fields.description.name());
	}

	public static ProductConfigConfig fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductConfigConfig(value);
	}

	public static List<ProductConfigConfig> fromValues(List<GenericValue> values) {
		List<ProductConfigConfig> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductConfigConfig(value));
		}
		return entities;
	}
}