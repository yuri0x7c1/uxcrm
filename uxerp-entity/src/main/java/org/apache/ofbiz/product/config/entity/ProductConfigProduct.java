package org.apache.ofbiz.product.config.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Config Product
 */
public class ProductConfigProduct implements Serializable {

	public static final long serialVersionUID = 4003545872063268864L;
	public static final String NAME = "ProductConfigProduct";
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
	 * Product Id
	 */
	@Getter
	@Setter
	private String productId;
	/**
	 * Quantity
	 */
	@Getter
	@Setter
	private BigDecimal quantity;
	/**
	 * Sequence Num
	 */
	@Getter
	@Setter
	private Long sequenceNum;

	public enum Fields {
		configItemId, configOptionId, productId, quantity, sequenceNum
	}

	public ProductConfigProduct(GenericValue value) {
		configItemId = (String) value.get(Fields.configItemId.name());
		configOptionId = (String) value.get(Fields.configOptionId.name());
		productId = (String) value.get(Fields.productId.name());
		quantity = (BigDecimal) value.get(Fields.quantity.name());
		sequenceNum = (Long) value.get(Fields.sequenceNum.name());
	}

	public static ProductConfigProduct fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductConfigProduct(value);
	}

	public static List<ProductConfigProduct> fromValues(
			List<GenericValue> values) {
		List<ProductConfigProduct> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductConfigProduct(value));
		}
		return entities;
	}
}