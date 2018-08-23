package org.apache.ofbiz.product.promo;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Product Promo Cond
 */
@FieldNameConstants
public class ProductPromoCond implements Serializable {

	public static final long serialVersionUID = 4970436738413423616L;
	public static final String NAME = "ProductPromoCond";
	/**
	 * Product Promo Id
	 */
	@Getter
	@Setter
	private String productPromoId;
	/**
	 * Product Promo Rule Id
	 */
	@Getter
	@Setter
	private String productPromoRuleId;
	/**
	 * Product Promo Cond Seq Id
	 */
	@Getter
	@Setter
	private String productPromoCondSeqId;
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
	 * Other Value
	 */
	@Getter
	@Setter
	private String otherValue;
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

	public ProductPromoCond(GenericValue value) {
		productPromoId = (String) value.get(FIELD_PRODUCT_PROMO_ID);
		productPromoRuleId = (String) value.get(FIELD_PRODUCT_PROMO_RULE_ID);
		productPromoCondSeqId = (String) value
				.get(FIELD_PRODUCT_PROMO_COND_SEQ_ID);
		inputParamEnumId = (String) value.get(FIELD_INPUT_PARAM_ENUM_ID);
		operatorEnumId = (String) value.get(FIELD_OPERATOR_ENUM_ID);
		condValue = (String) value.get(FIELD_COND_VALUE);
		otherValue = (String) value.get(FIELD_OTHER_VALUE);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ProductPromoCond fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ProductPromoCond(value);
	}

	public static List<ProductPromoCond> fromValues(List<GenericValue> values) {
		List<ProductPromoCond> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ProductPromoCond(value));
		}
		return entities;
	}
}