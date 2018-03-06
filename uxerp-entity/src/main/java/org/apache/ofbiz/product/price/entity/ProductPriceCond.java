package org.apache.ofbiz.product.price.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Price Cond
 */
public class ProductPriceCond implements Serializable {

	public static final long serialVersionUID = 4167393276302732288L;
	public static final String NAME = "ProductPriceCond";
	/**
	 * Product Price Rule Id
	 */
	@Getter
	@Setter
	private String productPriceRuleId;
	/**
	 * Product Price Cond Seq Id
	 */
	@Getter
	@Setter
	private String productPriceCondSeqId;
	/**
	 * Input Param Enum Id
	 */
	@Getter
	@Setter
	private String inputParamEnumId;
	/**
	 * Operator Enum Id
	 */
	@Getter
	@Setter
	private String operatorEnumId;
	/**
	 * Cond Value
	 */
	@Getter
	@Setter
	private String condValue;

	public enum Fields {
		productPriceRuleId, productPriceCondSeqId, inputParamEnumId, operatorEnumId, condValue
	}

	public ProductPriceCond(GenericValue value) {
		productPriceRuleId = (String) value.get(Fields.productPriceRuleId
				.name());
		productPriceCondSeqId = (String) value.get(Fields.productPriceCondSeqId
				.name());
		inputParamEnumId = (String) value.get(Fields.inputParamEnumId.name());
		operatorEnumId = (String) value.get(Fields.operatorEnumId.name());
		condValue = (String) value.get(Fields.condValue.name());
	}

	public static ProductPriceCond fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductPriceCond(value);
	}

	public static List<ProductPriceCond> fromValues(List<GenericValue> values) {
		List<ProductPriceCond> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductPriceCond(value));
		}
		return entities;
	}
}