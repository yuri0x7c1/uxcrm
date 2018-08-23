package org.apache.ofbiz.product.price;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Price Cond
 */
@FieldNameConstants
public class ProductPriceCond implements Serializable {

	public static final long serialVersionUID = 5162345760024267776L;
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

	public ProductPriceCond(GenericValue value) {
		productPriceRuleId = (String) value.get(FIELD_PRODUCT_PRICE_RULE_ID);
		productPriceCondSeqId = (String) value
				.get(FIELD_PRODUCT_PRICE_COND_SEQ_ID);
		inputParamEnumId = (String) value.get(FIELD_INPUT_PARAM_ENUM_ID);
		operatorEnumId = (String) value.get(FIELD_OPERATOR_ENUM_ID);
		condValue = (String) value.get(FIELD_COND_VALUE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
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