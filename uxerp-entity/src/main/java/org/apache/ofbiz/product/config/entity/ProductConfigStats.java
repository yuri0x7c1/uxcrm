package org.apache.ofbiz.product.config.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Config Stats
 */
public class ProductConfigStats implements Serializable {

	public static final long serialVersionUID = 7689052163993540608L;
	public static final String NAME = "ProductConfigStats";
	/**
	 * Config Id
	 */
	@Getter
	@Setter
	private String configId;
	/**
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Num Of Confs
	 */
	@Getter
	@Setter
	private Long numOfConfs;
	/**
	 * Config Type Id
	 */
	@Getter
	@Setter
	private String configTypeId;

	public enum Fields {
		configId, productId, numOfConfs, configTypeId
	}

	public ProductConfigStats(GenericValue value) {
		configId = (String) value.get(Fields.configId.name());
		productId = (String) value.get(Fields.productId.name());
		numOfConfs = (Long) value.get(Fields.numOfConfs.name());
		configTypeId = (String) value.get(Fields.configTypeId.name());
	}

	public static ProductConfigStats fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductConfigStats(value);
	}

	public static List<ProductConfigStats> fromValues(List<GenericValue> values) {
		List<ProductConfigStats> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductConfigStats(value));
		}
		return entities;
	}
}